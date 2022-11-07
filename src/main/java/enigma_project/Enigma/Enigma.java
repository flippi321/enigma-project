package enigma_project.Enigma;
import enigma_project.Wheel_Section.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        drum1 = new Drum(type1.toUpperCase(Locale.ROOT));
        drum2 = new Drum(type2.toUpperCase(Locale.ROOT));
        drum3 = new Drum(type3.toUpperCase(Locale.ROOT));
        reflector = new Reflector();
    }

    public String encrypt(String input){
        char[] messageList = input.toLowerCase(Locale.ROOT).toCharArray();
        StringBuilder output = new StringBuilder();
        for (char letter : messageList){
            // Encrypt Message
            char encrypted1 = drum3.leftEncrypt(drum2.leftEncrypt(drum1.leftEncrypt(letter)));
            // Reflect back
            char reflected =reflector.reflectLetter(encrypted1);
            // Encrypt Again
            char encrypted2 = drum3.rightEncrypt(drum2.rightEncrypt(drum1.rightEncrypt(letter)));
            // Add letter to output
            output.append(encrypted2);
            // Rotate Wheels
            drum3.tickUp(drum2.tickUp(drum1.tickUp(true)));
        }
        return output.toString();
    }

    public String decrypt(String input){
        char[] messageList = input.toLowerCase(Locale.ROOT).toCharArray();
        StringBuilder output = new StringBuilder();

        for(int i = 0; i <= messageList.length; i++){
            // Rotate Wheels
            drum3.tickDown(drum2.tickDown(drum1.tickDown(true)));
        }

        for (char letter : messageList){
            // Encrypt Message
            char encrypted1 = drum3.leftDecrypt(drum2.leftDecrypt(drum1.leftDecrypt(letter)));
            // Reflect back
            char reflected =reflector.reflectLetter(encrypted1);
            // Encrypt Again
            char encrypted2 = drum3.rightDecrypt(drum2.rightDecrypt(drum1.rightDecrypt(letter)));
            // Rotate Wheels
            drum3.tickUp(drum2.tickUp(drum1.tickUp(true)));
            // Add letter to output
            output.append(encrypted2);
        }
        return output.toString();
    }

    // Getters and setter
    public Drum getDrum1() {
        return drum1;
    }

    public void setDrum1(Drum drum1) {
        this.drum1 = drum1;
    }

    public Drum getDrum2() {
        return drum2;
    }

    public void setDrum2(Drum drum2) {
        this.drum2 = drum2;
    }

    public Drum getDrum3() {
        return drum3;
    }

    public void setDrum3(Drum drum3) {
        this.drum3 = drum3;
    }

    public Reflector getReflector() {
        return reflector;
    }

    public void setReflector(Reflector reflector) {
        this.reflector = reflector;
    }
}