package com.souyidai.wfms.rules;

import com.souyidai.wfms.model.ComparisonOperator;

/**
 * 规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public abstract class Rule {

    /**
     * 比较运算符
     */
    protected ComparisonOperator operator;

    /**
     * 值
     */
    protected String value;

    public Rule(ComparisonOperator operator, String value) {
        this.operator = operator;
        this.value = value;
    }

    public ComparisonOperator getOperator() {
        return operator;
    }

    public void setOperator(ComparisonOperator operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
