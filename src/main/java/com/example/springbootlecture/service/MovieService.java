package com.example.springbootlecture.service;
import com.example.springbootlecture.domain.request.MovieRequest;

import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.response.MovieResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final static List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init() {
        movies.addAll(List.of(
                new Movie(1, "코딩의 전설", 1998, LocalDateTime.now()),
                new Movie(2, "코딩의 후예", 2023, LocalDateTime.now()),
                new Movie(3, "코딩하이머", 2022, LocalDateTime.now())
        ));
    }

    public List<MovieResponse> getMovies() {

        return movies.stream().map(MovieResponse::of).toList();

        //Build 패턴 적용 예시
//        return movies.stream().map( movie ->
//                MovieResponse.builder()
//                        .id(movie.getId())
//                        .name(movie.getName())
//                        .productionYear(movie.getProductionYear())
//                        .build()
//        ).toList();
    }

    public Movie getMovie(long movieId) {
        return movies.stream()
                .filter(movie -> movie.getId() == movieId)
                .toList()
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public void createMovie(MovieRequest movieRequest) {
        Movie movie = new Movie(
                movies.size() + 1,
                movieRequest.getName(),
                movieRequest.getProductionYear(),
                LocalDateTime.now()
        );
        movies.add(movie);
    }

    public void updateMovie(long movieId, MovieRequest movieRequest) {
        Movie movie = getMovie(movieId);
        movie.setName(movieRequest.getName());
        movie.setProductionYear(movieRequest.getProductionYear());
    }

    public void deleteMovie(long movieId) {
        Movie movie = getMovie(movieId);
        movies.remove(movie);
    }
}
