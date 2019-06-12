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
            = new LinkedList<Student>();
    
    public Registry(Student aStudent)
    {
        studentList = new LinkedList();
    
    }
    public void addStudent(Student aStudent)
    {
        studentList.add(aStudent);
        
    }
    public void deleteStudent(Student aStudent)
    {
        studentList.remove(aStudent);
    }
    public String toString(){
    
        return"[" + studentList;
    }
    public String format()
    {
        return null;
    }
}