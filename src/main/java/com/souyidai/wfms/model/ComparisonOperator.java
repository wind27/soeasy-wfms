package com.souyidai.wfms.model;

/**
 * 比较运算符
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public enum ComparisonOperator {
    /**
     * 等于
     */
    EQ("eq"),

    /**
     * 不等于
     */
    NEQ("neq"),

    /**
     * 大于
     */
    GT("gt"),

    /**
     * 大于等于
     */
    EGT("egt"),

    /**
     * 小于
     */
    LT("lt"),

    /**
     * 小于等于
     */
    ELT("elt"),

    /**
     * 不等于
     */
    NULL("null"),

    /**
     * like
     */
    LIKE("like"),

    /**
     * in
     */
    IN("in"),

    /**
     * not in
     */
    NOT_IN("not_in"),

    ;

    private String name;

    ComparisonOperator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
