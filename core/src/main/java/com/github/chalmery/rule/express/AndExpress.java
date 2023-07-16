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
public class AndExpress extends AbstractExpress{

    private Express left;

    private Express right;


    @Override
    public BooleanValue interpret(Context context) {
        BooleanValue leftValue = (BooleanValue) left.interpret(context);
        BooleanValue rightValue = (BooleanValue) right.interpret(context);
        return new BooleanValue(leftValue.getValue() && rightValue.getValue());
    }
}
