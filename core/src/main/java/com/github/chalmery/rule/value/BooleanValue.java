package com.github.chalmery.rule.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ycc
 * @date: 2023/7/11 下午11:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooleanValue extends BasicValue{

    private Boolean value;
}
