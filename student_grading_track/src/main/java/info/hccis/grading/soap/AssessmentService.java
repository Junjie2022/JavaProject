package info.hccis.grading.soap;

import info.hccis.grading.jpa.entity.GradingTrack;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface AssessmentService {
    @WebMethod
    GradingTrack getAssessment(int id);
    @WebMethod
    int getCount();
    
}