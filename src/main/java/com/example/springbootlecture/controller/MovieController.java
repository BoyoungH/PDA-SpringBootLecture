package com.example.springbootlecture.controller;
import com.example.springbootlecture.common.Response;
import com.example.springbootlecture.domain.request.MovieRequest;

import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.response.MovieResponse;
import com.example.springbootlecture.service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/api/v1/movies")
    public Response<List<MovieResponse>> getMovies() {
        return Response.of(movieService.getMovies());
    }

    @GetMapping("/api/v1/movies/{movieId}")
    public Response<MovieResponse> getMovie(
            @PathVariable(value = "movieId") long movieId
    ) {
        return Response.of(movieService.getMovie(movieId));
    }

    @PostMapping("/api/v1/movies")
    public void saveMovie(@RequestBody MovieRequest movieRequest) {
        movieService.saveMovie(movieRequest);
    }

    @PutMapping("/api/v1/movies/{movieId}")
    public void updateMovie(
            @PathVariable(value = "movieId") long movieId,
            @RequestBody MovieRequest movieRequest
    ) {
        movieService.updateMovie(movieId, movieRequest);
    }

    @DeleteMapping("/api/v1/movies/{movieId}")
    public void deleteMovie(@PathVariable(value = "movieId") long movieId) {
        movieService.removeMovie(movieId);
    }

}
