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
public class StudentTester {
    
    public static void main(String[] args){
        
        Student student = new Student("Danny","Lambord","500","Computer science");
        System.out.println("Testing toString, expecting to see "
                + "'[Forename = Danny, Surname = Lambord, StudentID = 500, Degree scheme = Computer science]'");
        System.out.println(student.toString());
        System.out.println("Testing getForeName, expecting to see 'Danny'");
        System.out.println(student.getForeName());
        System.out.println("Testing getSurName, expecting to see 'Lambord'");
        System.out.println(student.getSurName());
        System.out.println("Testing getStudentID, expecting to see '500'");
        System.out.println(student.getStudentID());
        System.out.println("Testing getDegree, expecting to see 'Computer science'");
        System.out.println(student.getDegree());
        
    }
    
}
