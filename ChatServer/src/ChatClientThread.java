import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatClientThread extends Thread
{  private Socket           socket   = null;
   private ChatClient       client   = null;
   private DataInputStream  streamIn = null;

   public ChatClientThread(ChatClient _client, Socket _socket) throws InterruptedException
   {  client   = _client;
      socket   = _socket;
      open();  
      start();
   }
   public void open() throws InterruptedException
   {  try
      {  streamIn  = new DataInputStream(socket.getInputStream());
      }
      catch(IOException ioe)
      {  System.out.println("Error getting input stream: " + ioe);
         client.stop();
      }
   }
   public void close()
   {  try
      {  if (streamIn != null) streamIn.close();
      }
      catch(IOException ioe)
      {  System.out.println("Error closing input stream: " + ioe);
      }
   }
   public void run()
   {  while (true)
      {  try
         {  client.handle(streamIn.readUTF());
         }
         catch(IOException ioe)
         {  System.out.println("Listening error: " + ioe.getMessage());
          try {
              client.stop();
          } catch (InterruptedException ex) {
              Logger.getLogger(ChatClientThread.class.getName()).log(Level.SEVERE, null, ex);
          }
         } catch (InterruptedException ex) {
           Logger.getLogger(ChatClientThread.class.getName()).log(Level.SEVERE, null, ex);
       }
      }
   }
}