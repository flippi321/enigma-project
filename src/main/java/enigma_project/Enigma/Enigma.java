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
    String drum1_type;
    String drum2_type;
    String drum3_type;

    public Enigma(String drum1_type, String drum2_type, String drum3_type) {
        this.drum1_type = drum1_type.toUpperCase(Locale.ROOT);
        this.drum2_type = drum2_type.toUpperCase(Locale.ROOT);
        this.drum3_type = drum3_type.toUpperCase(Locale.ROOT);
        reflector = new Reflector();
        resetDrums();
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
            char encrypted2 = drum1.rightEncrypt(drum2.rightEncrypt(drum3.rightEncrypt(letter)));
            // Add letter to output
            output.append(encrypted2);
            // Rotate Wheels
            drum3.tickUp(drum2.tickUp(drum1.tickUp(true)));
        }
        resetDrums();
        return output.toString();
    }

    public String decrypt(String input){
        char[] messageList = input.toLowerCase(Locale.ROOT).toCharArray();
        StringBuilder output = new StringBuilder();

        for (char letter : messageList){
            // Encrypt Message
            char encrypted1 = drum1.leftDecrypt(drum2.leftDecrypt(drum3.leftDecrypt(letter)));
            // Reflect back
            char reflected =reflector.reflectLetter(encrypted1);
            // Encrypt Again
            char encrypted2 = drum3.rightDecrypt(drum2.rightDecrypt(drum1.rightDecrypt(letter)));
            // Add letter to output
            output.append(encrypted2);
            // Rotate Wheels
            drum3.tickUp(drum2.tickUp(drum1.tickUp(true)));
        }
        resetDrums();
        return output.toString();
    }

    private void resetDrums(){
        drum1 = new Drum(drum1_type.toUpperCase(Locale.ROOT));
        drum2 = new Drum(drum2_type.toUpperCase(Locale.ROOT));
        drum3 = new Drum(drum3_type.toUpperCase(Locale.ROOT));
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