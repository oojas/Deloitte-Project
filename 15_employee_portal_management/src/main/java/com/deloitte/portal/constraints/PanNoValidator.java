package com.deloitte.portal.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PanNoValidator implements ConstraintValidator<PanNoConstraint, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String regexp="[A-Z0-9]+";
		
		if(value.isEmpty()) {
			return true;
		}
		return ((value.matches(regexp) && (value.length() == 10)));
	}
}
