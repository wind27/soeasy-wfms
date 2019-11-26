package com.souyidai.wfms.model;

/**
 * ApplyVO
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class ApplyVO extends RoleModel{
    /**
     * 进件城市 come_city_id
     */
    private Integer comeCityId;

    /**
     * 还款方式 repay_mode
     */
    private Integer repayMode;

    /**
     * 资金通道 fund_channel
     */
    private Integer fundChannel;

    /**
     * 进件编号 loan_id
     */
    private String loanId;

    /**
     * 渠道 bid_channel
     */
    private Integer bidChannel;

    /**
     * 产品名称 loan_type
     */
    private Integer loanType;

    /**
     * 进件角色 broker_account
      */
    private Integer brokerAccount;

    /**
     * 标的状态 status
     */
    private Integer status;

    /**
     * 审批金额(万) amount_fixed
     */
    private Integer amountFixed;

    /**
     * 审批期限 periods_fixed
     */
    private Integer periodsFixed;

    /**
     * 放款时间 bid_grant_time
      */
    private Integer bidGrantTime;

    /**
     * 还款计划的期数
     */
    private Integer term;

    public Integer getComeCityId() {
        return comeCityId;
    }

    public void setComeCityId(Integer comeCityId) {
        this.comeCityId = comeCityId;
    }

    public Integer getRepayMode() {
        return repayMode;
    }

    public void setRepayMode(Integer repayMode) {
        this.repayMode = repayMode;
    }

    public Integer getFundChannel() {
        return fundChannel;
    }

    public void setFundChannel(Integer fundChannel) {
        this.fundChannel = fundChannel;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Integer getBidChannel() {
        return bidChannel;
    }

    public void setBidChannel(Integer bidChannel) {
        this.bidChannel = bidChannel;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Integer getBrokerAccount() {
        return brokerAccount;
    }

    public void setBrokerAccount(Integer brokerAccount) {
        this.brokerAccount = brokerAccount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAmountFixed() {
        return amountFixed;
    }

    public void setAmountFixed(Integer amountFixed) {
        this.amountFixed = amountFixed;
    }

    public Integer getPeriodsFixed() {
        return periodsFixed;
    }

    public void setPeriodsFixed(Integer periodsFixed) {
        this.periodsFixed = periodsFixed;
    }

    public Integer getBidGrantTime() {
        return bidGrantTime;
    }

    public void setBidGrantTime(Integer bidGrantTime) {
        this.bidGrantTime = bidGrantTime;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}
