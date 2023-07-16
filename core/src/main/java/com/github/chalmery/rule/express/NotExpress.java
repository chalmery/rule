package com.github.chalmery.rule.express;

import com.github.chalmery.rule.api.Express;
import com.github.chalmery.rule.entity.Context;
import com.github.chalmery.rule.value.BooleanValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author: ycc
 * @date: 2023/7/11 下午11:18
 */
@AllArgsConstructor
@NoArgsConstructor
public class NotExpress extends AbstractExpress{

    private Express express;

    @Override
    public BooleanValue interpret(Context context) {
        BooleanValue rightValue = (BooleanValue) express.interpret(context);
        return new BooleanValue(!rightValue.getValue());
    }
}
