package com.romeh.examer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeh.examer.model.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, UUID> {

}
