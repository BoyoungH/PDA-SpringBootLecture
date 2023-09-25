package com.example.springbootlecture.controller;

import com.example.springbootlecture.common.Response;
import com.example.springbootlecture.domain.entity.Shinhan;
import com.example.springbootlecture.domain.request.ShinhanRequest;
import com.example.springbootlecture.domain.response.ShinhanResponse;
import com.example.springbootlecture.service.ShinhanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "신한투자증권 API 실습")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class ShinhanController {

    private final ShinhanService shinhanService;

    @GetMapping("/v1/shinhansec")
    public Response<List<ShinhanResponse>> getCompanies(){
        return Response.of(shinhanService.getCompanies());
    }

    @GetMapping("/v1/shinhansec/{companyId}")
    public Shinhan getCompany(
            @PathVariable(value="companyId") long companyId
    ){
        return shinhanService.getCompany(companyId);
    }

    @PostMapping("/v1/shinhansec/{companyId}")
    public void registerCompany(@RequestBody ShinhanRequest shinhanRequest){
        shinhanService.registerCompany(shinhanRequest);
    }

    @PutMapping("/v1/shinhansec/{companyId}")
    public void updateCompany(
            @PathVariable(value="companyId") long companyId,
            @RequestBody ShinhanRequest shinhanRequest
            ){
        shinhanService.updateCompany(companyId, shinhanRequest);
    }

    @DeleteMapping("/v1/shinhansec/{companyId}")
    public void deleteCompany(
            @PathVariable(value="companyId") long companyId
    ){
        shinhanService.deleteCompany(companyId);
    }



}
