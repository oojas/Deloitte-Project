package com.deloitte.portal.constraints;

import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeConstraintValidator implements ConstraintValidator<AgeConstraint, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.isBlank()) {
			return false;
		}
		LocalDate dob = LocalDate.parse(value);
		LocalDate current;
		current= LocalDate.now();
		int age= Period.between(dob, current).getYears();
		if(age < 20) {
			return false;
		}
		return true;

	}
}
