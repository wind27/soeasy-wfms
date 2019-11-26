package com.souyidai.wfms.rules.apply.periodsfixed;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 审批期限规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class PeriodsFixedRule extends Rule {

    public PeriodsFixedRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
