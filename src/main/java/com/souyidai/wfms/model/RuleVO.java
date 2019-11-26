package com.souyidai.wfms.model;

import com.souyidai.wfms.rules.Rule;

/**
 * Rule
 *
 * @author qianchun
 * @date 2019/11/4
 **/
public class RuleVO {

    /**
     * 逻辑运算符
     */
    private LogicalOperator operator;

    /**
     * 当前表达式
     */
    private Rule rule;

    /**
     * 下一个规则
     */
    private RuleVO next;

    /**
     * 左括号
     */
    private boolean leftBracket;

    /**
     * 右括号
     */
    private boolean rightBracket;

    public LogicalOperator getOperator() {
        return operator;
    }

    public void setOperator(LogicalOperator operator) {
        this.operator = operator;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public RuleVO getNext() {
        return next;
    }

    public void setNext(RuleVO next) {
        this.next = next;
    }

    public boolean isLeftBracket() {
        return leftBracket;
    }

    public void setLeftBracket(boolean leftBracket) {
        this.leftBracket = leftBracket;
    }

    public boolean isRightBracket() {
        return rightBracket;
    }

    public void setRightBracket(boolean rightBracket) {
        this.rightBracket = rightBracket;
    }
}
