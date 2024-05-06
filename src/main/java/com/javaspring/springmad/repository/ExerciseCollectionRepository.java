package com.javaspring.springmad.repository;

import com.javaspring.springmad.entity.ExerciseCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExerciseCollectionRepository extends JpaRepository<ExerciseCollection, Long> {

    ExerciseCollection findByName(String name);

    @Query("SELECT SUM(ec.calories) FROM ExerciseCollection ec")
    Double getTotalCalories();
}
