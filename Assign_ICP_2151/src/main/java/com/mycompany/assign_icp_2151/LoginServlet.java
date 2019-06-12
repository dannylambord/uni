package com.mycompany.assign_icp_2151;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    public static String type = null;
    public static String n = null;

    public  void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        n=request.getParameter("username");  //Get username from form
        String p=request.getParameter("userpass");  //Get password from form
        
        HttpSession session = request.getSession(false);
        
        if(session!=null)
        {
            session.setAttribute("name", n);//Set name to variable n (username) set throughout the program
        }
        
        if(validate(n, p))
        {  
            if("Admin".equals(type))
            {
                RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");  //If validated go to welcome.jsp
                rd.forward(request,response); 
            }
            else if("user".equals(type))
            {
                RequestDispatcher rd=request.getRequestDispatcher("user.jsp");  //If validated go to welcome.jsp
                rd.forward(request,response);
            }
            
            else if("instructor".equals(type))
            {
                RequestDispatcher rd=request.getRequestDispatcher("instructor.jsp");  //If validated go to welcome.jsp
                rd.forward(request,response);
            }
        }
        
        else
        {  
            out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
            rd.include(request,response);  
        }  

        out.close();  
    } 
    
    public static boolean validate(String name, String pass) 
    {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://mysql.cs.bangor.ac.uk/eeu689"; //location of Database
        String driver = "com.mysql.jdbc.Driver"; //Driver used to connect
        String userName = "eeu689";
        String password = "lambord97";
        
        try 
        {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, userName, password);//Makes database connection

            pst = conn.prepareStatement("select * from form where user=? and password=?");//SQL statement 
            pst.setString(1, name);//First ?^
            pst.setString(2, pass);//Second ?^^
            rs = pst.executeQuery();
            
            if(rs.next())
            {
            type = rs.getString(4);
            System.out.println(type);
            }

            rs = null;
            rs = pst.executeQuery();//Execute the query in sql
            status = rs.next();

        } 
        
        catch (Exception e) 
        {
            System.out.println(e);
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
        
        return status;
    } 
} 