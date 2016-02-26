import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.modules.synthesis.Voice;
import marytts.util.data.audio.AudioPlayer;

import javax.sound.sampled.AudioInputStream;
import java.util.Set;

/**
 * @author Jari Van Melckebeke
 */
public class Output {

    public static void speak(String str) throws Exception {

        MaryInterface marytts = new LocalMaryInterface();
        System.out.println(Voice.getAvailableVoices());
        Set<String> voices = marytts.getAvailableVoices();
        System.out.println(voices.toString());
        System.out.println(marytts.getAvailableVoices());
        AudioInputStream audio = marytts.generateAudio(str);
        AudioPlayer player = new AudioPlayer(audio);
        player.start();
        player.join();
    }
}
