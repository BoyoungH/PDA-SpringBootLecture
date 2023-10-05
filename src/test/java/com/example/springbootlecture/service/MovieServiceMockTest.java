package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Actor;
import com.example.springbootlecture.domain.entity.Director;
import com.example.springbootlecture.domain.entity.Movie;
import com.example.springbootlecture.domain.request.MovieRequest;
import com.example.springbootlecture.domain.response.MovieResponse;
import com.example.springbootlecture.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)  //test파일에만 있음
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;

    @Mock
    private LogService logService;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void 영화단건조회테스트(){
        //given
        int movieId=10;
        Movie movie = new Movie();
        movie.setName("하이");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));

        MovieResponse movieResponse = movieService.getMovie(movieId);
        assertNotNull(movieResponse);
    }

    @Test
    public void 영화단건조회불가테스트(){
        //given
        int movieId=1;
        Movie movie = new Movie();
        movie.setName("하이");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));

        //when
        //when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        //when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        when(movieRepository.findById(anyLong())).thenReturn(null);

        //then
        //MovieResponse result = movieService.getMovie(movieId);
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }


    @Test
    public void 비어있는영화목록조회테스트() {
        // given
        // movieRepository.findAll() 메서드가 빈 리스트를 반환하도록 모킹
        when(movieRepository.findAll()).thenReturn(Collections.emptyList());

        // when
        List<MovieResponse> movieResponses = movieService.getMovies();

        // then
        assertNotNull(movieResponses);
        assertTrue(movieResponses.isEmpty()); // 영화 목록이 비어 있는지 확인
    }

    @Test
    public void 영화목록조회테스트(){
        // given
        Movie movie1 = new Movie();
        movie1.setName("영화1");
        movie1.setDirector(new Director());
        movie1.setActors(List.of(new Actor()));

        Movie movie2 = new Movie();
        movie2.setName("영화2");
        movie2.setDirector(new Director());
        movie2.setActors(List.of(new Actor()));

        List<Movie> movieList = List.of(movie1, movie2);

        // Mocking the repository to return the list of movies
        when(movieRepository.findAll()).thenReturn(movieList);

        // when
        List<MovieResponse> movieResponses = movieService.getMovies();

        // then
        assertNotNull(movieResponses);
        assertEquals(2, movieResponses.size()); // 예상되는 영화 개수와 일치하는지 확인

        // 영화 이름 확인
        assertEquals("영화1", movieResponses.get(0).getName());
        assertEquals("영화2", movieResponses.get(1).getName());
    }

    @Test
    public void 영화_저장_테스트() {
        MovieRequest request = new MovieRequest("영화명",2002, 1L);
        Movie movie = new Movie("영화명", 2002);

        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        doNothing().when(logService).saveLog();

        movieService.saveMovie(request);
    }

//    @Test
//    public void 영화수정테스트() {
//        long movieId=1;
//        MovieRequest request = new MovieRequest("영화명",2002, 1L);
//        Movie movie = new Movie("영화명", 2002);
//        movie.setDirector(new Director());
//        movie.setActors(List.of(new Actor()));
//
//        when(movieRepository.findById(movieId)).thenReturn(movie);
//
//        movieService.updateMovie(request);
//    }

}
