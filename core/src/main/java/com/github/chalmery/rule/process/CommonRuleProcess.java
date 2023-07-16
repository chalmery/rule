package com.github.chalmery.rule.process;

import com.github.chalmery.rule.api.Express;
import com.github.chalmery.rule.entity.CommonRuleParam;
import com.github.chalmery.rule.entity.Context;
import com.github.chalmery.rule.express.AndExpress;
import com.github.chalmery.rule.express.NotExpress;
import com.github.chalmery.rule.express.OrExpress;
import com.github.chalmery.rule.express.TerminalExpress;
import com.github.chalmery.rule.utils.ExpressUtils;
import com.github.chalmery.rule.value.BooleanValue;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Stack;

/**
 * 最基础的规则表达式，只对规则进行解析
 * @author: ycc
 * @date: 2023/7/11 下午11:27
 */
public class CommonRuleProcess extends AbstractRuleProcess<CommonRuleParam,BooleanValue>  {


    @Override
    public BooleanValue runRule(CommonRuleParam param) {
        String exp = param.getExpress();
        Map<String, Object> valueMap = param.getValueMap();
        if(StringUtils.isBlank(exp) || MapUtils.isEmpty(valueMap)){
            return null;
        }
        //转换为后缀表达式
        String postExp = ExpressUtils.inExpToPostExp(exp);
        if(StringUtils.isBlank(postExp)){
            return null;
        }
        Express express = buildExpress(postExp,valueMap);

        Context context = new Context(express);
        Object value = context.interpret();
        return new BooleanValue((Boolean) value);
    }

    private Express buildExpress(String postExp, Map<String, Object> valueMap) {
        Stack<Express> stack = new Stack<>();
        for (String value : postExp.split(" ")) {
            if (value.matches("[a-zA-Z0-9]+")) {
                stack.push(new TerminalExpress(valueMap.get(value)));
            }else if (value.equals("||")){
                Express right = stack.pop();
                Express left = stack.pop();
                OrExpress orExpress = new OrExpress(left,right);
                stack.push(orExpress);
            }else if (value.equals("&&")){
                Express right = stack.pop();
                Express left = stack.pop();
                AndExpress andExpress = new AndExpress(left,right);
                stack.push(andExpress);
            }else if(value.equals("!")){
                Express express = stack.pop();
                NotExpress notExpress = new NotExpress(express);
                stack.push(notExpress);
            }
        }
        return stack.pop();
    }

}
