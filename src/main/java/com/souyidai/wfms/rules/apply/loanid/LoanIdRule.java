package com.souyidai.wfms.rules.apply.loanid;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 进件id规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class LoanIdRule extends Rule {
    public LoanIdRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
