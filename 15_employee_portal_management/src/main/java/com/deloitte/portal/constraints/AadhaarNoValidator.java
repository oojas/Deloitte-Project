package com.deloitte.portal.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AadhaarNoValidator implements ConstraintValidator<AadhaarNoConstraint, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.isBlank()) {
			return true;
		}
		String regex="[0-9]+";
		return (value.matches(regex) && (value.length() == 12));
	}

}
