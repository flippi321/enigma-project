package enigma_project.PinBoard;

import enigma_project.Wheel_Section.Drum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionTest {
    @Nested
    @DisplayName("Constructors")
    class Constructors {
        @Test
        @DisplayName("Check Constructor")
        public void checkConstructor() {
            try {
                Connection connection = new Connection('a', 'b');
                assertEquals(connection.getA(), 'a');
                assertEquals(connection.getB(), 'b');
            } catch (IllegalArgumentException e) {
                fail("threw an Exception when not expected to");
            }
        }
    }
}
