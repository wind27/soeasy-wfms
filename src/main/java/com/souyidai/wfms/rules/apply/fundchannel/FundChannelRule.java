package com.souyidai.wfms.rules.apply.fundchannel;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 资金通道规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class FundChannelRule extends Rule {
    public FundChannelRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
