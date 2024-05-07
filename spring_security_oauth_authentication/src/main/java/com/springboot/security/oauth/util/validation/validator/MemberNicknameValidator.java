package com.springboot.security.oauth.util.validation.validator;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.springboot.security.oauth.util.validation.annotation.Nickname;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class MemberNicknameValidator implements ConstraintValidator<Nickname, String> {

    private int min;
    private int max;

    @Override
    public void initialize(Nickname constraintAnnotation) {
        //어노테이션 입력 시 파라미터로 들어온 값 초기화
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        try {
			value = URLDecoder.decode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //url로 넘어오는 특수문자 처리
        if(!StringUtils.hasText(value)){
            context.buildConstraintViolationWithTemplate("공백일 수 없습니다.").addConstraintViolation();
            return false;
        }

        if(value.length() < min || value.length() > max){
            context.buildConstraintViolationWithTemplate("닉네임은 "+min+"자 ~ "+max+"자 사이로 입력해주세요.").addConstraintViolation();
            return false;
        }

        return true;
    }
}
