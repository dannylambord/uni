/*
Program Title: ChatServerThread
Author: Connor Goodrum and Danny Lambord
Created: 08/01/2017
Version: 1.0
*/

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServerThread extends Thread
{  private Socket          socket   = null;
   private ChatServer3      server   = null;
   private int             ID       = -1;
   private DataInputStream streamIn =  null;

   public ChatServerThread(ChatServer3 _server, Socket _socket)
   {  
       server = _server;  socket = _socket;  ID = socket.getPort();
   }
   public void run()
   {  
      System.out.println("Server Thread " + ID + " running.");
      
      while (true)
      {    
        Scanner in = null;
        
        try 
        {
           in = new Scanner(socket.getInputStream());
        } 
        catch (IOException ex) 
        {
           Logger.getLogger(ChatServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean done = false;
        
        while (!done) 
        {
            String line = in.nextLine();
            System.out.println(ID + ">>> " + line);//Printing thread number and user input to server console
            done = line.equals(".bye");//Quiting is ".bye" is inputted
        }
      }
   }
   
   public void open() throws IOException
   {  
      streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
   }
   
   public void close() throws IOException
   {  
      if (socket != null)    socket.close();
      if (streamIn != null)  streamIn.close();
   }
}
