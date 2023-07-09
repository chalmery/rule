package com.github.chalmery.rule.express;

/**
 * 减法表达式
 */
public class MinusExprass extends AbstractExpress {

    private AbstractExpress left;

    private AbstractExpress right;

    public MinusExprass(AbstractExpress left, AbstractExpress right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return "( %d - %d )".formatted(left.toString(), right.toString());
    }

}
