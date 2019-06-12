/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

/**
 *
 * @author eeu689
 */
public class Student {

private String foreName;
private String surName;
private String studentID;
private String degreeScheme;

public Student(String aFore, String asur, String aID, String adegree){
    foreName = aFore;
    surName = asur;
    studentID = aID;
    degreeScheme = adegree;
}

public String toString(){
    return "[Forename = " + getForeName() + ", Surname = " + getSurName() 
                + ", StudentID = " + getStudentID() + ", Degree scheme = " + getDegree() + "}";
}

public String getForeName(){
    
    return foreName;
}

public String getSurName(){
    
    return surName;
}

public String getStudentID(){
    
    return studentID;
}

public String getDegree(){
    
    return degreeScheme;
}


    
}
