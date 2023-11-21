
package info.hccis.model.jpa;

import info.hccis.student.util.CisUtility;
import java.io.Serializable;


/**
 *
 * @author jwang129300
 */

public class GradingTrack implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;  
    private String studentName; 
    private String instructorName;   
    private String courseName;
    private String courseRoom;
    private Double numericGrade;
    private String letterGrade;
    private Double overallGrade;
    private String overallLetterGrade;
    private Integer academicYear;

    public GradingTrack() {
    }

    public GradingTrack(Integer id) {
        this.id = id;
    }

    public GradingTrack(Integer id, String studentName, String instructorName, String courseName, String courseRoom, String letterGrade, String overallLetterGrade) {
        this.id = id;
        this.studentName = studentName;
        this.instructorName = instructorName;
        this.courseName = courseName;
        this.courseRoom = courseRoom;
        this.letterGrade = letterGrade;
        this.overallLetterGrade = overallLetterGrade;
    }
    
     public void getInformation(){
        studentName = CisUtility.getInputString("Student name");
        courseName = CisUtility.getInputString("Course name");
        instructorName = CisUtility.getInputString("instructorName");
        courseRoom = CisUtility.getInputString("courseRoom");
        numericGrade = CisUtility.getInputDouble("numericGrade");
        letterGrade = CisUtility.getInputString("letterGrade");
        academicYear = CisUtility.getInputInt("academicYear");
        overallGrade=CisUtility.getInputDouble("overallGrade");
        overallLetterGrade=CisUtility.getInputString("overallLetterGrade");
//        backhandVolleyMax = CisUtility.getInputInt("BH Volley Max");
//        forehandVolleySum = CisUtility.getInputInt("FH Volley Sum");
//        backhandVolleySum = CisUtility.getInputInt("BH Volley Sum");
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseRoom() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom = courseRoom;
    }

    public Double getNumericGrade() {
        return numericGrade;
    }

    public void setNumericGrade(Double numericGrade) {
        this.numericGrade = numericGrade;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public Double getOverallGrade() {
        return overallGrade;
    }

    public void setOverallGrade(Double overallGrade) {
        this.overallGrade = overallGrade;
    }

    public String getOverallLetterGrade() {
        return overallLetterGrade;
    }

    public void setOverallLetterGrade(String overallLetterGrade) {
        this.overallLetterGrade = overallLetterGrade;
    }

   public Integer getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(Integer academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

     
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
       if (!(object instanceof GradingTrack)) {
            return false;
        }
        GradingTrack other = (GradingTrack) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
           return false;
        }
       return true;
    }

    @Override
    public String toString() {
        String output="Assessment Details: StudentName: " + getStudentName() 
                + " CourseName: " + getCourseName() + " Grade: " + getNumericGrade() 
                + "Letter Grade: " +getLetterGrade() + "Overall Grade: " +getOverallGrade() +"Overall Letter Grade: " +getOverallLetterGrade();
        return output;
    }
    
}

