package enigma_project.Wheel_Section;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Wheel_type_Test {
    @Nested
    @DisplayName("GetName commands")
    class GetNameCommands {
        @Test
        @DisplayName("Check Drum with Setting A")
        public void checkWheelTypeA() {
            try {
                Wheel_type type = Wheel_type.A;
                assertEquals("A", type.name());
            } catch (IllegalArgumentException e) {
                fail("checkWheelTypeA");
            }
        }

        @Test
        @DisplayName("Check Drum with Setting B")
        public void checkWheelTypeB() {
            try {
                Wheel_type type = Wheel_type.B;
                assertEquals("B", type.name());
            } catch (IllegalArgumentException e) {
                fail("checkWheelTypeB");
            }
        }

        @Test
        @DisplayName("Check Drum with Setting C")
        public void checkWheelTypeC() {
            try {
                Wheel_type type = Wheel_type.C;
                assertEquals("C", type.name());
            } catch (IllegalArgumentException e) {
                fail("checkWheelTypeC");
            }
        }
    }
}
