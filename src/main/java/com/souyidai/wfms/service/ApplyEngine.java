package com.souyidai.wfms.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.souyidai.wfms.model.*;
import com.souyidai.wfms.rules.apply.ApplyRuleExpression;
import com.souyidai.wfms.utils.RuleEngineUtil;
import com.souyidai.wfms.utils.RuleUtil;
import com.wind.common.ErrorCode;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserEngine
 *
 * @author qianchun
 * @date 2019/10/30
 **/
public class ApplyEngine {

    private static Logger logger = LoggerFactory.getLogger(ApplyEngine.class);

    public static void main(String[] args) {
        ApplyVO applyVO = RuleUtil.getApplyVO();
        JSONArray array = RuleUtil.getData();


        List<ApplyRuleExpression> applyRuleExpressionList = new ArrayList<>();
        List<RuleVO> list = RuleUtil.parseRuleVO(array.toJSONString());
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        for (RuleVO ruleVO : list) {
            ApplyRuleExpression applyRuleEngine = new ApplyRuleExpression(ruleVO, applyVO);
            RuleEngineUtil.exec(applyRuleEngine);
            applyRuleExpressionList.add(applyRuleEngine);
        }


//        flag = RuleUtil.checkExpressionBracket(applyRuleExpressionList);
//        if (!flag) {
//            logger.error("规则计算,规则表达式格式不正确, 规则表达式={}, 规则执行结果表达式={}",
//                    JSONObject.toJSON(array), RuleUtil.toString(applyRuleExpressionList));
//            return;
//        }

        System.out.println("******************************************************************************");

        Map<String, Boolean> data = new HashMap<>();
        ErrorCode errorCode = RuleUtil.getApplyRuleResult(data, applyRuleExpressionList);
        if(!ErrorCode.SUCCESS.equals(errorCode)) {
            logger.error("规则计算, 失败!\n规则计算结果={},\n规则逻辑表达式={},\n规则比较表达式={}",
                    JSONObject.toJSON(errorCode), JSONObject.toJSON(array), RuleUtil.toString(applyRuleExpressionList));
            return;
        }
        logger.info("规则计算, 完成!\n规则计算结果={},\n规则逻辑表达式={},\n规则比较表达式={}",
                JSONObject.toJSON(data), JSONObject.toJSON(array), RuleUtil.toString(applyRuleExpressionList));
    }

}
