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
import java.util.*;
public class Registry
{
    LinkedList<Student> studentList 
            = new LinkedList <Student>();
    public Registry(Student aStudent, String studentID) 
    {
        addStudent(aStudent);
        
    }
    public void addStudent(Student aStudent)
    {
        studentList.add(aStudent);
    
    }
    public void deleteStudent(String studentID) 
    {
        studentList.remove(studentID);
    
    }
    public String toString(){
    
        return "[ Student 1 = " + studentList;
    }
    public String format()
    {
        return null;
        
    }
}