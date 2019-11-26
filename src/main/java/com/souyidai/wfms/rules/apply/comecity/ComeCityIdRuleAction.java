package com.souyidai.wfms.rules.apply.comecity;

import com.souyidai.wfms.model.ApplyVO;
import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.model.RuleVO;
import com.souyidai.wfms.rules.Rule;
import com.souyidai.wfms.rules.apply.ApplyRuleAction;

/**
 * ComeCityIdRuleAction
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class ComeCityIdRuleAction extends ApplyRuleAction {

    public ComeCityIdRuleAction(RuleVO ruleVO, ApplyVO applyVO) {
        super(ruleVO, applyVO);
    }

    @Override
    public void go() {
        Rule rule = this.ruleVO.getRule();
        ApplyVO applyVO = this.applyVO;
        ComparisonOperator operator = rule.getOperator();
        Integer value = Integer.parseInt(rule.getValue());

        if (operator == null || applyVO == null || applyVO.getComeCityId() == null) {
            pass = false;
        } else if (ComparisonOperator.EQ.equals(operator) && applyVO.getComeCityId().equals(value)) {
            pass = true;
        } else if (ComparisonOperator.NEQ.equals(operator) && !applyVO.getComeCityId().equals(value)) {
            pass = true;
        } else {
            pass = false;
        }
    }
}
