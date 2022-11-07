package enigma_project.Enigma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EnigmaTesting {
    @Nested
    @DisplayName("Constructors")
    class Constructors {
        @Test
        @DisplayName("Check Drum with Setting A")
        public void checkDrumWithSettingA() {
            try {
                String message = "dette er en test hei paa deg";
                Enigma enigma = new Enigma("A", "A", "A");
                String encrypted = enigma.encrypt(message);
                System.out.println(encrypted);
                assertEquals(message, enigma.decrypt(encrypted));
            } catch (IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }

        }
    }
}
