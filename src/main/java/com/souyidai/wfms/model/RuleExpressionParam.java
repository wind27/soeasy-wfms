package com.souyidai.wfms.model;

import org.apache.commons.collections4.comparators.BooleanComparator;

/**
 * RuleExpressionParam
 *
 * @author qianchun
 * @date 2019/11/4
 **/
public class RuleExpressionParam {

    /**
     * 逻辑运算符
     */
    private String logicalOperator;

    /**
     * 左括号
     */
    private Boolean leftBracket;

    /**
     * 右括号
     */
    private Boolean rightBracket;

    /**
     * 规则类型
     */
    private String ruleType;

    /**
     * 比较运算符
     */
    private String comparisonOperator;

    /**
     * 值
     */
    private String value;

    public String getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(String logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public Boolean getLeftBracket() {
        return leftBracket;
    }

    public void setLeftBracket(Boolean leftBracket) {
        this.leftBracket = leftBracket;
    }

    public Boolean getRightBracket() {
        return rightBracket;
    }

    public void setRightBracket(Boolean rightBracket) {
        this.rightBracket = rightBracket;
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType;
    }

    public String getComparisonOperator() {
        return comparisonOperator;
    }

    public void setComparisonOperator(String comparisonOperator) {
        this.comparisonOperator = comparisonOperator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}