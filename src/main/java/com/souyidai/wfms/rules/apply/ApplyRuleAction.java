package com.souyidai.wfms.rules.apply;

import com.souyidai.wfms.model.ApplyVO;
import com.souyidai.wfms.model.RuleExecuteState;
import com.souyidai.wfms.model.RuleVO;
import com.souyidai.wfms.rules.Rule;

/**
 * ComeCityIdRuleAction
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public abstract class ApplyRuleAction {

    /**
     * 规则vo
     */
    protected RuleVO ruleVO;

    /**
     * 进件信息
     */
    protected ApplyVO applyVO;

    public abstract void go();

    /**
     * 是否通过
     */
    protected boolean pass = false;

    public ApplyRuleAction(RuleVO ruleVO, ApplyVO applyVO) {
        this.ruleVO = ruleVO;
        this.applyVO = applyVO;
    }

    public RuleVO getRuleVO() {
        return ruleVO;
    }

    public void setRuleVO(RuleVO ruleVO) {
        this.ruleVO = ruleVO;
    }

    public ApplyVO getApplyVO() {
        return applyVO;
    }

    public void setApplyVO(ApplyVO applyVO) {
        this.applyVO = applyVO;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }
}
