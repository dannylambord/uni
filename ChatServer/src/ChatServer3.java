/*
Program Title: ChatServer
Author: Connor Goodrum and Danny Lambord
Created: 08/01/2017
Version: 3.0
*/

import java.net.*;
import java.io.*;

public class ChatServer3 implements Runnable
{  
   private ServerSocket     server = null;
   private Thread           thread = null;
   private ChatServerThread client = null;

   public ChatServer3(int port)
   { 
      try
      { 
        System.out.println("Binding to port " + port + ", please wait  ...");
        server = new ServerSocket(port);  //Creating new server socket with port number
        System.out.println("Server started: " + server);
        start();//Starting thread
      }
      catch(IOException ioe)
      {
        System.out.println(ioe); 
      }
   }
   
   public void run()
   {  
       while (thread != null)
       {  
         try
         {
            System.out.println("Waiting for a client ..."); 
            addThread(server.accept());//Adding a thread to the server 
         }
         catch(IOException ie)
         {  
            System.out.println("Acceptance Error: " + ie); 
         }
      }
   }
   
   public void addThread(Socket socket) throws IOException
   {  
      System.out.println("Client accepted: " + socket);
      client = new ChatServerThread(this, socket);//New thread being created
      client.open();//Opening thread
      client.start();//Starting thread
   }
   
     public void start()
   {  
      if (thread == null)
      {  
        thread = new Thread((Runnable) this); 
        thread.start();
      }
   }
     
   public void stop() throws InterruptedException
   {  
      if (thread != null)
      { 
        thread.sleep(500); //Stopping thread
        thread = null;
      }
   }
   
    public static void main(String args[])throws IOException
    {
        ChatServer3 client;
        if (args.length != 1)//Checks that 1 argument has been entered
        {    
            System.out.println("Usage: java ChatServer port");
        }
        else
        {
            int port = Integer.parseInt(args[0]);
            client = new ChatServer3(port);//Creates a new server with port number that has been entered
        }
    }



}
