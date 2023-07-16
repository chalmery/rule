package com.github.chalmery.rule.test;

public class Test {

    public static void main(String[] args) {
        Context context = new Context();

        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");

        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 2);

        // a + b + c
        AbstractExpress express = new PlusExprass(a,new PlusExprass(b, c));

        int result = express.interpret(context);
        
        System.out.println(result);
    }
}
