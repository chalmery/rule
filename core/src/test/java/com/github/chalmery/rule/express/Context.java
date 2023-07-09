package com.github.chalmery.rule.express;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文
 */
public class Context {

    private Map<Variable, Integer> map = new HashMap<>();

    public void assign(Variable variable, Integer value) {
        map.put(variable, value);
    }

    public int getValue(Variable variable) {
        return map.get(variable);
    }
}
