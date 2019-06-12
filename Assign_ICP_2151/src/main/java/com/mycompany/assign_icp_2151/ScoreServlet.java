/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.assign_icp_2151;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author eeu689
 */
public class ScoreServlet extends HttpServlet 
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
        res.setContentType("text/html");//Expecting a html response
        PrintWriter out = res.getWriter(); 
        Connection conn = null;
        
        int i=1;
        int count = 0;
        
        String g = "";  
        String ans="";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://mysql.cs.bangor.ac.uk/eeu689";
        String user = "eeu689";
        String pass = "lambord97";
        
        String n=req.getParameter("question");  //Get username from form
        String h = "";
        String u = LoginServlet.n;
        String g1 = "";
        
        int q = 0;

        ResultSet qrst;
        ResultSet rs = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
    
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;

        try 
        {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, user, pass);//Makes database connection
            pst = conn.prepareStatement("SELECT * FROM eeu689.Questions where Question = ?");//SQL statement 
            pst.setString(1, n);//First ?^
            System.out.println(pst);
            rs = pst.executeQuery();
            pst1 = conn.prepareStatement("SELECT * From eeu689.form where user =?");//SQL statement 
            pst1.setString(1, u);//First ?^
            System.out.println(pst1);
            rs1 = pst1.executeQuery();
            
            if(rs.first())
            {
                h = rs.getString(6);
            }
            
            if(rs1.next())
            {
                g1 = rs1.getString(5);
                q = Integer.parseInt(g1); 
            }
            
            ans=h;//Assign correct answer to ans
            g=req.getParameter("a");//Gets users answer and assigns to g

            if(g.equals(ans))//Checks if users answer is correct
            {
                count++;
                out.println("Correct  ");
                out.println("Score="+count);
                out.println("  Best score =" + q );
            }
            else
            {
                out.println("Score="+count);
                out.println("  Best score =" + g);
                out.println("  false");
            }

            if(rs1.first())
            {
                g1 = rs1.getString(5);
                String userid = rs1.getString(1);
                q = Integer.parseInt(g1);
                String c1 = String.valueOf(count);
                
                if(q<count)
                {
                    PreparedStatement pst2 = 
                    conn.prepareStatement("UPDATE form SET bestScore = ? WHERE uId = ?");
                    pst2.setString(1, c1);
                    pst2.setString(2, userid);
                    int numRowsChanged = pst2.executeUpdate();
                    pst2.close();
                }

            }





        } 
        
        catch (Exception e) 
        {
            System.out.println(e);
            System.out.println("5");
        } 
        
        finally 
        {
            if (conn != null) 
            {
                try 
                {
                    conn.close();//Close connection
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
            
            if (pst != null) 
            {
                try 
                {
                pst.close();//Close statement
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
            if (rs != null) 
            {
                try 
                {
                    rs.close();//Close the results recieved
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
