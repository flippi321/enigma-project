package enigma_project.Wheel_Section;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Nested
@DisplayName("Reflector Test")
public class ReflectorTest {
    @Nested
    @DisplayName("ReflectLetter")
    class ReflectLetter {
        @Test
        @DisplayName("Check Input 'a'")
        public void checkWheelTypeA() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('!', reflector.reflectLetter('a'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }

        @Test
        @DisplayName("Check Input 'w'")
        public void checkWheelTypeW() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('h', reflector.reflectLetter('w'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }

        @Test
        @DisplayName("Check Input 'm'")
        public void checkWheelTypeM() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('r', reflector.reflectLetter('m'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }

        @Test
        @DisplayName("Check Input 'z'")
        public void checkWheelTypeZ() {
            try {
                Reflector reflector = new Reflector();
                assertEquals('a', reflector.reflectLetter('!'));
            } catch (IllegalArgumentException e) {
                fail("threw an exception where not expected to");
            }
        }
    }
}
