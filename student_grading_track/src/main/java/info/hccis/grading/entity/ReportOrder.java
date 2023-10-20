package info.hccis.grading.entity;

import info.hccis.grading.jpa.entity.GradingTrack;
import info.hccis.grading.jpa.entity.TicketOrder;
import java.util.ArrayList;

/**
 * Entity class to hold the attributes of the order related reports.
 * @author bjmaclean
 * @since 20220621
 */
public class ReportOrder {
    private String dateStart;
    private String dateEnd;
    private String studentName;
     private ArrayList<TicketOrder> ticketOrders;
     
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

   
    
    
    
    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ArrayList<TicketOrder> getTicketOrders() {
        return ticketOrders;
    }

    public void setTicketOrders(ArrayList<TicketOrder> ticketOrders) {
        this.ticketOrders = ticketOrders;
    }

  

   
    
    
}
