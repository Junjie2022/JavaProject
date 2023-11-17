package info.hccis.grading.soap;

import info.hccis.grading.dao.GradingTrackDAO;
import info.hccis.grading.jpa.entity.GradingTrack;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "info.hccis.grading.soap.AssessmentService")
public class AssessmentServiceImpl implements AssessmentService {

    @Override
    public GradingTrack getAssessment(int id) {

        GradingTrackDAO gradingTrackDAO = new GradingTrackDAO();
        GradingTrack sast = gradingTrackDAO.selectGradingAssessment(id);
        return sast;

    }

    @Override
    public int getCount() {
        GradingTrackDAO gradingTrackDAO = new GradingTrackDAO();
        ArrayList<GradingTrack> sasts = gradingTrackDAO.selectGradingTrack("");
        return sasts.size();
    }

     @Override
    public List<GradingTrack> getAssessments(String name) {

        GradingTrackDAO gradingTrackDAO = new GradingTrackDAO();
        ArrayList<GradingTrack> sasts = gradingTrackDAO.selectGradingTrack(name);
        return sasts;
}
}
