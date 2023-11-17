package info.hccis.testusingsoap.soap;

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
        
        System.out.println("There are "+assessmentService.getCount()+" rows in the database");

        int option = 0;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter id of asssessment to view, -1 to exit");
            option = input.nextInt();
            input.nextLine();
            GradingTrack sast = assessmentService.getAssessment(option);
            System.out.println(sast.getStudentName() );

        } while (option > 0);

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
