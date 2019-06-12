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
public class DeleteServlet extends HttpServlet 
{

    public void init(ServletConfig config) throws ServletException 
    {
        super.init(config);
    }

    /**
     * Process the HTTP Get request
     */
    public void doPost(HttpServletRequest req,
    HttpServletResponse res) throws ServletException,
    IOException 
    {
        String connectionURL = "jdbc:mysql://mysql.cs.bangor.ac.uk/eeu689";
        Connection connection = null;
        ResultSet rs = null;
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        //get the variables entered in the form
        String word = req.getParameter("word");

        try 
        {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");
            // Get a Connection to the database
            connection = DriverManager.getConnection(connectionURL, "eeu689", "lambord97");
            //Add the data into the database
            String sql = "DELETE FROM Questions WHERE Question= ?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, word);
            int numRowsChanged = pst.executeUpdate();
            // show that the new account has been created
            pst.close();
        } 
        
        catch (ClassNotFoundException e)
        {
        out.println("Couldn't load database driver: " + e.getMessage());
        } 
        
        catch (SQLException e) 
        {
        out.println("SQLException caught: "+ e.getMessage());
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
