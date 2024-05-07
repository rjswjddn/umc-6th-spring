package umc.spring.web.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.validation.annotation.ExistRestaurant;

public class ReviewRequest {
    @Getter
    public static class ReviewAddDTO{
        @ExistRestaurant
        Long restaurantId;

        @Max(5)
        @Min(0)
        float rating;

        @Length(max = 250)
        String content;

    }
}
