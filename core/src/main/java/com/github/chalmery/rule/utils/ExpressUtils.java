package com.github.chalmery.rule.utils;

import com.github.chalmery.rule.enums.OperatorEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Stack;

/**
 * 转换表达式
 * 3+4*2/(1-5) ====> 3 4 2 * 1 5 - / +
 * (A+B)*C+(D-E)/F+G     ====> A B + C * D E - F / + G +
 */
public class ExpressUtils {

    private Stack<Character> operatorStack = new Stack<>();

    private StringBuilder express = new StringBuilder();

    public String inExpToPostExp(String inExpress) {
        if (StringUtils.isBlank(inExpress)) {
            return null;
        }
        for (char operator : inExpress.toCharArray()) {
            //左括弧入栈
            if (operator == OperatorEnum.LEFT_PAREN.getOperator()) {
                operatorStack.push(operator);
            }
            //右括弧出栈直到遇到(
            else if (operator == OperatorEnum.RIGHT_PAREN.getOperator()) {
                Character stackPop = operatorStack.pop();
                if (Objects.isNull(stackPop) || stackPop.equals(OperatorEnum.LEFT_PAREN.getOperator())) {
                    throw new RuntimeException("表达式有误");
                }
                express.append(stackPop);
                while (!operatorStack.empty()) {
                    Character character = operatorStack.pop();
                    if (character.equals(OperatorEnum.LEFT_PAREN.getOperator())){
                        break;
                    }
                    express.append(stackPop);
                }
            }
            //字母或者数字
            else if(Character.isLetterOrDigit(operator)){
                express.append(operator);
            }
            //符号 优先级大于等于当前的符号出栈
            else {
                OperatorEnum thisOperator = OperatorEnum.parse(operator);
                if (Objects.isNull(thisOperator)){
                    throw new RuntimeException("操作符不支持");
                }
                while (!operatorStack.empty()){
                    Character pop = operatorStack.pop();
                    OperatorEnum operatorEnum = OperatorEnum.parse(pop);
                    if (Objects.isNull(operatorEnum)){
                        throw new RuntimeException("操作符不支持");
                    }
                    if (operatorEnum.getPrecedence()<thisOperator.getPrecedence()) {
                        operatorStack.push(pop);
                        break;
                    }else {
                        express.append(pop);
                    }
                }
                operatorStack.push(operator);
            }
        }
        //看栈内有没有数据
        while (!operatorStack.empty()){
            Character pop = operatorStack.pop();
            if (pop.equals(OperatorEnum.RIGHT_PAREN.getOperator()) || pop.equals(OperatorEnum.LEFT_PAREN.getOperator())) {
                throw new RuntimeException("表达式有误");
            }
            express.append(pop);
        }
        return express.toString();
    }

}
