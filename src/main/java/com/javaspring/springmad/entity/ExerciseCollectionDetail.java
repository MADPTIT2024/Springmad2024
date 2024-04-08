package com.javaspring.springmad.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ExerciseCollectionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private int idx;
    
    @Column(nullable = false)
    private boolean state;
    
    @Column(nullable = false)
    private int rep;
    
    @Column(nullable = false)
    private int timer;
    
    @ManyToOne
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Exercise exercise;
    
    @ManyToOne
    @JoinColumn(name = "exercise_collection_id", referencedColumnName = "id")
    private ExerciseCollection exerciseCollection;
}
