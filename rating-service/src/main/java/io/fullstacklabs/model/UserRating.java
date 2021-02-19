package io.fullstacklabs.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {

    private List<Rating> userRating;
}
