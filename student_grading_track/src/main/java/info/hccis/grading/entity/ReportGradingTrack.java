package info.hccis.grading.entity;
import info.hccis.grading.entity.ReportGradingTrack;
import info.hccis.grading.jpa.entity.GradingTrack;

import java.util.ArrayList;

/**
 * Entity class to hold the attributes of the assessment related reports.
 * @author bjmaclean
 * @since 20231005
 */
public class ReportGradingTrack {
    private int gradeMin = 0;
    private int gradeMax = 100;
    private String studentName;
    private ArrayList<GradingTrack> gradingtrack;

    public int getGradeMin() {
        return gradeMin;
    }

    public void setGradeMin(int gradeMin) {
        this.gradeMin = gradeMin;
    }

    public int getGradeMax() {
        return gradeMax;
    }

    public void setGradeMax(int gradeMax) {
        this.gradeMax = gradeMax;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<GradingTrack> getGradingtrack() {
        return gradingtrack;
    }

    public void setGradingtrack(ArrayList<GradingTrack> gradingtrack) {
        this.gradingtrack = gradingtrack;
    }
    
    
}
