package com.github.chalmery.rule.entity;

import com.github.chalmery.rule.api.Express;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * @author: ycc
 * @date: 2023/7/11 下午11:05
 */

@AllArgsConstructor
@NoArgsConstructor
public class Context {

    private Express express;


    public Object interpret() {
        return express.interpret();
    }
}
