package com.javaspring.springmad.repository;


import com.javaspring.springmad.entity.ExerciseCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseCollectionRepository extends JpaRepository<ExerciseCollection, Long> {

	ExerciseCollection findByName(String name);

}
