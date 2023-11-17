package info.hccis.grading.soap;

import info.hccis.grading.jpa.entity.GradingTrack;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface AssessmentService {
    @WebMethod
    GradingTrack getAssessment(int id);
    
      @WebMethod
    List<GradingTrack> getAssessments(String name);

    @WebMethod
    int getCount();
    
}