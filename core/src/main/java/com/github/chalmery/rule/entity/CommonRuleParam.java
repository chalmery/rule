package com.github.chalmery.rule.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author: ycc
 * @date: 2023/7/16 下午4:20
 */
@Data
public class CommonRuleParam extends RuleParam{

    private Map<String,Object> valueMap;
}
