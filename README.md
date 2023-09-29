# Project:  Grading System #

---
## Development Team ##
Business Client: Victor Pawlowski
<br/>
Lead Developer: Junjie Wang
<br/>
Project Manager: Kevin Pou
<br/>
---
## Description ##
This project allows for both administrators and students to track grades. When logged in with the correct credentials, students are able to view
their courselist, the rooms that the courses are being taught at, as well as their current grade of that particular course. An administrator is
able to view and edit (add/remove/change) student details. 

<br/>
---
## Color ##
Main Color:  #393646 <br/>
Secondary Color: #4F4557 <br/>
Accent Color:  #6D5D6E <br/>
Text Color: #F4EEEE <br/>

---
## Required Fields ##
This will be a list of fields and their datatype (class design format).  7-9 fields.

-instructorName: String </br>
-studentName: String</br>
-courseName: String</br>
-courseRoom: String</br>
-numericGrade: double</br>
-letterGrade: String</br>
-overallGrade: double</br>
-overallLetterGrade: String</br>
-academicYear: int</br>

---
## Calculation ##

Letter grades are determined by the associated numeric grade for the course. 


A - 90 </br>
B - 80 </br>
C - 70 </br>
D - 60 </br>
F - 59 and below</br>

Overall grade is determined by the total grade of all courses of a particular student.

---</br>

## Report Details ##
</br>
The report is to pull information about a specified student (among many). This should pull their full name, all courses taken by the student (can be more than one)
and the associated numeric and letter grade for each of those courses. If the student is taking more than 1 course, this report should also include their
overall grade (average) of all their courses and to display their letter grade as well. 
</br>