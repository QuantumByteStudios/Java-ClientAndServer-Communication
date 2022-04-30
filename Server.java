import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server {

  // initialize socket and input stream
  private Socket socket = null;
  private ServerSocket server = null;
  private DataInputStream in = null;

  beautification serverBeautification = new beautification();

  // constructor with port
  public Server(int port) {
    // starts server and waits for a connection
    try {

      ConsoleColors currentConsole = new ConsoleColors();

      server = new ServerSocket(port);
      serverBeautification.delayTextEffect(currentConsole.YELLOW + "Server started" + currentConsole.RESET + "\n");

      serverBeautification
          .delayTextEffect(currentConsole.YELLOW + "Waiting for a client ..." + currentConsole.RESET + "\n");

      socket = server.accept();
      serverBeautification.delayTextEffect(currentConsole.GREEN + "Client Connected.." + currentConsole.RESET + "\n");

      // takes input from the client socket
      in = new DataInputStream(
          new BufferedInputStream(socket.getInputStream()));

      String line = "";

      // reads message from client until "Over" is sent
      while (!line.equals("/exit")) {
        try {
          line = in.readUTF();
          System.out.println(
              currentConsole.BLUE + "Client Message: " + currentConsole.RESET + currentConsole.WHITE_BOLD + line
                  + currentConsole.RESET);

        } catch (IOException i) {
          System.out.println(i);
        }
      }
      System.out.println(currentConsole.RED + "Connection Closed!" + currentConsole.RESET);

      // close connection
      socket.close();
      in.close();
    } catch (IOException i) {
      System.out.println(i);
    }
  }

  public static void main(String args[]) {

    // Creating Basic Objects
    utilities serverInstance = new utilities();
    // Objects End

    // Initial Methods Invoke
    serverInstance.clear();
    // Initial Methods Invoke End

    // Server Object Creation
    Server server = new Server(5000);

  }
}