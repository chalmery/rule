package com.github.chalmery.rule.utils;

import org.junit.Test;

public class ExpressUtilsTest {

    @Test
    public void inExpToPostExp() {
        //正常返回： AB+C*DE-F/+G+
        System.out.println(new ExpressUtils().inExpToPostExp("(A+B)*C+(D-E)/F+G"));

        //正常返回： 342*15-/+
        System.out.println(new ExpressUtils().inExpToPostExp("3+4*2/(1-5)"));
    }
}