package ru.energy778.testing.service;

import ru.energy778.testing.domain.Test;

import java.util.List;

public interface LoadTestService {
    List<Test> getQuestions(Integer count);
}
