package com.romeh.examer.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeh.examer.model.Answer;
import com.romeh.examer.model.AnswerId;

@Repository
public interface AnswerRepository
        extends JpaRepository<Answer, AnswerId> {
    public List<Answer> findAllByStudentId(UUID studentId);

    public List<Answer> findAllByStudentIdAndExamId(UUID studentId, UUID examId);

    public Answer findByStudentIdAndQuestionId(UUID studentId, UUID questionId);
}
