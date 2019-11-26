package com.souyidai.wfms.rules.apply.loantype;

import com.souyidai.wfms.model.ApplyVO;
import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.model.RuleExecuteState;
import com.souyidai.wfms.model.RuleVO;
import com.souyidai.wfms.rules.Rule;
import com.souyidai.wfms.rules.apply.ApplyRuleAction;

/**
 * ComeCityIdRuleAction
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class LoanTypeRuleAction extends ApplyRuleAction {

    public LoanTypeRuleAction(RuleVO ruleVO, ApplyVO applyVO) {
        super(ruleVO, applyVO);
    }

    @Override
    public void go() {
        Rule rule = this.ruleVO.getRule();
        ApplyVO applyVO = this.applyVO;
        ComparisonOperator operator = rule.getOperator();
        Integer value = Integer.parseInt(rule.getValue());

        pass = ComparisonOperator.EQ.equals(operator) && value.equals(applyVO.getLoanType());
    }
}
