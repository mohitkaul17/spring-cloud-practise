package io.fullstacklabs.controller;

import io.fullstacklabs.model.Rating;
import io.fullstacklabs.model.UserRating;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
@RefreshScope
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {
        return Rating.builder()
                .rating(3.4)
                .movieId(movieId)
                .build();
    }

    //get all the ratings given by the user
    @GetMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable String userId) {
        List<Rating> ratings = Arrays.asList(
                Rating.builder()
                        .movieId("1")
                        .rating(3.5)
                        .build(),
                Rating.builder()
                        .movieId("2")
                        .rating(5.0)
                        .build()
        );
        return UserRating.builder().userRating(ratings).build();
    }


}
