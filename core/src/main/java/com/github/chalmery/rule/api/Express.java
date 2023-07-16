package com.github.chalmery.rule.api;

import com.github.chalmery.rule.entity.Context;
import com.github.chalmery.rule.value.BasicValue;

/**
 * @author: ycc
 * @date: 2023/7/11 下午11:15
 */
public interface Express {

    BasicValue interpret(Context context);
}
