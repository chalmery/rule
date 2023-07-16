package com.github.chalmery.rule.test;


import com.github.chalmery.rule.entity.CommonRuleParam;
import com.github.chalmery.rule.process.CommonRuleProcess;
import org.junit.Test;

import java.util.HashMap;

public class ProcessTest {


    @Test
    public  void test1() {
        CommonRuleProcess commonRuleProcess = new CommonRuleProcess();
        CommonRuleParam param = new CommonRuleParam();
        commonRuleProcess.runRule(param);
        param.setValueMap(new HashMap<>(){{
            put("AAA",true);
            put("BBB",false);
            put("CCC",true);
            put("DDD",true);
        }});
        param.setExpress("!AAA||BBB&&(CCC||DDD)");
        System.out.println(commonRuleProcess.runRule(param).getValue());

    }


    @Test
    public  void test2() {
        CommonRuleProcess commonRuleProcess = new CommonRuleProcess();
        CommonRuleParam param = new CommonRuleParam();
        commonRuleProcess.runRule(param);
        param.setValueMap(new HashMap<>(){{
            put("AAA",true);
            put("BBB",false);
        }});
        param.setExpress("AAA||BBB");
        System.out.println(commonRuleProcess.runRule(param).getValue());

    }
}
