package com.example.game_shelf.annotations;

import com.example.game_shelf.models.Game;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// Custom validator that checks whether the earned achievements is less than or equal to the total
public class AchievementsValidator implements ConstraintValidator<AchievementsValid, Object> {
    @Override
    public void initialize(AchievementsValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // Attach the error message to a specific field - achievementsEarned
        context.buildConstraintViolationWithTemplate("Earned achievements can't be higher than the total")
        .addPropertyNode("achievementsEarned")
        .addConstraintViolation();
        
        // Cast the value to the target object
        Game game = (Game) value;
        
        // Ensure that earned achievements are not higher than the total
        return game.getAchievementsEarned() <= game.getAchievementsTotal();
    }
}
