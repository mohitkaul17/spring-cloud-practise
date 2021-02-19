package io.fullstacklabs.controller;

import com.netflix.discovery.DiscoveryClient;
import io.fullstacklabs.model.CatalogItem;
import io.fullstacklabs.model.Movie;
import io.fullstacklabs.model.UserRating;
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
public class MovieCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating ratings = restTemplate.getForObject("http://rating-service/ratings/users/" + userId, UserRating.class);

        return ratings.getUserRating().stream()
                .map(rating -> {
                    //calling the info service to get the movie details
                    Movie movie = restTemplate.getForObject("http://info-service/movies/" + rating.getMovieId(), Movie.class);
                    //making the catalog from all the information
                    return CatalogItem.builder()
                            .name(movie.getName())
                            .desc("desc")
                            .rating(rating.getRating())
                            .build();
                }).collect(Collectors.toList());
    } 
}