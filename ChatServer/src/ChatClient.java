/*
Program Title: ChatClient
Author: Connor Goodrum and Danny Lambord
Created: 08/01/2017
Version: 1.0
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    private Socket socket;

    public ChatClient(String serverName, int port) throws IOException {
        System.out.println(
                "Establishing connection. Please wait ...");

        try {
            Socket socket = new Socket(serverName, port);
            System.out.println("Client socket created: " + socket);
            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream()); //Prints to console screen
            String line = ""; // Need an initial string

            while (!line.equals(".bye"))//If line doesnt = .bye
            {
                line = in.nextLine();
                out.println(line);
                out.flush();
            }
        } // End try
        catch (UnknownHostException e) {
        } catch (IOException e) {
        } finally {
            System.out.println("Closing connection ...");
            socket.close();//Close connection
        }

    }

    public static void main(String args[]) throws IOException {
        ChatClient client;
        if (args.length != 2) 
        {
            System.out.println("Usage: java ChatClient serverName port");
        } else {
            String serverName = args[0];
            int port = Integer.parseInt(args[1]);
            client = new ChatClient(serverName, port);
        }
    }
}
