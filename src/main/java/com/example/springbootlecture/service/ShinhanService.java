package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Shinhan;
import com.example.springbootlecture.domain.request.ShinhanRequest;
import com.example.springbootlecture.domain.response.ShinhanResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShinhanService {

    private final static List<Shinhan> companies = new ArrayList<>();

    @PostConstruct
    public void init(){
        companies.addAll(List.of(
                new Shinhan(1, "두산테스나", "3분기 비용증가...", LocalDateTime.now()),
                new Shinhan(2, "현대 위아", "본업인 자동차 업황은...", LocalDateTime.now()),
                new Shinhan(3, "티에스아이", "3Q23 Ultium Cells 등...", LocalDateTime.now())
        ));
    }

    public List<ShinhanResponse> getCompanies(){
        return companies.stream().map(ShinhanResponse::of).toList();
    }

    public Shinhan getCompany(long companyId){
        return companies.stream()
                .filter(company -> company.getId() == companyId)
                .toList()
                .stream()
                .findFirst()
                .orElseThrow();
    }

    public void registerCompany(ShinhanRequest shinhanRequest){
        Shinhan company = new Shinhan(
                companies.size() + 1,
                shinhanRequest.getCompany(),
                shinhanRequest.getContent(),
                LocalDateTime.now()
        );
        companies.add(company);
    }

    public void updateCompany(long companyId, ShinhanRequest shinhanRequest){
        Shinhan company = getCompany(companyId);
        company.setCompany(shinhanRequest.getCompany());
        company.setContent(shinhanRequest.getContent());
    }

    public void deleteCompany(long companyId){
        Shinhan company = getCompany(companyId);
        companies.remove(company);
    }


}
