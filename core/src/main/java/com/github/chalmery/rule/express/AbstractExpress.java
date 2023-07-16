package com.github.chalmery.rule.express;

import com.github.chalmery.rule.api.Express;
import com.github.chalmery.rule.entity.Context;
import com.github.chalmery.rule.value.BasicValue;

/**
 * 抽象的表达式类
 */
public abstract class AbstractExpress implements Express {

    public abstract BasicValue interpret(Context context);

}
