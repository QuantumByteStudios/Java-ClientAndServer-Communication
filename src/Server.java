import java.net.*;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.text.Utilities;
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

      // Create Object For Console Colors
      ConsoleColors currentConsole = new ConsoleColors();

      // Creates a server socket to the specified port
      server = new ServerSocket(port);

      serverBeautification.delayTextEffect(
          currentConsole.YELLOW + "Server started at Port: " + port + currentConsole.RESET + "\n");
      serverBeautification
          .delayTextEffect(currentConsole.YELLOW + "Waiting for client..." + currentConsole.RESET + "\n");

      socket = server.accept();
      serverBeautification.delayTextEffect(currentConsole.GREEN + "Client Connected.." + currentConsole.RESET + "\n");

      // takes input from the client socket
      // socket.getInputStream() - Returns an input stream for this socket.
      in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

      String line = "";

      // reads message from client until "/exit" is sent
      while (!line.equals("/exit")) {
        try {
          line = in.readUTF();
          System.out.println(
              currentConsole.BLUE + "Client Message: " + currentConsole.RESET + currentConsole.WHITE_BOLD + line
                  + currentConsole.RESET);

          // Check For System Invokes
          utilities serverInstance = new utilities();
          switch (line) {
            case "/sys dir":
              serverInstance.systemInvoke("dir");
              break;
            case "/sys clear":
              serverInstance.systemInvoke("cls");
              break;
          }

          // Write data to logs
          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
          LocalDateTime now = LocalDateTime.now();
          try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("logs.txt", true)));
            out.println(dtf.format(now) + "    " + line);
            out.close();
          } catch (IOException e) {
            // No Exception Message
          }

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

    // Gets Port Number Form Argument
    int portNumber = Integer.parseInt(args[0]);

    // Creating Basic Objects
    utilities serverInstance = new utilities();
    // Objects End

    // Initial Methods Invoke
    serverInstance.clear();
    // Initial Methods Invoke End

    // Server Object Creation
    Server server = new Server(portNumber);

  }
}