package umc.spring.web.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class RestaurantRequest {

    @Getter
    public static class RestaurantAddDTO{
        @Length(min = 1, max = 30)
        String name;

        @Length(min = 8, max = 8)
        String ownerCode;
    }
}
