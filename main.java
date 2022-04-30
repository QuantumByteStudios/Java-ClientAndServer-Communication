import java.io.*;
import java.util.Scanner;

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
        .delayTextEffect("Welcome to " + colorConsole.RED + "Java Console Chat Application\n" + colorConsole.RESET);
    beautyElement.delayTextEffect(
        colorConsole.YELLOW + "Please Enter your " + colorConsole.GREEN + "Name: ");
    userName = getInput.nextLine();

    ConsoleColors.RESETSCREEN();

    // Destruction Section :P
    getInput.close();
  }
}