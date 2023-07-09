package com.github.chalmery.rule.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * 操作符枚举
 */
@Getter
public enum OperatorEnum {
    PLUS('+', 1),
    MINUS('-', 1),
    MULTIPLY('*', 2),
    DIVIDE('/', 2),
    POWER('^', 3),
    LOGICAL_OR('|', 4),
    LOGICAL_AND('&', 5),
    LEFT_PAREN('(', 0),
    RIGHT_PAREN(')', 0);

    private final char operator;
    private final int precedence;

    OperatorEnum(char operator, int precedence) {
        this.operator = operator;
        this.precedence = precedence;
    }

    public static OperatorEnum parse(Character operator){
        if (Objects.isNull(operator)){
            return null;
        }
        for (OperatorEnum value : OperatorEnum.values()) {
            if (value.operator== operator){
                return value;
            }
        }
        return null;
    }
}
