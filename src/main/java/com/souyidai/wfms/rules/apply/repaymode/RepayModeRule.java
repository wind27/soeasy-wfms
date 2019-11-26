package com.souyidai.wfms.rules.apply.repaymode;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 还款方式规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class RepayModeRule extends Rule {

    public RepayModeRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
