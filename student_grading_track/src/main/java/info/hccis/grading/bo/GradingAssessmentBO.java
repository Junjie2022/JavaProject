package info.hccis.grading.bo;


import info.hccis.grading.repositories.GradingAssessmentRepository;
import info.hccis.grading.util.CisUtility;
import info.hccis.grading.jpa.entity.GradingTrack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Business logic for my assessments
 *
 * @author bjmaclean
 * @since 20231026
 */
public class GradingAssessmentBO {
    
    
    // calculate 

     public static String calculateLetterGrade(GradingTrack sast) {
        if (sast.getNumericGrade() >= 90) {
            return "A";
        } else if (sast.getNumericGrade() >= 80) {
            return "B";
        } else if (sast.getNumericGrade() >= 70) {
            return "C";
        } else if (sast.getNumericGrade() >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    
    /**
     * calculate and set the technical score in the sast passed in
     *
     * @param sast
     * @return technical score
     * @since 20231026
     * @author BJM
     */
    public static String StudentName(GradingTrack sast) {

        String studentName = CisUtility.getInputString("Student Name");
        //todo do the actual calculation.
        sast.setStudentName(studentName);
        return sast.getStudentName();
    }

    /**
     * Load a set with the assessments for an student and an instructor
     *
     * @param sastr
     * @param sast
     * @return A set with the appropriate assessments
     * @since 20231027
     * @author BJM
     */
//    public static HashSet<GradingTrack> loadAssessmentsForStudentInstructor(GradingAssessmentRepository sastr, GradingTrack sast) {
//
//        List<GradingTrack> theListStudentName = new ArrayList();
//        List<GradingTrack> theListInstructorName = new ArrayList();
//
//        //**********************************************************************
//        //Use repository method created to find any objects which contain 
//        //the name entered on the list page.
//        //**********************************************************************
//        theListStudentName = sastr.findByStudentNameContaining(sast.getStudentName());
//       theListInstructorName = sastr.findByInstructorNameContaining(sast.getInstructorName());
//
//        HashSet<GradingTrack> theSet = new HashSet();
//
//        for (GradingTrack gradingTrack : theListStudentName) {
//            if (theListStudentName.contains(gradingTrack)) {
//                theSet.add(gradingTrack);
//            }
//          
//        }
//         for (GradingTrack gradingTrack : theListInstructorName) {
//            if (theListInstructorName.contains(gradingTrack)) {
//                theSet.add(gradingTrack);
//            }
//          
//        }
//
//        return theSet;
//
//    }
    public static HashSet<GradingTrack> loadAssessmentsForStudent(GradingAssessmentRepository sastr, GradingTrack sast) {
    List<GradingTrack> theListStudentName = sastr.findByStudentNameContaining(sast.getStudentName());

    return new HashSet<>(theListStudentName);
}

}
