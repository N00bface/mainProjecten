import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @autor Jari Van Melckebeke
 */
public class Main {
    /**
     * in deze methode vind de main runtime plaats.
     *
     * @param args
     */
    public static void main(String[] args) throws MalformedURLException {
        System.out.println("system started");

        String command = getCommand(args);
    }

    /**
     * @return het aangekomen commando zonder het 'Teresa' keyword
     */
    private static String getCommand(String[] args) throws MalformedURLException {
        Configuration config = new Configuration();
        config.setAcousticModelPath("");
        recognizer.allocate();
        microphone.startRecording();

        while (true) {
            Result result = recognizer.recognize();
            if (result != null) {
                String resultText = result.getBestFinalResultNoFiller();
                System.out.println(resultText);
                return resultText;
            }
        }
    }
}
