package info.hccis.grading.dao;

import info.hccis.grading.jpa.entity.GradingTrack;
import info.hccis.grading.jpa.entity.TicketOrder;
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

//    /**
//     * Select ticket orders in a given date range.
//     *
//     * @since 20220621
//     * @author BJM
//     */
//    public ArrayList<TicketOrder> selectTicketOrders(String start, String end) {
//        PreparedStatement stmt;
//        ArrayList<TicketOrder> ticketOrders = new ArrayList();
//        try {
//            String query = "SELECT * FROM TicketOrder ticketorder "
//                    + "WHERE ticketorder.dateOfOrder > ? "
//                    + "and ticketorder.dateOfOrder < ?";
//            stmt = conn.prepareStatement(query);
//            stmt.setString(1, start);
//            stmt.setString(2, end);
//            rs = stmt.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            while (rs.next()) {
//                TicketOrder ticketOrder = new TicketOrder();
//                ticketOrder.setId(rs.getInt("id"));
//                ticketOrder.setCustomerName(rs.getString("customerName"));
//                ticketOrder.setDateOfOrder(rs.getString("dateOfOrder"));
//                ticketOrder.setDateOfPerformance(rs.getString("dateOfPerformance"));
//                ticketOrder.setTimeOfPerformance(rs.getString("timeOfPerformance"));
//                ticketOrder.setNumberOfTickets(rs.getInt("numberOfTickets"));
//                ticketOrder.setHollpassNumber(rs.getInt("hollpassNumber"));
//                ticketOrder.setCostOfTickets(rs.getBigDecimal("costOfTickets"));
//                ticketOrders.add(ticketOrder);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        logger.info("Found orders:  " + ticketOrders.size());
//        return ticketOrders;
//    }
    /**
     * Select skills assessments by athlete name
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
            String query = "SELECT * FROM gradingtrack sast WHERE sast.student LIKE ?";
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
                sast.setCourseRoom(rs.getString("courseName"));
                sast.setInstructorName(rs.getString("instructorName"));
                sast.setLetterGrade(rs.getString("letterGrad"));
                sast.setStudentName(rs.getString("studentName"));
                sast.setId(rs.getInt("ID"));
                sast.setNumericGrade(rs.getDouble("numericGrad"));
                sast.setOverallGrade(rs.getDouble("overallGrade"));
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

}
