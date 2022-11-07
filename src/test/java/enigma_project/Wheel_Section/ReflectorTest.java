package enigma_project.Wheel_Section;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReflectorTest {
    @Nested
    @DisplayName("ReflectLetter")
    class ReflectLetter {
        @Test
        @DisplayName("Check Input 'a'")
        public void checkWheelTypeA() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('z', reflector.reflectLetter('a'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }

        @Test
        @DisplayName("Check Input 'w'")
        public void checkWheelTypeW() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('d', reflector.reflectLetter('w'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }

        @Test
        @DisplayName("Check Input 'm'")
        public void checkWheelTypeM() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('n', reflector.reflectLetter('m'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }

        @Test
        @DisplayName("Check Input 'z'")
        public void checkWheelTypeZ() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('a', reflector.reflectLetter('z'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }
    }
}
