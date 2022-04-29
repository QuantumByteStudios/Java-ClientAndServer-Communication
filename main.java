import java.io.*;
import java.util.Scanner;

import javax.sound.midi.VoiceStatus;

// Main Class
public class main {
  public static void main(String[] args) {

    // Creating Basic Objects
    systemUtilities currentInstance = new systemUtilities();
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

// Other Classes

class systemUtilities {

  public static void clear() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {
    }
  }

  public static void systemInvoke(String command) {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", command).inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec(command);
    } catch (IOException | InterruptedException ex) {
    }
  }

  public static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

}

class beautification {

  public static void delayTextEffect(String text) {
    for (int i = 0; i < text.length(); i++) {
      char printIt = text.charAt(i);
      System.out.print(printIt);
      systemUtilities.sleep(100);
    }
  }

}

class ConsoleColors {
  // Reset
  public static final String RESET = "\033[0m"; // Text Reset

  // Regular Colors
  public static final String BLACK = "\033[0;30m"; // BLACK
  public static final String RED = "\033[0;31m"; // RED
  public static final String GREEN = "\033[0;32m"; // GREEN
  public static final String YELLOW = "\033[0;33m"; // YELLOW
  public static final String BLUE = "\033[0;34m"; // BLUE
  public static final String PURPLE = "\033[0;35m"; // PURPLE
  public static final String CYAN = "\033[0;36m"; // CYAN
  public static final String WHITE = "\033[0;37m"; // WHITE

  // Bold
  public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
  public static final String RED_BOLD = "\033[1;31m"; // RED
  public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
  public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
  public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
  public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
  public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
  public static final String WHITE_BOLD = "\033[1;37m"; // WHITE

  // Underline
  public static final String BLACK_UNDERLINED = "\033[4;30m"; // BLACK
  public static final String RED_UNDERLINED = "\033[4;31m"; // RED
  public static final String GREEN_UNDERLINED = "\033[4;32m"; // GREEN
  public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
  public static final String BLUE_UNDERLINED = "\033[4;34m"; // BLUE
  public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
  public static final String CYAN_UNDERLINED = "\033[4;36m"; // CYAN
  public static final String WHITE_UNDERLINED = "\033[4;37m"; // WHITE

  // Background
  public static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
  public static final String RED_BACKGROUND = "\033[41m"; // RED
  public static final String GREEN_BACKGROUND = "\033[42m"; // GREEN
  public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
  public static final String BLUE_BACKGROUND = "\033[44m"; // BLUE
  public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
  public static final String CYAN_BACKGROUND = "\033[46m"; // CYAN
  public static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

  // High Intensity
  public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
  public static final String RED_BRIGHT = "\033[0;91m"; // RED
  public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
  public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
  public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
  public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
  public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
  public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE

  // Bold High Intensity
  public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
  public static final String RED_BOLD_BRIGHT = "\033[1;91m"; // RED
  public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
  public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
  public static final String BLUE_BOLD_BRIGHT = "\033[1;94m"; // BLUE
  public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
  public static final String CYAN_BOLD_BRIGHT = "\033[1;96m"; // CYAN
  public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

  // High Intensity backgrounds
  public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
  public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
  public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
  public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
  public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
  public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
  public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m"; // CYAN
  public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m"; // WHITE

  public static void RESETSCREEN() {
    System.out.print(ConsoleColors.RESET);
  }
}