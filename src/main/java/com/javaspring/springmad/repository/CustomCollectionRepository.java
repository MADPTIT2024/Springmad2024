package com.javaspring.springmad.repository;

import com.javaspring.springmad.entity.CustomCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomCollectionRepository extends JpaRepository<CustomCollection, Long> {
    // You can add custom query methods here if needed
}
