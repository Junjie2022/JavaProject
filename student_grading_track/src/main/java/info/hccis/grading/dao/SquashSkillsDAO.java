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
public class SquashSkillsDAO {

    private static ResultSet rs;
    private static Connection conn = null;
    private static final Logger logger = LoggerFactory.getLogger(SquashSkillsDAO.class);

    public SquashSkillsDAO() {

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
    public ArrayList<GradingTrack> selectSkillsAssessments(String studentName) {
        PreparedStatement stmt;
        ArrayList<GradingTrack> skillsAssessments = new ArrayList();

        //https://stackoverflow.com/questions/2857164/cannot-use-a-like-query-in-a-jdbc-preparedstatement
        //Bitbucket Issue#5
        String athleteNameLike = "%" + studentName + "%";
        try {
            String query = "SELECT * FROM skillsassessmentsquashtechnical sast WHERE sast.athleteName LIKE ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, athleteNameLike);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (rs.next()) {
                GradingTrack sast = new GradingTrack();

//                sast.setId(rs.getInt("id"));
//                sast.setAssessmentDate(rs.getString("assessmentDate"));
//                sast.setAthleteName(rs.getString("athleteName"));
//                sast.setAssessorName(rs.getString("assessorName"));
//                sast.setAssessorName(rs.getString("assessorName"));
//                sast.setCreatedDateTime(rs.getString("createdDateTime"));
//                sast.setForehandDrives(rs.getInt("forehandDrives"));
//                sast.setBackhandDrives(rs.getInt("backhandDrives"));
//                sast.setForehandVolleyMax(rs.getInt("forehandVolleyMax"));
//                sast.setForehandVolleySum(rs.getInt("forehandVolleySum"));
//                sast.setBackhandVolleyMax(rs.getInt("backhandVolleyMax"));
//                sast.setBackhandVolleySum(rs.getInt("backhandVolleySum"));
//                sast.setTechnicalScore(rs.getInt("technicalScore"));
//                skillsAssessments.add(sast);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.info("Found assessments:  " + skillsAssessments.size());
        return skillsAssessments;
    }

}
