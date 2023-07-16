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


    public static String inExpToPostExp(String inExpress) {
        if (StringUtils.isBlank(inExpress)) {
            return null;
        }
       Stack<Character> operatorStack = new Stack<>();

       StringBuilder express = new StringBuilder();

        char[] charArray = inExpress.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char operator = charArray[i];
            //左括弧入栈
            if (operator == OperatorEnum.LEFT_PAREN.getOperator()) {
                operatorStack.push(operator);
            }
            //右括弧出栈直到遇到(
            else if (operator == OperatorEnum.RIGHT_PAREN.getOperator()) {
                if (operatorStack.empty()){
                    throw new RuntimeException("表达式有误");
                }
                boolean flag = false;
                while (!operatorStack.empty()) {
                    Character character = operatorStack.pop();
                    if (character.equals(OperatorEnum.LEFT_PAREN.getOperator())){
                        flag = true;
                        break;
                    }
                    express.append(character);
                }
                //一直没有遇到左括弧呢
                if (!flag){
                    throw new RuntimeException("表达式有误");
                }
            }
            //字母或者数字
            else if(Character.isLetterOrDigit(operator)){
                StringBuilder operand = new StringBuilder();
                operand.append(operator);
                // 检查下一个字符，如果是字母或数字，继续连接
                while (i + 1 < charArray.length && (Character.isLetterOrDigit(charArray[i + 1]))) {
                    operand.append(charArray[i + 1]);
                    i++;
                }
                if (express.toString().endsWith(" ") || express.toString().isBlank()){
                    express.append(operand).append(" ");
                }else {
                    express.append(" ").append(operand).append(" ");
                }
            }
            // 逻辑运算符
            else if (OperatorEnum.isLogicalOperator(operator)) {
                OperatorEnum thisOperator = OperatorEnum.parse(operator);
                if (Objects.isNull(thisOperator)) {
                    throw new RuntimeException("操作符不支持");
                }
                while (!operatorStack.empty()) {
                    Character topOperator = operatorStack.peek();
                    if (topOperator == OperatorEnum.LEFT_PAREN.getOperator()) {
                        break;
                    }
                    if (topOperator == operator){
                        break;
                    }
                    express.append(operatorStack.pop());
                }
                operatorStack.push(operator);
            }

            //算术运算符 优先级大于等于当前的符号出栈
            else {
                OperatorEnum thisOperator = OperatorEnum.parse(operator);
                if (Objects.isNull(thisOperator)){
                    throw new RuntimeException("操作符不支持");
                }
                //算术运算符的左右必须为数字或者括号，并且表达式不能为最后一个
                if (i==charArray.length-1){
                    throw new RuntimeException("表达式有误");
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
                        express.append(pop).append(" ");
                    }
                }
                operatorStack.push(operator);
            }
        }
        if (!operatorStack.empty() && !express.toString().endsWith(" ")){
            express.append(" ");
        }
        //看栈内有没有数据
        while (!operatorStack.empty()){
            Character pop = operatorStack.pop();
            if (pop.equals(OperatorEnum.RIGHT_PAREN.getOperator()) || pop.equals(OperatorEnum.LEFT_PAREN.getOperator())) {
                throw new RuntimeException("表达式有误");
            }
            if (!operatorStack.empty() && OperatorEnum.isLogicalOperator(pop) && !operatorStack.peek().equals(pop)){
                express.append(" ");
            }
            express.append(pop);
        }
        return express.toString();
    }

}
