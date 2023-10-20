package info.hccis.grading.controllers;

import info.hccis.grading.dao.GradingTrackDAO;
import info.hccis.grading.dao.TicketOrderDAO;
import info.hccis.grading.entity.ReportOrder;
import info.hccis.grading.jpa.entity.TicketOrder;
import info.hccis.grading.repositories.TicketOrderRepository;
import info.hccis.grading.entity.ReportAssessment;
import info.hccis.grading.jpa.entity.GradingTrack;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to administer reports of the project.
 *
 * @since 20220616
 * @author BJM
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    /**
     * Send the user to list of reports view.
     *
     * @param model
     * @param session
     * @return To the appropriate view
     * @since 20220624
     * @author BJM
     */
    @RequestMapping("")
    public String home(Model model, HttpSession session) {

        //BJM 20200602 Issue#1 Set the current date in the session
        logger.info("Running the reports controller base method");
        return "report/list";
    }
 /**
     * Method to send user to the order date report.
     *
     * @param model
     * @return view for list
     * @since 2022-06-20
     * @author BJM
     */
    @RequestMapping("/grades/student")
    public String assessmentByStudent(Model model) {

        //**********************************************************************
        // 
        //**********************************************************************
        //model.addAttribute("reportInput", new ReportOrder());
        System.out.println("jj - reportcontroller - sending the user to a different view");
        return "report/reportByGrades";
    }
   
    @RequestMapping("/by/student")
    public String reportByStudent(Model model) {

        //**********************************************************************
        // Put the ticket order object in the model and send the user
        // to the report input view.
        //**********************************************************************
        model.addAttribute("reportInput", new ReportOrder());
        return "report/reportByStudent";
    }
    
    @RequestMapping("/assessment/student/submit")
    public String assessmentByStudentSubmit(Model model, @ModelAttribute("reportInput") ReportAssessment reportAssessment) {

        System.out.println("The name entered by the user is: "+reportAssessment.getStudentName());
        
        //todo 1 use dao class to get the assessments for that player
         GradingTrackDAO gradingTrackDAO = new GradingTrackDAO();
        ArrayList<GradingTrack> gradingTrack = gradingTrackDAO.selectGradingTrack(reportAssessment.getStudentName());
        
        //if not rows found, add a message to the model
        if(gradingTrack .isEmpty()){
            model.addAttribute("message", "No data foound for "+reportAssessment.getStudentName());
        }
        
        //add them to the model
        reportAssessment.setAssessments(gradingTrack );
        model.addAttribute("reportInput", reportAssessment);
        
        //change the html to show the assessments.
        
        //that is it for sprint 2
        
        //**********************************************************************
        // 
        //**********************************************************************
        //model.addAttribute("reportInput", new ReportOrder());
        System.out.println("BJM - reportcontroller - assessment student was submitted");
        return "report/reportByStudent";
    }
    /**
     * Method to send user to the order date report.
     *
     * @param model
     * @return view for list
     * @since 2022-06-20
     * @author BJM
     */
    @RequestMapping("/order/dateoforder")
    public String reportOrderDateOfOrder(Model model) {

        //**********************************************************************
        // Put the ticket order object in the model and send the user
        // to the report input view.
        //**********************************************************************
        model.addAttribute("reportInput", new ReportOrder());
        return "report/reportOrderDate";
    }

    /**
     * Method to send user to the customer name report input.
     *
     * @param model
     * @return view for list
     * @since 2022-06-20
     * @author BJM
     */
//    @RequestMapping("/order/customername")
//    public String reportOrderCustomerName(Model model) {
//
//        //**********************************************************************
//        // Put the ticket order object in the model and send the user
//        // to the report input view.
//        //**********************************************************************
//        model.addAttribute("reportInput", new ReportOrder());
//        return "report/reportOrderCustomerName";
//    }


    /**
     * Process the report
     *
     * @param model
     * @param reportOrder
     * @return view to show report
     * @since 2022-06-20
     * @author BJM
     */
    @RequestMapping("/order/dateoforder/submit")
    public String reportOrderDateOfOrderSubmit(Model model, @ModelAttribute("reportInput") ReportOrder reportOrder) {

        //**********************************************************************
        // This could be done using the repository but there will be times when
        // jdbc will be useful.  For the reports, the requirements state that you 
        // are to use jdbc to obtain the data for the report.
        //**********************************************************************
        TicketOrderDAO ticketOrderDAO = new TicketOrderDAO();
        String start = reportOrder.getDateStart();
        String end = reportOrder.getDateEnd();
        ArrayList<TicketOrder> ticketOrders = ticketOrderDAO.selectTicketOrders(start, end);
        reportOrder.setTicketOrders(ticketOrders);

        if (ticketOrders != null && ticketOrders.isEmpty()) {
            model.addAttribute("message", "No data found");
            System.out.println("BJM - no data found");
        }

        model.addAttribute("reportInput", reportOrder);

        return "report/reportOrderDate";
    }

    /**
     * Process the report
     *
     * @param model
     * @param reportOrder
     * @return view to show report
     * @since 2022-06-20
     * @author BJM
     */
    @RequestMapping("/order/customername/submit")
    public String reportOrderCustomerNameSubmit(Model model, @ModelAttribute("reportInput") ReportOrder reportOrder) {

        //**********************************************************************
        // This could be done using the repository but there will be times when
        // jdbc will be useful.  For the reports, the requirements state that you 
        // are to use jdbc to obtain the data for the report.
        //**********************************************************************
        TicketOrderDAO ticketOrderDAO = new TicketOrderDAO();
        ArrayList<TicketOrder> ticketOrders = ticketOrderDAO.selectTicketOrders(reportOrder.getStudentName());
        reportOrder.setTicketOrders(ticketOrders);

        if (!ticketOrders.isEmpty()) {
            reportOrder.setStudentName("");
        } else {
            model.addAttribute("message", "No data found");
            System.out.println("BJM - no data found");
        }

        model.addAttribute("reportInput", reportOrder);

        return "report/reportOrderCustomerName";
    }

}
