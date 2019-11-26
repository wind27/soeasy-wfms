package com.souyidai.wfms.rules.apply.comecity;

import com.souyidai.wfms.model.ComparisonOperator;
import com.souyidai.wfms.rules.Rule;

/**
 * 进件城市规则
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class ComeCityIdRule extends Rule {
    private ComeCityIdRule(ComparisonOperator operator, String value) {
        super(operator, value);
    }

    public synchronized static ComeCityIdRule newInstance(ComparisonOperator operator, String value) {
        return new ComeCityIdRule(operator, value);
    }
}
