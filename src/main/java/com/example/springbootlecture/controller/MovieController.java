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

@Tag(name = "무비 컨드롤러다")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class MovieController {

    private final MovieService movieService;

    // @Deprecated // 취소선


//    @GetMapping("/v1/movies") // 버전은 각각의 메소드 단위에 두어야 함
//    public ResponseEntity<Map<String, Object>> getMovies(){
//        Map<String, Object> result = new HashMap<>();
//        result.put("data", movieService.getMovies());
//
//        return ResponseEntity.ok().body(result);
//    }

    @GetMapping("/v1/movies") // 버전은 각각의 메소드 단위에 두어야 함
    public Response<List<MovieResponse>> getMovies(){
        return Response.of(movieService.getMovies());
    }

    @GetMapping("/v1/movies/{movieId}")
    public Movie getMovie(
            @PathVariable(value = "movieId") long movieId
    ){
        return movieService.getMovie(movieId);
    }

//    @GetMapping("/v1/movies/{movieId}")
//    public Movie getMovie(
//            @RequestParam(value = "v", required = false) Integer v,
//            @RequestParam(value = "v2", required = false) int v2,
//            @RequestParam(value = "v3", required = false) Integer v3,
//            @PathVariable(value = "movieId") long movieId
//    ) {
//        return new Movie(1, "오펜하이머", 2023);
//    }

    @PostMapping("/v1/movies")
    public void createMovie(@RequestBody MovieRequest movieRequest) {
        movieService.createMovie(movieRequest);
    }

    @PutMapping("/v1/movies/{movieId}")
    public void updateMovie(
            @PathVariable(value = "movieId") long movieId,
            @RequestBody MovieRequest movieRequest
    ) {
        movieService.updateMovie(movieId, movieRequest);
    }

    @DeleteMapping("/v1/movies/{movieId}")
    public void deleteMovie(
            @PathVariable(value = "movieId") long movieId
    )
    {
        movieService.deleteMovie(movieId);
    }
}