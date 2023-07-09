package com.github.chalmery.rule.express;

/**
 * 存储变量
 */
public class Variable extends AbstractExpress {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return name;
    }

}