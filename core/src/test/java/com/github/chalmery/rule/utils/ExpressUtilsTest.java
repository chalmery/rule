package com.github.chalmery.rule.utils;

import com.alibaba.fastjson2.JSON;
import org.junit.Test;

import java.util.Arrays;

public class ExpressUtilsTest {

    @Test
    public void inExpToPostExp() {
        //正常返回： AB+C*DE-F/+G+
        String result = ExpressUtils.inExpToPostExp("(AA+BB)*CC+(DD-EE)/FF+GG");
        System.out.println(result);
        if (result != null) {
            System.out.println(JSON.toJSONString(Arrays.asList(result.split(" "))));
        }
        //正常返回： 342*15-/+
//        System.out.println(new ExpressUtils().inExpToPostExp("3+4*2/(1-5)-"));

        // A ! B || C D || &&
//        String result = ExpressUtils.inExpToPostExp("!AAA||BBB&&(CCC||DDD)");
//        System.out.println(JSON.toJSONString(Arrays.asList(result.split(" "))));

        // AB || C D || &&
//        System.out.println(new ExpressUtils().inExpToPostExp("(A||B)&&(C||D)"));
    }
}