package enigma_project.Enigma;
import enigma_project.Wheel_Section.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Enigma machine class
 * @author flippi321
 */
public class Enigma {
    Drum drum1;
    Drum drum2;
    Drum drum3;
    Reflector reflector;

    public Enigma(String type1, String type2, String type3) {
        drum1 = new Drum(type1);
        drum2 = new Drum(type2);
        drum3 = new Drum(type3);
    }

    public String encrypt(String input){
        char[] messageList = input.toCharArray();
        StringBuilder output = new StringBuilder();
        for (char letter : messageList){
            // Encrypt Message
            char encrypted1 = drum3.leftEncrypt(drum2.leftEncrypt(drum1.leftEncrypt(letter)));
            // Reflect back
            char reflected =reflector.reflectLetter(encrypted1);
            // Encrypt Again
            char encrypted2 = drum3.rightEncrypt(drum2.rightEncrypt(drum1.rightEncrypt(letter)));
            // Rotate Wheels
            drum3.tickUp(drum2.tickUp(drum1.tickUp(true)));
            // Add letter to output
            output.append(encrypted2);
        }
        return output.toString();
    }
}