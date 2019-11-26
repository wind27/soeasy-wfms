package com.souyidai.wfms.rules.apply.borkeraccountrole;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 进件角色规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class BrokerAccountRole extends Rule {

    public BrokerAccountRole(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
