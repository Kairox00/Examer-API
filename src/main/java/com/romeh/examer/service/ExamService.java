package com.romeh.examer.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.romeh.examer.model.Exam;
import com.romeh.examer.repository.ExamRepository;

@Service
public class ExamService {
  private final ExamRepository examRepository;

  public ExamService(ExamRepository examRepository) {
    this.examRepository = examRepository;
  }

  public Exam createExam(String name) {
    Exam newExam = new Exam(name);
    examRepository.save(newExam);
    return newExam;
  }

  public Exam getExam(UUID id) {
    return examRepository.findById(id).orElseThrow();
  }

  public List<Exam> getAllExams() {
    return examRepository.findAll();
  }

}
