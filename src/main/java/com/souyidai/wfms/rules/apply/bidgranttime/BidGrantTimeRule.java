package com.souyidai.wfms.rules.apply.bidgranttime;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 放款时间规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class BidGrantTimeRule extends Rule {
    public BidGrantTimeRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }
}
