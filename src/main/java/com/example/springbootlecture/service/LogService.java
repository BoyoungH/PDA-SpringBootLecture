package com.example.springbootlecture.service;

import com.example.springbootlecture.domain.entity.Log;
import com.example.springbootlecture.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog() {
        logRepository.save(new Log());
    }
}
