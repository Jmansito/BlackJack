import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("deprecation")
public class rules extends Main{
    public static void ruleCall() {
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
}
