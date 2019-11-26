package com.souyidai.wfms.rules.apply.bidchannel;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 渠道规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class BidChannelRule extends Rule {

    public BidChannelRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
