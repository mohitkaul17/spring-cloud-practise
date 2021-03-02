package io.fullstacklabs.controller;


import io.fullstacklabs.model.CatalogItem;
import io.fullstacklabs.model.Movie;
import io.fullstacklabs.model.UserRating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@RefreshScope
@Slf4j
public class MovieCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        log.info("the catalog endpoint has been hit -- Retrieving the movie details... ");

        UserRating ratings = restTemplate.getForObject("http://rating-service/ratings/users/" + userId, UserRating.class);

        log.info("Mapping the rest template results ");
        assert ratings != null;
        return ratings.getUserRating().stream()
                .map(rating -> {
                    Movie movie = restTemplate.getForObject("http://info-service/movies/" + rating.getMovieId(), Movie.class);
                    return CatalogItem.builder()
                            .name(movie.getTitle())
                            .desc(movie.getOverview())
                            .rating(rating.getRating())
                            .build();
                }).collect(Collectors.toList());
    }
}