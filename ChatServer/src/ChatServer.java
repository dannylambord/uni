/*
Program Title: ChatServer
Author: Connor Goodrum and Danny Lambord
Created: 08/01/2017
Version: 1.0
*/


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer
{

    private Socket socket;//Creation of socket for client connection
    private ServerSocket server;//Creation of server socket for client to connect to

    public ChatServer(int port) throws IOException
    {
        ServerSocket server;
        Socket socket = null;
        
        try
        {
            // Register service on port 8888
            server = new ServerSocket(port);
            // Wait and accept a connection
            System.out.println("Server started: " + server);
            System.out.println("Waiting for conection ...");
            socket = server.accept();
            System.out.println("Socket created: " + socket);
            System.out.println("Connected to client ..." );
            // Get streams associated with the socket
            Scanner in = new Scanner(socket.getInputStream());
            boolean done = false;
            
            while (!done)
            {
                String line = in.nextLine();
                System.out.println(line);
                done = line.equals(".bye");//Sets done to true when .bye is entered
             }
            
        } //End try
        catch(IOException e)
        {
            System.out.println(e);
        }
        finally
        {
            socket.close();//Closes connection when .bye is entered
            System.out.println("Connection closed ...");

        }
    } 
    
    
    public static void main(String args[])throws IOException
    {
        ChatServer client;
        if (args.length != 1)//Checks that 1 argument has been entered
        {    
            System.out.println("Usage: java ChatServer port");
        }
        else
        {
            int port = Integer.parseInt(args[0]);
            client = new ChatServer(port);//Creates a new server with port number that has been entered
        }
    }
}
