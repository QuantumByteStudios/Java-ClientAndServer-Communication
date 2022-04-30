import java.io.*;
import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.text.Utilities;

// Main Class
public class main {
  public static void main(String[] args) {

    // Creating Basic Objects
    utilities currentInstance = new utilities();
    beautification beautyElement = new beautification();
    ConsoleColors colorConsole = new ConsoleColors();
    Scanner getInput = new Scanner(System.in);
    // Objects End

    // Initial Methods Invoke
    currentInstance.clear();
    // Initial Methods Invoke End

    // Main Variables
    String userName;

    // System.out.println("Java Console Chat App"); //Basic
    // systemUtilities.sleep(500);
    beautyElement
        .delayTextEffect(
            "Welcome to " + colorConsole.RED + "Java-ClientAndServer-Communication\n" + colorConsole.RESET);
    beautyElement.delayTextEffect(
        colorConsole.YELLOW + "Please Enter your " + colorConsole.GREEN + "Name: ");
    userName = getInput.nextLine();

    ConsoleColors.RESETSCREEN();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    try {
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("logs.txt", true)));
      out.println(dtf.format(now) + " Login: " + userName);
      out.close();
    } catch (IOException e) {
    }

    System.out.print("\nHey, " + colorConsole.RED + userName + colorConsole.RESET
        + " What You Want To Execute: \n--> 1) Server\n--> 2) Client\n\nYour Input: ");
    int choice = getInput.nextInt();
    switch (choice) {
      case 1:
        currentInstance.systemInvoke("java Server");
        break;
      case 2:
        currentInstance.systemInvoke("java Client");
        break;
      default:
        System.out.println(colorConsole.RED + "Error: Invalid Option" + colorConsole.RESET);
        break;
    }

    // Destruction Section :P
    getInput.close();
  }
}