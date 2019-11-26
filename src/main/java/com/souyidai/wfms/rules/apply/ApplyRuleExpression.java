package com.souyidai.wfms.rules.apply;

import com.souyidai.wfms.model.ApplyVO;
import com.souyidai.wfms.model.RuleVO;
import com.souyidai.wfms.rules.apply.comecity.ComeCityIdRule;
import com.souyidai.wfms.rules.apply.comecity.ComeCityIdRuleAction;
import com.souyidai.wfms.rules.apply.loantype.LoanTypeRule;
import com.souyidai.wfms.rules.apply.loantype.LoanTypeRuleAction;

/**
 * 进件规则表达式
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class ApplyRuleExpression {

    private ApplyRuleAction action;

    public ApplyRuleExpression(RuleVO ruleVO, ApplyVO applyVO) {
        if (ruleVO.getRule() instanceof ComeCityIdRule) {
            action = new ComeCityIdRuleAction(ruleVO, applyVO);
        } else if (ruleVO.getRule() instanceof LoanTypeRule) {
            action = new LoanTypeRuleAction(ruleVO, applyVO);
        }
    }

    /**
     * 校验规则是否匹配
     * 
     * @return 返回结果
     */
    public boolean match(Class<?> clazz) {
        return action.ruleVO.getRule().getClass() == clazz;
    }

    /**
     * 执行规则
     */
    public void go() {
        action.go();
    }

//    /**
//     * 获取执行结果
//     *
//     * @return 返回结果
//     */
//    public boolean getState() {
//        return action.state;
//    }

    public ApplyRuleAction getAction() {
        return action;
    }

    public void setAction(ApplyRuleAction action) {
        this.action = action;
    }
}
