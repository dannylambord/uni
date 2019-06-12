/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assign_icp_2151;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eeu689
 */
public class UpdateServlet extends HttpServlet 
{
    public void init(ServletConfig config) throws ServletException
    {
      super.init(config);
    }
      /**Process the HTTP Get request*/
      public void doPost(HttpServletRequest req, 
      HttpServletResponse res) throws ServletException,
      IOException
      {
        String connectionURL = "jdbc:mysql://mysql.cs.bangor.ac.uk/eeu689";
        Connection connection=null;
        ResultSet rs;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        //get the variables entered in the form
        String currentQues = req.getParameter("currentQues");
        String Question = req.getParameter("nQuestion");
        String nAns1 = req.getParameter("nAns1");
        String nAns2 = req.getParameter("nAns2");
        String nAns3 = req.getParameter("nAns3");
        String nAns4 = req.getParameter("nAns4");
        String nCorrectAns = req.getParameter("nCorrectAns");


        try 
        {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get a Connection to the database
            connection = DriverManager.getConnection(connectionURL, "eeu689", "lambord97"); 
            //Add the data into the database
            String sql ="UPDATE Questions SET Question = ?, Ans1 = ?, Ans2 = ?, Ans3 = ?, Ans4, CorrectAns = ? WHERE Question = ?;";
            PreparedStatement pst =connection.prepareStatement(sql);
            pst.setString(1, Question);
            pst.setString(2, nAns1);
            pst.setString(3, nAns2);
            pst.setString(4, nAns3);
            pst.setString(5, nAns4);
            pst.setString(6, nCorrectAns);
            pst.setString(7, currentQues);

            int numRowsChanged = pst.executeUpdate();
            // show that the new account has been created
            pst.close();
        }
        
        catch(ClassNotFoundException e)
        {
            out.println("Couldn't load database driver: " + e.getMessage());
        }
        
        catch(SQLException e)
        {
        out.println("SQLException caught: " + e.getMessage());
        }
        
        catch (Exception e)
        {
            out.println(e);
        }
        
        finally
        {
        // Always close the database connection.
            try 
            {
                if (connection != null) connection.close();
            }
            
            catch (SQLException ignored)
            {
                out.println(ignored);
            }
        }
    }
}
