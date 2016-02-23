import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.linguist.dictionary.Dictionary;
import edu.cmu.sphinx.linguist.language.grammar.Grammar;

/**
 * @author Jari Van Melckebeke
 */
public class Input {
    private Configuration configuration;
    private LiveSpeechRecognizer recognizer;

    /**
     * deze methode zorgt voor de invoer
     * @throws Exception
     */
    public Input() throws Exception {
        configuration = new Configuration();
        configuration
                .setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration
                .setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration
                .setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
        configuration
        recognizer = new LiveSpeechRecognizer(configuration);
    }

    /**
     * deze methode zorgt voor de invoer van een commando, ongeacht of deze legitiem is of niet
     * @return de ingesproken commando, inclusief 'teresa'
     * @throws Exception
     */
    public String getCommand() throws Exception {
        recognizer.startRecognition(true);
        SpeechResult result;
        System.out.println("ready");
        while ((result = recognizer.getResult()) != null) {
            System.out.format("Hypothesis: %s\n", result.getHypothesis());
            System.out.println(result.getResult().getBestResultNoFiller());
            if (result.getResult().getBestFinalResultNoFiller().contains("Teresa")){
                return result.getHypothesis();
            }
        }
        recognizer.stopRecognition();
        return result.getHypothesis();
    }
}
