package info.hccis.main;

import com.google.gson.Gson;
import info.hccis.model.jpa.GradingTrack;
import info.hccis.student.util.UtilityRest;
import java.util.Scanner;
import org.json.JSONArray;

public class Controller {

    final public static String MENU = "\nMain Menu \nA) Add\n"
            + "U) Update (FUTURE)\n"
            + "V) View\n"
            + "D) Delete (FUTURE)\n"
            + "X) eXit";
    final static Scanner input = new Scanner(System.in);
    private static final String URL_STRING = "http://10.0.40.207:8080/api/GradingAssessmentService/assessments";

    public static void main(String[] args) {
        boolean endProgram = false;
        do {
            System.out.println(MENU);
            String choice = input.nextLine();
            GradingTrack sast;
            String url;
            switch (choice.toUpperCase()) {
                case "A":
                    sast = create();
                    url = URL_STRING;
                    System.out.println("Url=" + url);
                    GradingTrack assessmentReturned = (GradingTrack) UtilityRest.addUsingRest(url, sast);
                    System.out.println("Added new entity:"+assessmentReturned.toString());
                    break;
//                case "U":
//                    camper = createCamper();
//                    url = URL_STRING;
//                    System.out.println("Url="+url);
//                    UtilityRest.addUsingRest(url, camper);
//                case "D":
//                    System.out.println("Enter id to delete");
//                    Scanner input = new Scanner(System.in);
//                    int id = input.nextInt();
//                    input.nextLine();  //burn
//                    UtilityRest.deleteUsingRest(URL_STRING, id);
//                    break;
                case "V":
                    String jsonReturned = UtilityRest.getJsonFromRest(URL_STRING);
                    //**************************************************************
                    //Based on the json string passed back, loop through each json
                    //object which is a json string in an array of json strings.
                    //*************************************************************
                    JSONArray jsonArray = new JSONArray(jsonReturned);
                    //**************************************************************
                    //For each json object in the array, show the first and last names
                    //**************************************************************
                    System.out.println("Here are the rows");
                    Gson gson = new Gson();
                    for (int currentIndex = 0; currentIndex < jsonArray.length(); currentIndex++) {
                        GradingTrack current = gson.fromJson(jsonArray.getJSONObject(currentIndex).toString(), GradingTrack.class);
                        System.out.println(current.toString());
                    }
                    break;

                case "X":
                    endProgram = true;
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        } while (!endProgram);
    }

    /**
     * Create an object by passing asking user for input.
     *
     * @return object
     * @since 20171117
     * @author BJM
     */
    public static GradingTrack create() {
        GradingTrack assessment = new GradingTrack();
        assessment.getInformation();
        return assessment;
    }

}
