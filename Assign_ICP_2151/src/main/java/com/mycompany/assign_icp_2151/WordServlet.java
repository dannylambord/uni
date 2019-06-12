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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eeu689
 */
public class WordServlet extends HttpServlet 
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

        String question = req.getParameter("question");
        String ans1 = req.getParameter("ans1");
        String ans2 = req.getParameter("ans2");
        String ans3 = req.getParameter("ans3");
        String ans4 = req.getParameter("ans4");
        String correctAns = req.getParameter("correctAns");

        try 
        {
          // Load the database driver
          Class.forName("com.mysql.jdbc.Driver");
          // Get a Connection to the database
          connection = DriverManager.getConnection(connectionURL, "eeu689", "lambord97"); 
          String sql = "insert into Questions values (?,?,?,?,?,?)";
          PreparedStatement pst = connection.prepareStatement(sql);

          pst.setString(1, question);
          pst.setString(2, ans1);
          pst.setString(3, ans2);
          pst.setString(4, ans3);
          pst.setString(5, ans4);
          pst.setString(6, correctAns);

          int numRowsChanged = pst.executeUpdate();
          RequestDispatcher rd=req.getRequestDispatcher("instructor.jsp");
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
              if (connection != null) 
              {
                  connection.close();
              }
          }

          catch (SQLException ignored)
          {
              out.println(ignored);
          }

        }
    }
}
    
 


