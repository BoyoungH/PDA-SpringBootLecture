package com.example.springbootlecture.domain.response;

import com.example.springbootlecture.domain.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Getter
public class MovieResponse {

    private  final long id;
    private  final String name;
    private  final Integer productionYear;

    public static MovieResponse of(Movie movie) {
        return new MovieResponse(movie.getId(), movie.getName(), movie.getProductionYear());
    }

}
