package info.hccis.testusingsoap.soap;

import java.util.List;
import java.util.Scanner;

/**
 * Test soap
 *
 * @author bjmac
 * @since 20211115
 *
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AssessmentServiceImplService asis = new AssessmentServiceImplService();
        AssessmentService assessmentService = asis.getAssessmentServiceImplPort();

        System.out.println("There are " + assessmentService.getCount() + " rows in the database");

        String option = "";
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter id or name of asssessment to view, -1 to exit");

            option = input.nextLine();
            if (!option.equals("-1")) {
                try {
                    int optionNumeric = Integer.parseInt(option);
                   GradingTrack sast = assessmentService.getAssessment(optionNumeric);
                    if (sast.getAthleteName() == null) {
                        System.out.println("Not found");
                    } else {
                        System.out.println(sast.getAthleteName() + sast.getAssessmentDate());
                    }
                } catch (Exception e) {
                    //Exception caught because the user entered a name
                    List<GradingTrack> theAssessments = assessmentService.getAssessments(option);
                    if (theAssessments == null || theAssessments.isEmpty()) {
                        System.out.println("No assessments found");
                    } else {
                        for (GradingTrack theAssessment : theAssessments) {
                            System.out.println(theAssessment.getAthleteName() + "-" + theAssessment.getTechnicalScore());
                        }
                    }
                }
            }

        } while (!option.equalsIgnoreCase("-1"));

//        StudentServiceImplService ssis = new StudentServiceImplService();
//        StudentService ss = ssis.getStudentServiceImplPort();
//
//        int count = ss.getStudentCount();
//        
//        
//        String idEntered = JOptionPane.showInputDialog("There are "+count+" students.  Enter id to lookup");
//        Student student =  ss.getStudent(Integer.parseInt(idEntered));
//        System.out.println(student.getName());
//        JOptionPane.showMessageDialog(null, "The student's name is: "+student.getName()+" "+student.getProgram());
//
    }

}
