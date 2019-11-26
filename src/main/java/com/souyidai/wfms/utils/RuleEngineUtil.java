package com.souyidai.wfms.utils;

import com.souyidai.wfms.rules.apply.ApplyRuleExpression;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * RuleEngineUtil 规则引擎工具类
 *
 * @author qianchun
 * @date 2019/10/31
 **/
public class RuleEngineUtil {

    public static void exec(ApplyRuleExpression applyRuleEngine) {
        try {
            KieServices ks = KieServices.Factory.get();
            KieContainer kieContainer = ks.getKieClasspathContainer();
            KieSession kieSession = kieContainer.newKieSession("all-rules");

            kieSession.insert(applyRuleEngine);
            kieSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
