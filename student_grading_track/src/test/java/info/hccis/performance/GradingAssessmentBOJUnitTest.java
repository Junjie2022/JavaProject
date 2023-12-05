package info.hccis.performance;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



import info.hccis.grading.jpa.entity.GradingTrack;
import info.hccis.grading.bo.GradingAssessmentBO;



/**
 *
 * @author bjmaclean
 */
public class GradingAssessmentBOJUnitTest {


    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCalculateLetterGrade1() {
        GradingTrack sast = new GradingTrack();
        sast.setAcademicYear(2);
        sast.setCourseName("CIS2256");
        sast.setCourseRoom("234");
        sast.setId(13);
        sast.setInstructorName("jjugh");
        sast.setStudentName("julia wong");
        sast.setNumericGrade(99.1);
       String letterGrade = GradingAssessmentBO.calculateLetterGrade(sast);
        Assertions.assertEquals("A",letterGrade);
    }
    
    
     @Test
    public void testCalculateLetterGrade2() {
        GradingTrack sast = new GradingTrack();
        sast.setAcademicYear(2);
        sast.setCourseName("CIS001");
        sast.setCourseRoom("234");
        sast.setId(13);
        sast.setInstructorName("jhu");
        sast.setStudentName("jill li");
        sast.setNumericGrade(20.1);
       String letterGrade = GradingAssessmentBO.calculateLetterGrade(sast);
        Assertions.assertTrue(letterGrade.equalsIgnoreCase("F"));
    }

   

}
