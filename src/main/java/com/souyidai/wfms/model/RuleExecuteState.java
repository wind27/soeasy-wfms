package com.souyidai.wfms.model;

/**
 * 规则执行结果状态
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public enum RuleExecuteState {
    WAITING(0, "待处理"),
    SUCCESS(1, "成功"),
    FAIL(2, "失败"),
    ;

    private Integer state;

    private String desc;

    RuleExecuteState(Integer state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
