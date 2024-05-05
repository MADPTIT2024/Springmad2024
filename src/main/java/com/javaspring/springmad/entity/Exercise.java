package com.javaspring.springmad.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Exercise {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String detail;
    
    @Column(nullable = true)
    private String animation;
    
    @Column(nullable = true)
    private String video;

    @Column(nullable = true)
    private Integer rep = 0;

    @Column(nullable = true)
    private Integer timer = 0;
}
