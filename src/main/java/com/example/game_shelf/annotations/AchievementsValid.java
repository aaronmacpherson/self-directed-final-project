package com.example.game_shelf.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Custom annotation that uses the AchievementsValidator class to validate the achievements earned field
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AchievementsValidator.class)
public @interface AchievementsValid {
    String message() default "Earned achievements can't be higher than the total";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
