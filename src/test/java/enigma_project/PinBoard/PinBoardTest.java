package enigma_project.PinBoard;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class PinBoardTest {
    @Nested
    @DisplayName("Connection Functions")
    class Functions {
        @Test
        @DisplayName("Can't use two equal characters")
        public void checkErrorHandlingOnConstructor() {
            try {
                PinBoard pinBoard = new PinBoard();
                pinBoard.addConnection('a', 'a');
                fail("didn't throw an Exception when expected to");
            } catch (IllegalArgumentException e) {
                assertEquals("The characters on the switchboard must be different", e.getMessage());
            }
        }

        @Test
        @DisplayName("Swaps two connected letters")
        public void checkSwapFunctionWithValues() {
            try {
                PinBoard pinBoard = new PinBoard();
                pinBoard.addConnection('a', 'b');
                assertEquals('b', pinBoard.swap('a'));
                assertEquals('a', pinBoard.swap('b'));
            } catch (IllegalArgumentException e) {
                fail("threw an Exception when not expected to");
            }
        }

        @Test
        @DisplayName("Does not swap if there aren't any connected letters")
        public void checkSwapFunctionWithNoValues() {
            try {
                PinBoard pinBoard = new PinBoard();
                pinBoard.addConnection('a', 'c');
                assertEquals('z', pinBoard.swap('z'));
                assertEquals('b', pinBoard.swap('b'));
            } catch (IllegalArgumentException e) {
                fail("threw an Exception when not expected to");
            }
        }

        @Test
        @DisplayName("Has Function Works")
        public void checkHasFunction() {
            try {
                PinBoard pinBoard = new PinBoard();
                pinBoard.addConnection('a', 'b');
                assertTrue(pinBoard.has('a', 'b'));
                assertTrue(pinBoard.has('b', 'a'));
                assertTrue(pinBoard.has('z', 'a'));
                assertTrue(pinBoard.has('b', 'z'));
                assertFalse(pinBoard.has('x', 'y'));
            } catch (IllegalArgumentException e) {
                fail("threw an Exception when not expected to");
            }
        }

        @Test
        @DisplayName("Cant add a connection with a letter already used")
        public void cantAddaConnectionWithAlreadyUsedLetters() {
            try {
                PinBoard pinBoard = new PinBoard();
                pinBoard.addConnection('a', 'b');
                pinBoard.addConnection('c', 'd');
                pinBoard.addConnection('e', 'a');
                fail("Did not throw an exception when expected to");
            } catch (IllegalArgumentException e) {
                assertEquals("One or both characters is already connected on the PinBoard", e.getMessage());
            }
        }

        @Test
        @DisplayName("Can add multiple connections")
        public void canAddMultipleConnections() {
            try {
                PinBoard pinBoard = new PinBoard();
                pinBoard.addConnection('a', 'b');
                pinBoard.addConnection('c', 'd');
                pinBoard.addConnection('e', 'f');
                assertEquals(3, pinBoard.getConnections().size());
            } catch (IllegalArgumentException e) {
                fail("Threw an exception when not expected to");
            }
        }
    }
}
