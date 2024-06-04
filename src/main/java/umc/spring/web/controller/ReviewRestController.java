package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.service.reviewService.ReviewQueryServiceImpl;
import umc.spring.service.reviewService.ReviewService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.RestaurantResponse;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewService reviewService;
    private final ReviewQueryServiceImpl reviewQueryService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponse.ReviewAddResultDTO> reviewAdd(@RequestBody @Valid ReviewRequest.ReviewAddDTO reviewAddDTO){
        return ApiResponse.onSuccess(reviewService.addReview(reviewAddDTO));
    }

    @GetMapping("/reviews/{memberId}")
    @Operation(summary = "내가 작성한 리뷰 조회 API",description = "내가 작성한 리뷰를 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponse.ReviewResponseListDTO> getMyReviewList(@PathVariable(name="memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        return ApiResponse.onSuccess(ReviewConverter.toReviewResponseListDTO(reviewQueryService.getReviewList(memberId, page)));
    }
}
