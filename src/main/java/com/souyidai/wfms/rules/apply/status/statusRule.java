package com.souyidai.wfms.rules.apply.status;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 标的状态规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class statusRule extends Rule {

    public statusRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
