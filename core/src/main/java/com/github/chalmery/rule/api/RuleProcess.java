package com.github.chalmery.rule.api;

import com.github.chalmery.rule.entity.RuleParam;
import com.github.chalmery.rule.value.BasicValue;

/**
 * @author: ycc
 * @date: 2023/7/11 下午11:27
 */
public interface RuleProcess<P extends RuleParam,V extends BasicValue> {

    
    V runRule(P param);


}
