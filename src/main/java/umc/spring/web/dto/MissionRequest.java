package umc.spring.web.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class MissionRequest {

    @Getter
    public static class MissionAddDTO{
        @Min(0)
        Long point;

        @Min(0)
        Long price;
    }
}
