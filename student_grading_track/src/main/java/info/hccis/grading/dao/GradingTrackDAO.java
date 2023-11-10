package info.hccis.grading.dao;

import info.hccis.grading.jpa.entity.GradingTrack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DAO class to access skills
 *
 * @author bjmaclean
 * @since 20220621
 */
public class GradingTrackDAO {

    private static ResultSet rs;
    private static Connection conn = null;
    private static final Logger logger = LoggerFactory.getLogger(GradingTrackDAO.class);

    public GradingTrackDAO() {

        String propFileName = "application";
        ResourceBundle rb = ResourceBundle.getBundle(propFileName);
        String connectionString = rb.getString("spring.datasource.url");
        String userName = rb.getString("spring.datasource.username");
        String password = rb.getString("spring.datasource.password");

        try {
            conn = DriverManager.getConnection(connectionString, userName, password);
        } catch (SQLException e) {
            logger.error(e.toString());
        }

    }

/**
     * Select an assessment by idd
     *
     * @since 20231106
     * @author BJM
     */
    public GradingTrack selectGradingAssessment(int id) {

        GradingTrack sast = new GradingTrack();

        PreparedStatement stmt;
        ArrayList<GradingTrack> gradingAssessments = new ArrayList();

        //https://stackoverflow.com/questions/2857164/cannot-use-a-like-query-in-a-jdbc-preparedstatement
        //Bitbucket Issue#5
        try {
            String query = "SELECT * FROM gradingtrack sast WHERE sast.id = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {

                sast.setId(rs.getInt("id"));
                sast.setCourseName(rs.getString("courseName"));
                sast.setCourseRoom(rs.getString("courseRoom"));
                sast.setInstructorName(rs.getString("instructorName"));
                sast.setLetterGrade(rs.getString("letterGrade"));
                sast.setStudentName(rs.getString("studentName"));
                sast.setId(rs.getInt("ID"));
                sast.setNumericGrade(rs.getDouble("numericGrade"));
                sast.setOverallGrade(rs.getDouble("overallGrade"));
                sast.setAcademicYear(rs.getInt("academicYear"));
                  sast.setOverallLetterGrade(rs.getString("overallletterGrade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("Found assessment:  " + sast.toString());
        return sast;

    }

    /**
     * Select skills assessments by student name
     *
     * @since 20231012
     * @author BJM
     */
    public ArrayList<GradingTrack> selectGradingTrack(String studentName) {
        PreparedStatement stmt;
        ArrayList<GradingTrack> gradingtrack = new ArrayList();

        //https://stackoverflow.com/questions/2857164/cannot-use-a-like-query-in-a-jdbc-preparedstatement
        //Bitbucket Issue#5
        String studentNameLike = "%" + studentName + "%";
        try {
            String query = "SELECT * FROM gradingtrack " + "WHERE studentName LIKE ?";
            //"SELECT * FROM gradingassessmentsquashtechnical sast WHERE sast.athleteName LIKE ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, studentNameLike);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                GradingTrack sast = new GradingTrack();

                sast.setId(rs.getInt("id"));
                sast.setCourseName(rs.getString("courseName"));
                sast.setCourseRoom(rs.getString("courseRoom"));
                sast.setInstructorName(rs.getString("instructorName"));
                sast.setLetterGrade(rs.getString("letterGrade"));
                sast.setStudentName(rs.getString("studentName"));
                sast.setId(rs.getInt("ID"));
                sast.setNumericGrade(rs.getDouble("numericGrade"));
                sast.setOverallGrade(rs.getDouble("overallGrade"));
                sast.setAcademicYear(rs.getInt("academicYear"));
                  sast.setOverallLetterGrade(rs.getString("overallletterGrade"));
//                sast.setForehandVolleySum(rs.getInt("forehandVolleySum"));
//                sast.setBackhandVolleyMax(rs.getInt("backhandVolleyMax"));
//                sast.setBackhandVolleySum(rs.getInt("backhandVolleySum"));
//                sast.setTechnicalScore(rs.getInt("technicalScore"));
                gradingtrack.add(sast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("Found assessments:  " + gradingtrack.size());
        return gradingtrack;
    }
/**
     * Select skills assessments by min and max score
     *
     * @since 20231012
     * @author BJM
     */
    public ArrayList<GradingTrack> selectGradeAssessments(int min, int max) {
        PreparedStatement stmt;
        ArrayList<GradingTrack> gradingAssessments = new ArrayList();

        try {
            String query = "SELECT * FROM gradingtrack " + "WHERE  numericGrade>= ? && numericGrade <= ?;";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, min);
            stmt.setInt(2, max);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                GradingTrack sast = new GradingTrack();

                 sast.setId(rs.getInt("id"));
                sast.setCourseName(rs.getString("courseName"));
                sast.setCourseRoom(rs.getString("courseName"));
                sast.setInstructorName(rs.getString("instructorName"));
                sast.setLetterGrade(rs.getString("letterGrad"));
                sast.setStudentName(rs.getString("studentName"));
                sast.setId(rs.getInt("ID"));
                sast.setNumericGrade(rs.getDouble("numericGrad"));
                sast.setOverallGrade(rs.getDouble("overallGrade"));
                gradingAssessments.add(sast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("Found assessments:  " + gradingAssessments.size());
        return gradingAssessments;
    }

}
