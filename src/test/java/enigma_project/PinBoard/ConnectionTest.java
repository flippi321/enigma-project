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

    @Nested
    @DisplayName("Functions")
    class Functions {
        @Test
        @DisplayName("Can't use two equal characters")
        public void checkErrorHandlingOnConstructor() {
            try {
                Connection connection = new Connection('a', 'a');
                fail("didn't throw an Exception when expected to");
            } catch (IllegalArgumentException e) {
                assertEquals("The characters on the switchboard must be different", e.getMessage());
            }
        }

        @Test
        @DisplayName("Swap function")
        public void checkSwapFunction() {
            try {
                Connection connection = new Connection('a', 'b');
                assertEquals('b', connection.swap('a'));
                assertEquals('a', connection.swap('b'));
            } catch (IllegalArgumentException e) {
                fail("threw an Exception when not expected to");
            }
        }

        @Test
        @DisplayName("Has Function Works")
        public void checkHasFunction() {
            try {
                Connection connection = new Connection('a', 'b');
                assertTrue(connection.has('a', 'b'));
                assertTrue(connection.has('b', 'a'));
                assertTrue(connection.has('z', 'a'));
                assertTrue(connection.has('b', 'z'));
                assertFalse(connection.has('x', 'y'));
            } catch (IllegalArgumentException e) {
                fail("threw an Exception when not expected to");
            }
        }
    }
}
