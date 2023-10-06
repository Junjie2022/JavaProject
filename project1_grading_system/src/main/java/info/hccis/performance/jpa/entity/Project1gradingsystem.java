/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info.hccis.performance.jpa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jwang129300
 */
@Entity
@Table(name = "project1gradingsystem")
@NamedQueries({
    @NamedQuery(name = "Project1gradingsystem.findAll", query = "SELECT p FROM Project1gradingsystem p")})
public class Project1gradingsystem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "studentName")
    private String studentName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "instructorName")
    private String instructorName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "courseName")
    private String courseName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "courseRoom")
    private String courseRoom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "numericGrade")
    private Double numericGrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "letterGrade")
    private String letterGrade;
    @Column(name = "overallGrade")
    private Double overallGrade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "overallLetterGrade")
    private String overallLetterGrade;
    @Column(name = "academicYear")
    private Integer academicYear;

    public Project1gradingsystem() {
    }

    public Project1gradingsystem(Integer id) {
        this.id = id;
    }

    public Project1gradingsystem(Integer id, String studentName, String instructorName, String courseName, String courseRoom, String letterGrade, String overallLetterGrade) {
        this.id = id;
        this.studentName = studentName;
        this.instructorName = instructorName;
        this.courseName = courseName;
        this.courseRoom = courseRoom;
        this.letterGrade = letterGrade;
        this.overallLetterGrade = overallLetterGrade;
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
        if (!(object instanceof Project1gradingsystem)) {
            return false;
        }
        Project1gradingsystem other = (Project1gradingsystem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "info.hccis.performance.jpa.entity.Project1gradingsystem[ id=" + id + " ]";
    }
    
}
