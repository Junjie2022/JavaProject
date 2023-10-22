package info.hccis.grading.repositories;

import info.hccis.grading.jpa.entity.GradingTrack;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradingAssessmentRepository extends CrudRepository<GradingTrack, Integer> {
    
}