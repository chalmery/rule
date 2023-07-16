package com.github.chalmery.rule.express;

import com.github.chalmery.rule.api.Express;

/**
 * 抽象的表达式类
 */
public abstract class AbstractExpress implements Express {

    public abstract Object interpret();

}
