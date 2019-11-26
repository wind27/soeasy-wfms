package com.souyidai.wfms.rules.apply.amountfixed;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 审批金额规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class AmountFixedRole extends Rule {

    public AmountFixedRole(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
