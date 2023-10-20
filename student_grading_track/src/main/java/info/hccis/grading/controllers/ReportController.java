package info.hccis.grading.controllers;

import ch.qos.logback.core.util.FileUtil;

import info.hccis.grading.dao.GradingTrackDAO;
import info.hccis.grading.dao.TicketOrderDAO;
import info.hccis.grading.entity.ReportOrder;
import info.hccis.grading.jpa.entity.TicketOrder;
import info.hccis.grading.entity.ReportGradingTrack;
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
import info.hccis.grading.repositories.GradingTrackRepository;

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


   
    @RequestMapping("/by/student")
    public String assessmentByStudent(Model model) {

        //**********************************************************************
        // Put the ticket order object in the model and send the user
        // to the report input view.
        //**********************************************************************
        model.addAttribute("reportInput", new ReportGradingTrack());
        return "/report/reportByStudent";
    }
    
    @RequestMapping("/assessment/student/submit")
    public String assessmentByStudentSubmit(Model model, @ModelAttribute("reportInput") ReportGradingTrack gradingtrack) {

        System.out.println("The name entered by the user is: "+gradingtrack.getStudentName());
        
        //todo 1 use dao class to get the assessments for that player
         GradingTrackDAO gradingTrackDAO = new GradingTrackDAO();
        ArrayList<GradingTrack> gradingTrack = gradingTrackDAO.selectGradingTrack(gradingtrack.getStudentName());
        
        //if not rows found, add a message to the model
        if(gradingTrack .isEmpty()){
            model.addAttribute("message", "No data foound for "+gradingtrack.getStudentName());
        }
      //     info.hccis.util.FileUtil.writeToFile("Player Report", gradingTrack);
        //add them to the model
        gradingtrack.setGradingtrack(gradingTrack);
        model.addAttribute("reportInput", gradingtrack);
        
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
     * Method to send user to the tech grades report
     *
     * @param model
     * @return view for list
     * @since 2022-06-20
     * @author BJM
     */
       @RequestMapping("/by/grades")
    public String assessmentByGrade(Model model) {

        //**********************************************************************
        // 
        //**********************************************************************
          model.addAttribute("reportInput", new ReportGradingTrack());
        System.out.println("jj - reportcontroller - sending the user to a different view");
        return "/report/reportByGrades";
    }
    /**
     * Method to send user to the order date report.
     *
     * @param model
     * @return view for list
     * @since 2022-06-20
     * @author BJM
     */
    @RequestMapping("/assessment/grade/submit")
    public String assessmentByGradeSubmit(Model model, @ModelAttribute("reportInput") ReportGradingTrack gradingtrack) {

        System.out.println("The max entered by the user is: "+gradingtrack.getGradeMax());
        
       GradingTrackDAO gradingTrackDAO = new GradingTrackDAO();
        int min = gradingtrack.getGradeMin();
        int max = gradingtrack.getGradeMax();
        ArrayList<GradingTrack> grading = gradingTrackDAO.selectGradeAssessments(min, max);
        
      // info.hccis.util.FileUtil.writeToFile("Report Score Min Max", grading);

        //if not rows found, add a message to the model
        if(grading.isEmpty()){
            model.addAttribute("message", "No data found");
        }
        
        //add them to the model
       gradingtrack.setGradingtrack(grading);
        model.addAttribute("reportInput", gradingtrack);

        System.out.println("BJM - reportcontroller - assessment player was submitted");
        return "report/reportByGrades";
    }

}
