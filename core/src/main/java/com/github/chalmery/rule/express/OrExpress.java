package com.github.chalmery.rule.express;

import com.github.chalmery.rule.api.Express;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author: ycc
 * @date: 2023/7/11 下午11:18
 */
@AllArgsConstructor
@NoArgsConstructor
public class OrExpress extends AbstractExpress{

    private Express left;

    private Express right;


    @Override
    public Boolean interpret() {
        return (Boolean)left.interpret() || (Boolean) right.interpret();
    }
}
