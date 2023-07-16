package com.github.chalmery.rule.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class RuleParam implements Serializable{

    /**
     * 规则表达式
     */
    private String express;

    
}
