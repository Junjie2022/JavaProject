package info.hccis.grading.controllers;

import info.hccis.grading.repositories.GradingAssessmentRepository;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller to administer ticket orders. Note that the code was taken from
 * Fred Campos' project from 2021 which also had modifications from Ferhad in
 * 2022.
 *
 * @since 20220616
 * @author BJM
 */
@Controller
@RequestMapping("/gradingassessment")
public class GradingAssessmentController {

    private final GradingAssessmentRepository _sastr;

    @Autowired
    public GradingAssessmentController(GradingAssessmentRepository sastr) {
        _sastr = sastr;
    }

    @Autowired
    private MessageSource messageSource;

    private static final Logger logger = LoggerFactory.getLogger(GradingAssessmentController.class);

    @RequestMapping("")
    public String home(Model model, HttpSession session) {

        System.out.println("request mapping matched for gradingassessment");
        model.addAttribute("assessments", _sastr.findAll());
        
        return "gradingassessment/list";
    }

    /**
     * Page to add new item. Taken from tutor app from 2022 (which was
     * also derived from class samples)
     *
     * @param model
     * @return add
     * @since 2023-10-20
     * @author BJM
     */
    @RequestMapping("/add")
    public String add(Model model, HttpSession session) {

        System.out.println("request mapping matched for add");
        model.addAttribute("assessments", _sastr.findAll());
        
        return "gradingassessment/list";
    }



    /**
     * Page to edit
     *
     * @param id ID
     * @param model
     * @return 
     * @since 20220616
     * @author Fred Campos
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, HttpSession session) {

        System.out.println("request mapping matched for edit");
        model.addAttribute("assessments", _sastr.findAll());
        
        return "gradingassessment/list";
    }

    /**
     * Page to delete an order
     *
     * @param id ID 
     * @return ticket order
     * @since 20220616
     * @author BJM
     */
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        _sastr.deleteById(id);

        return "redirect:/gradingassessment";
    }


}
