
package com.mycompany.lab2;


 import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.Statement;
 

 public class SimpleDataSourceTest 
 {
    public static void main(String[] args) throws Exception
    {   
        
        
       if (args.length == 0)
       {   
          System.out.println(
             "Usage: TestDB propertiesFile");
          System.exit(0);
       }
       else 
          SimpleDataSource.init(args[0]);
       
       Connection conn = SimpleDataSource.getConnection();
 
       Statement stat = conn.createStatement();
 
       stat.execute("CREATE TABLE Test (Name CHAR(20))");
       stat.execute("INSERT INTO Test VALUES ('Romeo')");
 
       ResultSet result = stat.executeQuery("SELECT * FROM Test");
       result.next();
       System.out.println(result.getString("Name"));
       result.close();
 
       //stat.execute("DROP TABLE Test");
       
       stat.close();
       conn.close();
    }
 }
