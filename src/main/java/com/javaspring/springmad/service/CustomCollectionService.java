package com.javaspring.springmad.service;

import com.javaspring.springmad.entity.CustomCollection;
import com.javaspring.springmad.repository.CustomCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomCollectionService {

    private final CustomCollectionRepository customCollectionRepository;

    @Autowired
    public CustomCollectionService(CustomCollectionRepository customCollectionRepository) {
        this.customCollectionRepository = customCollectionRepository;
    }

    public List<CustomCollection> getAllCustomCollections() {
        return customCollectionRepository.findAll();
    }

    public Optional<CustomCollection> getCustomCollectionById(Long id) {
        return customCollectionRepository.findById(id);
    }

    public CustomCollection saveCustomCollection(CustomCollection customCollection) {
        return customCollectionRepository.save(customCollection);
    }

    public void deleteCustomCollection(Long id) {
        customCollectionRepository.deleteById(id);
    }
}
