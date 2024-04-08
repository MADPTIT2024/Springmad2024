package com.javaspring.springmad.service;

import com.javaspring.springmad.entity.ExerciseCollectionDetail;
import com.javaspring.springmad.repository.ExerciseCollectionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseCollectionDetailService {
    @Autowired
    private ExerciseCollectionDetailRepository exerciseCollectionDetailRepository;

    public List<ExerciseCollectionDetail> getAllExerciseCollectionDetails() {
        return exerciseCollectionDetailRepository.findAll();
    }

    public ExerciseCollectionDetail getExerciseCollectionDetailById(Long id) {
        return exerciseCollectionDetailRepository.findById(id).orElse(null);
    }

    public ExerciseCollectionDetail createExerciseCollectionDetail(ExerciseCollectionDetail exerciseCollection) {

            return exerciseCollectionDetailRepository.save(exerciseCollection);
    }

    public ExerciseCollectionDetail updateExerciseCollectionDetail(Long id, ExerciseCollectionDetail exerciseCollection) {
        Optional<ExerciseCollectionDetail> existingExerciseCollectionDetailOptional = exerciseCollectionDetailRepository.findById(id);
        if (existingExerciseCollectionDetailOptional.isPresent()) {
            ExerciseCollectionDetail existingExerciseCollectionDetail = existingExerciseCollectionDetailOptional.get();
            existingExerciseCollectionDetail.setIdx(exerciseCollection.getIdx());
            existingExerciseCollectionDetail.setRep(exerciseCollection.getRep());
            existingExerciseCollectionDetail.setState(exerciseCollection.isState());
            existingExerciseCollectionDetail.setTimer(exerciseCollection.getTimer());
            existingExerciseCollectionDetail.setExercise(exerciseCollection.getExercise());
            existingExerciseCollectionDetail.setExerciseCollection(exerciseCollection.getExerciseCollection());

            return exerciseCollectionDetailRepository.save(existingExerciseCollectionDetail);
        } else {
            return null;
        }
    }


    public void deleteExerciseCollectionDetail(Long id) {
        exerciseCollectionDetailRepository.deleteById(id);
    }

}
