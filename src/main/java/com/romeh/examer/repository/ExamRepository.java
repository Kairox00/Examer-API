package com.romeh.examer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeh.examer.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, UUID> {

}
