/*
Program Title: ChatServer
Author: Connor Goodrum and Danny Lambord
Created: 08/01/2017
Version: 2.0
*/

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer2 implements Runnable
{

    private Socket socket;//Creation of socket for client connection
    private ServerSocket server;//Creation of server socket for client to connect to
    private Thread thread = null;
    private DataInputStream  streamIn  =  null;
    
    
    /**
     *
     * @param port
     */
    public ChatServer2(int port) throws IOException
   {    
       System.out.println("Binding to port " + port + ", please wait  ...");
         server = new ServerSocket(port);  
         System.out.println("Server started: " + server);
         start();
     
   }
    
    
     public void run()
   {  while (thread != null)
      {   try
         {  
           
            System.out.println("Waiting for a client ..."); 
            socket = server.accept();//Server accepts client
            System.out.println("Client accepted: " + socket);
            open();
            boolean done = false;
            while (!done)
            {  
               try
               {  
                  String line = streamIn.readUTF();
                  System.out.println(line);
                  done = line.equals(".bye");
               }
               catch(IOException ioe)
               {  
                  done = true;  
               }
            }
            close();
         }
         catch(IOException ie)
         {  
         }
      }
   }
     
    public void open() throws IOException
   {  
       streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream())); //Gets input stream from client
   }
   public void close() throws IOException
   {  if (socket != null)    socket.close();//Close the client socket
      if (streamIn != null)  streamIn.close();//Close the input stream
   }
    
      public void start()
   {  if (thread == null)
      {  thread = new Thread((Runnable) this); 
         thread.start();
      }
   }
   public void stop() throws InterruptedException
   {  if (thread != null)
      {  thread.sleep(500); 
         thread = null;
      }
   }
    
    
    public static void main(String args[])throws IOException
    {
        ChatServer2 client;
        if (args.length != 1)//Checks that 1 argument has been entered
        {    
            System.out.println("Usage: java ChatServer port");
        }
        else
        {
            int port = Integer.parseInt(args[0]);
            client = new ChatServer2(port);//Creates a new server with port number that has been entered
        }
    }
}
