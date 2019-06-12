package com.mycompany.assign_icp_2151;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet
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
    String uId = req.getParameter("uId");
    String fname = req.getParameter("name");
    String sname = req.getParameter("pass");
    String address1 = req.getParameter("userType");

    try 
    {
        // Load the database driver
        Class.forName("com.mysql.jdbc.Driver");
        // Get a Connection to the database
        connection = DriverManager.getConnection(connectionURL, "eeu689", "lambord97"); 
        //Add the data into the database
        String sql ="insert into form values (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, uId);
        pst.setString(2, fname);
        pst.setString(3, sname);
        pst.setString(4, address1);

        int numRowsChanged = pst.executeUpdate();
        pst.close();
    }
    
    catch(ClassNotFoundException e)
    {
        out.println("Couldn't load database driver: " + e.getMessage());
    }
    
    catch(SQLException e)
    {
        out.println("SQLException caught: "+ e.getMessage());
    }
    catch (Exception e){
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