/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info.hccis.grading.bo;

import java.util.ArrayList;
import info.hccis.grading.jpa.entity.GradingTrack;
/**
 *
 * @author jwang129300
 */
public class GradingAssessmentValidationBO {
     public ArrayList<String> validate(GradingTrack sast) {

        ArrayList<String> errors = new ArrayList();

        //Validate the  numbers
       if ((sast.getNumericGrade() == null || sast.getNumericGrade() < 0 || sast.getNumericGrade() > 100) 
            || (sast.getAcademicYear() == null || sast.getAcademicYear() < 0)) {

            errors.add("NumericGrade should be between 0 and 100, and AcademicYear can not be negative");
        }
        return errors;
    }
    
}
