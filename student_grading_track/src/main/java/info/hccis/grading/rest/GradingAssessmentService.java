package info.hccis.grading.rest;

import info.hccis.grading.jpa.entity.GradingTrack;
import info.hccis.grading.repositories.GradingAssessmentRepository;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Assessment Service class for accessing using REST.
 *
 * @author 2232
 * @since 20231109
 */
@Path("/SkillsAssessmentService/assessments")
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
    public ArrayList<GradingTrack> getAll()
    {
        ArrayList<GradingTrack> assessments = (ArrayList<GradingTrack>) _sastr.findAll();
        return assessments;
    }
    
//    /**
//     * Method to get by their id using REST.
//     * 
//     * @author 2250
//     * @since 20220201
//     * @return response
//     */
//    @GET
//    @Path("/{id}")
//    @Produces("application/json")
//    public Response getTicketOrderById(@PathParam("id") Integer id) throws URISyntaxException
//    {
//        Optional<TicketOrder> ticketOrder = tor.findById(id);
//         if (!ticketOrder.isPresent()) {
//            return Response.status(204).build();
//        } else {
//            return Response
//                    .status(200)
//                    .entity(ticketOrder).build();
//        }
//    }
//    
//    /**
//     * Method to create using REST.
//     * 
//     * @author 2250
//     * @since 20201116
//     * @return response
//     */
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response create(String ticketOrderJson)
//    {
//        try{
//            String temp = save(ticketOrderJson);
//            return Response.status(HttpURLConnection.HTTP_OK).entity(temp).header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();        
//        }catch(AllAttributesNeededException aane){
//            System.out.println("AANE Exception happened adding ticket order.");
//            //https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses
//            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(aane.getMessage()).build();
//        }catch(Exception e){
//            System.out.println("Exception happened adding ticket order.");
//            //https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#successful_responses
//            
//            return Response.status(HttpURLConnection.HTTP_NOT_ACCEPTABLE).entity(e.getMessage()).build();
//        }
//    }
////    
////    /**
////     * Method to update a customer using REST.
////     * 
////     * @author PAAG
////     * @since 20201116
////     * @return response
////     */
//    @PUT
//    @Path("/{id}")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response updateTicketOrder(@javax.ws.rs.PathParam("id") int id, String ticketOrderJson) throws URISyntaxException 
//    {
//
//        try{
//            String temp = save(ticketOrderJson);
//            return Response.status(201).entity(temp).header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();        
//        }catch(AllAttributesNeededException aane){
//            return Response.status(400).entity(aane.getMessage()).build();
//        }
//
//    }
//
//    /**
//     * Method to make sure all required inputs are present.
//     * 
//     * @author 2250
//     * @since 20220201
//     * @return string
//     */
//    public String save(String json) throws AllAttributesNeededException{
//        
//        Gson gson = new Gson();
//        TicketOrder ticketOrder = gson.fromJson(json, TicketOrder.class);
//        ticketOrder.setDateOfOrder(CisUtility.getCurrentDate("yyyy-MM-dd"));
//        if(ticketOrder.getId() == null){
//            ticketOrder.setId(0);
//        }
//
//        ticketOrder = tor.save(ticketOrder);
//
//        String temp = "";
//        temp = gson.toJson(ticketOrder);
//
//        return temp;
//        
//        
//    }
    
}
