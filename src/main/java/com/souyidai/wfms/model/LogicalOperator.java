package com.souyidai.wfms.model;

/**
 * 逻辑运算符
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public enum LogicalOperator {

    /**
     * 无
     */
    NULL("null", ""),

    /**
     * 逻辑与
     */
    AND("and", "&&"),

    /**
     * 逻辑或
     */
    OR("or", "||"),

    /**
     * 逻辑非
     */
    NOT("not", "!"),
    ;


    private String name;

    private String value;

    LogicalOperator(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
