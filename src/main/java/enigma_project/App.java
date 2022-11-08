package enigma_project;

import enigma_project.Enigma.Enigma;
import enigma_project.Wheel_Section.Wheel_type;

import javax.swing.*;
import java.util.Locale;

import static javax.swing.JOptionPane.DEFAULT_OPTION;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

/**
 * Application, which will use all other classes
 * @author flippi321
 * @version 1.0
 */
public class App {
    public static void main(String[] args) {
        Enigma enigma = new Enigma(Wheel_type.A, Wheel_type.A, Wheel_type.A);
        boolean done = false;
        boolean first = true;
        int choice;
        String[] choices = {"Encrypt Message", "Decrypt Message", "Drum Settings", "Add connection", "Quit"};

        while (!done) {
            // If it's the first time, we need to set the Drums
            if(first){
                choice = 2;
                first = false;
            } else {
                choice = JOptionPane.showOptionDialog(null, "What to you want to do?",
                        "Enigma Machine", DEFAULT_OPTION, INFORMATION_MESSAGE, null, choices, choices[0]);
            }

            switch (choice) {
                /*
                  Encrypt a message
                 */
                case 0 -> {
                    try {
                        String message = JOptionPane.showInputDialog(null, "Your Message:");
                        System.out.println("Input: " + message);
                        String encrypted = enigma.encrypt(message);
                        System.out.println("Output: " + encrypted);
                        JOptionPane.showMessageDialog(null, encrypted);
                    } catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }

                /*
                 * Decrypt a message
                 */
                case 1 -> {
                    try {
                        String message = JOptionPane.showInputDialog(null, "Your Message:");
                        System.out.println("Input: " + message);
                        String decrypted = enigma.decrypt(message);
                        System.out.println("Output: " + decrypted);
                        JOptionPane.showMessageDialog(null, decrypted);
                    } catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }

                /*
                 * Change the drum settings
                 */
                case 2 -> {
                    try{
                        int drum1 = JOptionPane.showOptionDialog(null, "Wheel 1 Type:",
                                "Settings", DEFAULT_OPTION, INFORMATION_MESSAGE, null, Wheel_type.values(), Wheel_type.A);
                        int drum2 = JOptionPane.showOptionDialog(null, "Wheel 2 Type:",
                                "Settings", DEFAULT_OPTION, INFORMATION_MESSAGE, null, Wheel_type.values(), Wheel_type.A);
                        int drum3 = JOptionPane.showOptionDialog(null, "Wheel 3 Type:",
                                "Settings", DEFAULT_OPTION, INFORMATION_MESSAGE, null, Wheel_type.values(), Wheel_type.A);
                        System.out.println("Drums set!");
                        enigma.setDrums(drum1, drum2, drum3);
                        int drum1Start = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Drum 1 start position:"));
                        int drum2Start = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Drum 2 start position:"));
                        int drum3Start = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Drum 3 start position:"));
                        enigma.setDrumPositions(drum1Start, drum2Start, drum3Start);
                        System.out.println("Drum positions: " + drum1Start + " + " + drum2Start + " + " + drum3Start);
                    } catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }

                /*
                 * Add connection
                 */
                case 3 -> {
                    try{
                        String input = JOptionPane.showInputDialog(null, "Letters (Seperated by a comma)");
                        String improvedInput = input.toLowerCase(Locale.ROOT);
                        String[] inputs = improvedInput.split(",");
                        if(inputs.length!=2){
                            throw new IllegalArgumentException("Need to have two characters seperated by a comma");
                        }
                        enigma.addConnection(inputs[0].trim().charAt(0), inputs[1].trim().charAt(0));
                        System.out.println("Connected " + inputs[0] + " with " + inputs[1]);
                    } catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }

                /*
                 * Quit
                 */
                default -> {
                    JOptionPane.showMessageDialog(null, "Have a nice day!");
                    done = true;
                }
            }
        }
    }
}