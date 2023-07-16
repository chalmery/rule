package com.github.chalmery.rule.test;

/**
 * 加法表达式
 */
public class PlusExprass extends AbstractExpress {

    private AbstractExpress left;

    private AbstractExpress right;

    public PlusExprass(AbstractExpress left, AbstractExpress right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "( %d + %d )".formatted(left.toString(), right.toString());
    }

}
