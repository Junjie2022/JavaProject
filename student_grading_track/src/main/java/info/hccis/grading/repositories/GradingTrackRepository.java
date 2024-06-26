package info.hccis.grading.repositories;

import info.hccis.grading.jpa.entity.GradingTrack;
import info.hccis.grading.jpa.entity.TicketOrder;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradingTrackRepository extends CrudRepository<TicketOrder, Integer> {
    
    /**
     * Use Spring Data JPA functionality to find a list of customers containing the
     * string passed in as a paramter.
     * 
     * @param studentName
     * @param name The name to find
     * @return The list of customers
     * @since 20220624 
     * @author BJM
     */
    //https://www.baeldung.com/spring-jpa-like-queries
//    List<GradingTrack> findByStudentNameContaining(String studentName);
//    //List<GradingTrack> findByCustomerName(String name);
//    List<GradingTrack> findByGrade(Double numericGrade);
}