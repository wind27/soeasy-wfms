package com.souyidai.wfms.rules.apply.loantype;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 产品名称规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class LoanTypeRule extends Rule {
    public LoanTypeRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }

    public synchronized static LoanTypeRule newInstance(ComparisonOperator operator, String value) {
        return new LoanTypeRule(operator, value);
    }
}
