package enigma_project.Enigma;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EnigmaTesting {
    String message = "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit.";

    @Nested
    @DisplayName("Constructors")
    class Constructors {
        @Test
        @DisplayName("Check Drum with Setting A-A-A")
        public void checkDrumWithSettingAAA() {
            try {
                Enigma enigma = new Enigma("A", "A", "A");
                String encrypted = enigma.encrypt(message);
                assertEquals(message.toLowerCase(), enigma.decrypt(encrypted));
            } catch (IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }

        @Test
        @DisplayName("Check Drum with Setting B-B-B")
        public void checkDrumWithSettingBBB() {
            try {
                Enigma enigma = new Enigma("B", "B", "B");
                String encrypted = enigma.encrypt(message);
                assertEquals(message.toLowerCase(), enigma.decrypt(encrypted));
            } catch (IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }

        @Test
        @DisplayName("Check Drum with Setting C-C-C")
        public void checkDrumWithSettingCCC() {
            try {
                Enigma enigma = new Enigma("C", "C", "C");
                String encrypted = enigma.encrypt(message);
                assertEquals(message.toLowerCase(), enigma.decrypt(encrypted));
            } catch (IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }

        @Test
        @DisplayName("Check Drum with Setting A-B-C")
        public void checkDrumWithSettingABC() {
            try {
                Enigma enigma = new Enigma("A", "B", "C");
                String encrypted = enigma.encrypt(message);
                assertEquals(message.toLowerCase(), enigma.decrypt(encrypted));
            } catch (IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }

        @Test
        @DisplayName("Check Drum with Setting C-A-B")
        public void checkDrumWithSettingCAB() {
            try {
                Enigma enigma = new Enigma("C", "A", "B");
                String encrypted = enigma.encrypt(message);
                assertEquals(message.toLowerCase(), enigma.decrypt(encrypted));
            } catch (IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }

        @Test
        @DisplayName("Check Drum with Setting C-A-B and Pinboard")
        public void checkDrumWithSettingCAB2() {
            try {
                Enigma enigma = new Enigma("C", "A", "B");
                enigma.addConnection('a','b');
                enigma.addConnection('e','p');
                enigma.addConnection('r','z');
                enigma.addConnection('t', 'q');
                String encrypted = enigma.encrypt(message);
                assertEquals(message.toLowerCase(), enigma.decrypt(encrypted));
            } catch (IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }
    }
}
