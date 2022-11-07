package enigma_project.Wheel_Section;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class representing an encryption reflector
 * This will make it so that the encryption wheels are used twice
 */
public class Reflector {
    ArrayList<Character> alphabet;

    public Reflector(){
        alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',' ', ',', '.', '!'));
    }

    /**
     * Method to return the "opposite" letter
     * This means the letter that has the same index from the end, as the original has from the beginning
     * @param in the letter
     * @return the opposite letter
     */
    public char reflectLetter(char in){
        int newPost = (alphabet.size()-1) - alphabet.indexOf(in);   // Calculate the opposite index
        return alphabet.get(newPost);                               // Return corresponding Character
    }
}
