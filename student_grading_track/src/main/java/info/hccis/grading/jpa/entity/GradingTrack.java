/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package info.hccis.grading.jpa.entity;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jwang129300
 */
@Entity
@Table(name = "gradingtrack")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GradingTrack.findAll", query = "SELECT g FROM GradingTrack g"),
    @NamedQuery(name = "GradingTrack.findById", query = "SELECT g FROM GradingTrack g WHERE g.id = :id"),
    @NamedQuery(name = "GradingTrack.findByStudentName", query = "SELECT g FROM GradingTrack g WHERE g.studentName = :studentName"),
    @NamedQuery(name = "GradingTrack.findByInstructorName", query = "SELECT g FROM GradingTrack g WHERE g.instructorName = :instructorName"),
    @NamedQuery(name = "GradingTrack.findByCourseName", query = "SELECT g FROM GradingTrack g WHERE g.courseName = :courseName"),
    @NamedQuery(name = "GradingTrack.findByCourseRoom", query = "SELECT g FROM GradingTrack g WHERE g.courseRoom = :courseRoom"),
    @NamedQuery(name = "GradingTrack.findByNumericGrade", query = "SELECT g FROM GradingTrack g WHERE g.numericGrade = :numericGrade"),
    @NamedQuery(name = "GradingTrack.findByLetterGrade", query = "SELECT g FROM GradingTrack g WHERE g.letterGrade = :letterGrade"),
    @NamedQuery(name = "GradingTrack.findByOverallGrade", query = "SELECT g FROM GradingTrack g WHERE g.overallGrade = :overallGrade"),
    @NamedQuery(name = "GradingTrack.findByOverallLetterGrade", query = "SELECT g FROM GradingTrack g WHERE g.overallLetterGrade = :overallLetterGrade"),
    @NamedQuery(name = "GradingTrack.findByAcademicYear", query = "SELECT g FROM GradingTrack g WHERE g.academicYear = :academicYear")})
public class GradingTrack implements Serializable {

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
        return "info.hccis.performance.jpa.entity.GradingTrack[ id=" + id + " ]";
    }
    
}
