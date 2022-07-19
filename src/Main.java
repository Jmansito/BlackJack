import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    public static void rules(){
        System.out.println("Opening rules in your default browser...");
        String url = "https://bicyclecards.com/how-to-play/blackjack/";

        // Cross-platform url opener, code provided by Brajesh Kumar - Stackoverflow.com
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void menu(){
        Scanner myObj = new Scanner(System.in);
        int choice = 0;
        System.out.println("WELCOME TO BLACKJACK!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.println("Please choose an option:");
        System.out.println("1: PLAY BLACKJACK");
        System.out.println("2: READ RULES");
        System.out.println("3: EXIT GAME\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~\n");

        // Error checking user input, needs to be an int
        try{
            choice = myObj.nextInt();
        } catch (InputMismatchException a){
            System.out.println("Not a valid input, please try again and select 1 - 3");
            menu();
        }
        switch (choice) {
            // Run blackjack game
            case 1 -> System.out.println("Running game");
            // Run rules function
            case 2 -> {
                rules();
                // one-second delay to show process working (and to learn .sleep)
                try {Thread.sleep(1000);}
                catch(InterruptedException ex) {ex.printStackTrace();}
                //send back to menu after rules and delay
                menu();
            }
            // Exit game
            case 3 -> {
                System.out.println("Thank you for playing");
                System.exit(0);
            }
            // Not a valid input
            default -> {
                System.out.println("Please enter a valid input");
                menu();
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}