package com.itheima.bigeventbackend.validation;

import com.itheima.bigeventbackend.anno.StateValdate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;


import static com.itheima.bigeventbackend.constant.CommonConstants.STATES_TYPES;

public class StateValdation implements ConstraintValidator<StateValdate,String> {

//    检验State 数据是否正确
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(!StringUtils.hasText(value)){
            return false;
        }
        return STATES_TYPES.contains(value);
    }
}
