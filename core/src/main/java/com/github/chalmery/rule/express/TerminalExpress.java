package com.github.chalmery.rule.express;

import com.github.chalmery.rule.api.Express;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author: ycc
 * @date: 2023/7/16 下午7:43
 */
@AllArgsConstructor
@NoArgsConstructor
public class TerminalExpress implements Express {


    private Object value;

    @Override
    public Object interpret() {
        return value;
    }
}
