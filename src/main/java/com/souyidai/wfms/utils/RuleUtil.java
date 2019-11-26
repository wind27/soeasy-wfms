package com.souyidai.wfms.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.souyidai.wfms.model.*;
import com.souyidai.wfms.rules.Rule;
import com.souyidai.wfms.rules.apply.ApplyRuleExpression;
import com.souyidai.wfms.rules.apply.comecity.ComeCityIdRule;
import com.souyidai.wfms.rules.apply.loantype.LoanTypeRule;
import com.wind.auth.model.App;
import com.wind.common.ErrorCode;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * RuleUtil
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class RuleUtil {
    private static Logger logger = LoggerFactory.getLogger(RuleUtil.class);

    private static ThreadLocal<Boolean> applyRuleResultFlag = new ThreadLocal<>();

    public static List<RuleVO> parseRuleVO(String expression) {
        if (StringUtils.isEmpty(expression)) {
            return null;
        }
        List<RuleVO> ruleVOList = new ArrayList<>();

        List<RuleExpressionParam> list = parseRuleExpressionParam(expression);

        if (CollectionUtils.isEmpty(list)) {
            logger.error("封装规则表达式,解析异常,参数逻辑表达式={}", expression);
            return null;
        }

        for (RuleExpressionParam param : list) {
            if (param == null) {
                logger.error("封装规则表达式,列表有空,参数逻辑表达式={}", expression);
                return null;
            }

            if (param.getLogicalOperator() == null || param.getLeftBracket() == null || param.getRightBracket() == null
                    || param.getRuleType() == null || param.getComparisonOperator() == null
                    || param.getValue() == null) {
                logger.error("封装规则表达式,部分参数为空,参数逻辑表达式={}", expression);
                return null;
            }

            if (ComparisonOperator.valueOf(param.getComparisonOperator()) == null
                    || LogicalOperator.valueOf(param.getLogicalOperator()) == null) {
                logger.error("封装规则表达式,运算符错误,参数逻辑表达式={}", expression);
                return null;
            }

            Rule rule = null;
            if (param.getRuleType().equals("comeCityId")) {
                rule = ComeCityIdRule.newInstance(ComparisonOperator.valueOf(param.getComparisonOperator()), param.getValue());
            } else if (param.getRuleType().equals("loanType")) {
                rule = LoanTypeRule.newInstance(ComparisonOperator.valueOf(param.getComparisonOperator()), param.getValue());
            }
            RuleVO vo = new RuleVO();
            vo.setRule(rule);
            vo.setLeftBracket(param.getLeftBracket());
            vo.setRightBracket(param.getRightBracket());
            vo.setOperator(LogicalOperator.valueOf(param.getLogicalOperator()));
            ruleVOList.add(vo);
        }
        return ruleVOList;
    }

    public static ApplyVO getApplyVO() {
        ApplyVO applyVO = new ApplyVO();
        applyVO.setComeCityId(3100010);
        applyVO.setLoanType(51);
        return applyVO;
    }

    public static JSONArray getData() {
        JSONArray array = new JSONArray();

        JSONObject json = new JSONObject();
        json.put("logicalOperator", LogicalOperator.AND);
        json.put("leftBracket", true);
        json.put("rightBracket", true);

        json.put("ruleType", "comeCityId");
        json.put("comparisonOperator", ComparisonOperator.EQ);
        json.put("value", "3100010");
        array.add(json);

        json = new JSONObject();
        json.put("logicalOperator", LogicalOperator.AND);
        json.put("leftBracket", false);
        json.put("rightBracket", true);

        json.put("ruleType", "loanType");
        json.put("comparisonOperator", ComparisonOperator.EQ);
        json.put("value", "50");
        array.add(json);

        json = new JSONObject();
        json.put("logicalOperator", LogicalOperator.OR);
        json.put("leftBracket", true);
        json.put("rightBracket", false);

        json.put("ruleType", "comeCityId");
        json.put("comparisonOperator", ComparisonOperator.EQ);
        json.put("value", "3100010");
        array.add(json);

        json = new JSONObject();
        json.put("logicalOperator", LogicalOperator.OR);
        json.put("leftBracket", false);
        json.put("rightBracket", false);

        json.put("ruleType", "comeCityId");
        json.put("comparisonOperator", ComparisonOperator.EQ);
        json.put("value", "3100010");
        array.add(json);

        json = new JSONObject();
        json.put("logicalOperator", LogicalOperator.OR);
        json.put("leftBracket", false);
        json.put("rightBracket", true);

        json.put("ruleType", "comeCityId");
        json.put("comparisonOperator", ComparisonOperator.EQ);
        json.put("value", "3100010");
        array.add(json);

        return array;
    }

    public static RuleVO parseRuleVO(Rule rule, LogicalOperator operator, boolean leftBracket, boolean rightBracket) {
        if (rule == null || operator == null) {
            return null;
        }
        RuleVO ruleVO = new RuleVO();
        ruleVO.setRule(rule);
        ruleVO.setOperator(operator);

        ruleVO.setLeftBracket(leftBracket);
        ruleVO.setRightBracket(rightBracket);
        return ruleVO;
    }

    // ------------------------------------------------------------------------------------------------------------------

    public static ErrorCode getApplyRuleResult(Map<String, Boolean> data, List<ApplyRuleExpression> list) {
        applyRuleResultFlag.set(true);
        boolean flag = dealApplyRuleExpression(list);
        if(!flag) {
            return ErrorCode.FAIL;
        }
        data.put("pass", applyRuleResultFlag.get());
        return ErrorCode.SUCCESS;

    }

    /**
     * 规则表达式列表处理
     *
     * @param list 规则逻辑表达式列表
     */
    private static boolean dealApplyRuleExpression(List<ApplyRuleExpression> list) {
        List<ApplyRuleExpression> waitList = new ArrayList<>();
        for (ApplyRuleExpression engine : list) {
            waitList.add(engine);
            if (!isCompleteCalculation(waitList)) {
                continue;
            }
            calculation(waitList);
            if (waitList.size() == list.size()) {
                continue;
            }
            calculation(list.subList(waitList.size(), list.size()));
            waitList.clear();
        }

        if (CollectionUtils.isNotEmpty(waitList)) {
            logger.error("规则表达式列表处理,规则逻辑不正确,待计算规则表达式列表={}", toString(waitList));
            return false;
        }
        return true;
    }

    /**
     * 规则表达式计算
     *
     * @param waitList 待计算规则逻辑表达式列表
     */
    private static void calculation(List<ApplyRuleExpression> waitList) {
        boolean flag = applyRuleResultFlag.get();
        if (CollectionUtils.isNotEmpty(waitList)) {
            for (ApplyRuleExpression engine : waitList) {
                if (LogicalOperator.AND.equals(engine.getAction().getRuleVO().getOperator())) {
                    flag = (flag && engine.getAction().isPass());
                } else if (LogicalOperator.OR.equals(engine.getAction().getRuleVO().getOperator())) {
                    flag = (flag || engine.getAction().isPass());
                }
            }
        }
        applyRuleResultFlag.set(flag);
    }

    /**
     * 是否完整计算
     *
     * @param waitList list
     * @return 返回结果
     */
    private static boolean isCompleteCalculation(List<ApplyRuleExpression> waitList) {
        if (CollectionUtils.isEmpty(waitList)) {
            return false;
        }
        boolean hasLeft = false;
        boolean hasRight = false;

        for (ApplyRuleExpression engine : waitList) {
            RuleVO ruleVO = engine.getAction().getRuleVO();

            if ((!hasLeft) && ruleVO.isLeftBracket()) {
                hasLeft = true;
            } else if (ruleVO.isLeftBracket()) {
                return false;
            }

            if ((hasLeft && !hasRight) && ruleVO.isRightBracket()) {
                hasRight = true;
            } else if (ruleVO.isRightBracket()) {
                return false;
            }
        }
        return !hasLeft || hasRight;
    }

    /**
     * 校验规则逻辑表达式是否正确
     * 
     * @param list 规则逻辑表达式
     * @return 返回结果
     */
    public static boolean checkExpressionBracket(List<ApplyRuleExpression> list) {
        if (CollectionUtils.isEmpty(list)) {
            return false;
        }
        boolean leftBracket = false;
        boolean rightBracket = false;

        for (ApplyRuleExpression engine : list) {
            RuleVO ruleVO = engine.getAction().getRuleVO();

            if ((!leftBracket) && ruleVO.isLeftBracket()) {
                leftBracket = true;
            } else if (ruleVO.isLeftBracket()) {
                return false;
            }

            if ((leftBracket) && ruleVO.isRightBracket()) {
                rightBracket = true;
            } else if (ruleVO.isRightBracket()) {
                return false;
            }

            if (leftBracket && rightBracket) {
                leftBracket = false;
                rightBracket = false;
            }
        }
        return !leftBracket;
    }

    /**
     * toString
     *
     * @param list 列表
     * @return 返回结果
     */
    public static String toString(List<ApplyRuleExpression> list) {
        StringBuilder sb = new StringBuilder();
        if (CollectionUtils.isNotEmpty(list)) {
            list.forEach(engine -> {
                RuleVO ruleVO = engine.getAction().getRuleVO();
                sb.append(" ").append(ruleVO.getOperator().getValue()).append(" ")
                        .append(ruleVO.isLeftBracket() ? "(" : "").append(engine.getAction().isPass())
                        .append(ruleVO.isRightBracket() ? ")" : "");
            });
        }
        return sb.toString();
    }

    public static List<RuleExpressionParam> parseRuleExpressionParam(String param) {
        return JSON.parseObject(param, new TypeReference<List<RuleExpressionParam>>() {
        });
    }

    public static void main(String[] args) {
        String param = "[{\"logicalOperator\":\"null\",\"leftBracket\":true,\"rightBracket\":true,\"ruleType\":\"comeCityId\",\"comparisonOperator\":\"eq\",\"value\":12121},{\"logicalOperator\":\"null\",\"leftBracket\":true,\"rightBracket\":true,\"ruleType\":\"comeCityId\",\"comparisonOperator\":\"eq\",\"value\":12121}]";
        List<RuleExpressionParam> list = parseRuleExpressionParam(param);
        System.out.println(JSONObject.toJSON(list));
    }
}
