package info.hccis.grading.repositories;

import info.hccis.grading.jpa.entity.GradingTrack;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradingAssessmentRepository extends CrudRepository<GradingTrack, Integer> {
    List<GradingTrack> findByStudentNameContaining(String name);
    List<GradingTrack> findByInstructorNameContaining(String name);
    
}