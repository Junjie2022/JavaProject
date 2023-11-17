package info.hccis.grading.rest;

import com.google.gson.Gson;
import info.hccis.grading.exception.AllAttributesNeededException;
import info.hccis.grading.jpa.entity.GradingTrack;
import info.hccis.grading.repositories.GradingAssessmentRepository;
import info.hccis.grading.util.CisUtility;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Assessment Service class for accessing using REST.
 *
 * @author 2232
 * @since 20231109
 */
@Path("/GradingAssessmentService/assessments")
public class GradingAssessmentService
{
    private final GradingAssessmentRepository _sastr;

    @Autowired
    public GradingAssessmentService(GradingAssessmentRepository sastr) {
        _sastr = sastr;
    }
    
    /**
     * Method to get all.
     * 
     * @author 2250
     * @since 20201116
     * @return customers
     */
    @GET
    @Produces("application/json")
    public Response getAll()
    {
        ArrayList<GradingTrack> assessments = (ArrayList<GradingTrack>) _sastr.findAll();

         if (assessments == null || assessments.isEmpty()) {
            return Response.status(404).build();
        } else {
            return Response
                    .status(200)
                    .entity(assessments).build();
        }

    }
    
/**
     * Method to get by their id using REST.
     * 
     * @author 2250
     * @since 20220201
     * @return response
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getAssessmentById(@PathParam("id") Integer id) throws URISyntaxException
    {
        Optional<GradingTrack> assessmentFound = _sastr.findById(id);
         if (!assessmentFound.isPresent()) {
            return Response.status(404).build();
        } else {
            return Response
                    .status(200)
                    .entity(assessmentFound).build();
        }
    }
    
/**
     * Method to create using REST.
     * 
     * @author 2250
     * @since 20201116
     * @return response
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(String assessmentJson)
    {
        try{
            String temp = save(assessmentJson);
            return Response.status(HttpURLConnection.HTTP_CREATED).entity(temp).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();        
        }catch(AllAttributesNeededException aane){
            System.out.println("AANE Exception happened adding ticket order.");
            //https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses
            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(aane.getMessage()).build();
        }catch(Exception e){
            System.out.println("Exception happened adding ticket order.");
            //https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses
            
            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(e.getMessage()).build();
        }
    }
//    /**
//     * Method to update a customer using REST.
//     * 
//     * @author PAAG
//     * @since 20201116
//     * @return response
//     */
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(@javax.ws.rs.PathParam("id") int id, String assessmentJson) throws URISyntaxException 
    {

        
        
        try{
            String temp = save(assessmentJson);
            return Response.status(201).entity(temp).header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();        
        }catch(AllAttributesNeededException aane){
            return Response.status(400).entity(aane.getMessage()).build();
        }

    }

    /**
     * Method to make sure all required inputs are present.
     * 
     * @author 2250
     * @since 20220201
     * @return string
     */
    public String save(String json) throws AllAttributesNeededException{
        
        Gson gson = new Gson();
        GradingTrack assessment = gson.fromJson(json, GradingTrack.class);
        //assessment.setAssessmentDate(CisUtility.getCurrentDate("yyyy-MM-dd"));
        
        if(assessment.getId() == null){
            assessment.setId(0);
        }

       // assessment.setTechnicalScore(GradingTrackBO.calculateScore(assessment));

        assessment = _sastr.save(assessment);

        String temp = "";
        temp = gson.toJson(assessment);

        return temp;
        
        
    }
    
}
