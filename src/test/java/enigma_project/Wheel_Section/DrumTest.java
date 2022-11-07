package enigma_project.Wheel_Section;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@Nested
@DisplayName("Drum Test")
public class DrumTest {
    @Nested
    @DisplayName("Constructors")
    class Constructors{
        @Test
        @DisplayName("Check Drum with Setting A")
        public void checkDrumWithSettingA(){
            try{
                Drum drum = new Drum("A");
                ArrayList<Character> correctList = new ArrayList<>(Arrays.asList('!','.',',',' ','z','y','x','w', 'v',
                        'u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a'));
                assertEquals(correctList, drum.getWheel());
            } catch(IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }

        }

        @Test
        @DisplayName("Check Drum with Setting B")
        public void checkDrumWithSettingB(){
            try{
                Drum drum = new Drum("B");
                ArrayList<Character> correctList = new ArrayList<>(Arrays.asList('k','i','b','p','l','!','h','w','d',
                        'v','y','q','j',' ','m','s','u',',','x','z','f','t','.','g','e','r','o','c','a','n'));
                assertEquals(correctList, drum.getWheel());
            } catch(IllegalArgumentException e) {
                fail("checkDrumWithSettingB failed");
            }

        }

        @Test
        @DisplayName("Check Drum with Setting C")
        public void checkDrumWithSettingC(){
            try{
                Drum drum = new Drum("C");
                ArrayList<Character> correctList = new ArrayList<>(Arrays.asList('y','d','s','q','l',',', 'w','p','z',
                        'x','u', '.','k','b','h','c','e','m','v','a','n',' ','o','r','!','g','t','f','j','i'));
                assertEquals(correctList, drum.getWheel());
            } catch(IllegalArgumentException e) {
                fail("checkDrumWithSettingC failed");
            }

        }
    }

    @Nested
    @DisplayName("Error Handling")
    class ErrorHandling{
        @Test
        @DisplayName("Check Constructor Error Handling")
        public void checkConstructorErrorHandling(){
            try{
                Drum drum = new Drum("Z");
                fail("checkConstructorErrorHandling did not throw an exception when expected to");
            } catch(IllegalArgumentException e) {
                assertEquals("Wheel Setting must be Valid letter (A-C)", e.getMessage());
            }
        }

        @Test
        @DisplayName("Check That it's not possible to rotate negative times")
        public void checkNotPossibleToRotateNegativeTimes(){
            try{
                Drum drum = new Drum("A");
                drum.setDrumPosTo(-1);
                fail("checkNotPossibleToRotateNegativeTimes did not throw an exception when expected to");
            } catch(IllegalArgumentException e) {
                assertEquals("Has to rotate more than 0 times", e.getMessage());
            }
        }

        @Test
        @DisplayName("Check That it's not possible to rotate zero times")
        public void checkNotPossibleToRotateZeroTimes(){
            try{
                Drum drum = new Drum("A");
                drum.setDrumPosTo(0);
                fail("checkNotPossibleToRotateZeroTimes did not throw an exception when expected to");
            } catch(IllegalArgumentException e) {
                assertEquals("Has to rotate more than 0 times", e.getMessage());
            }
        }
    }

    @Nested
    @DisplayName("Methods")
    class Methods{
        @Test
        @DisplayName("Check that TickUp function works")
        public void checkThatTickUpFunctionWorks(){
            try{
                Drum drum = new Drum("A");
                drum.tickUp(true);
                ArrayList<Character> correctList = new ArrayList<>(Arrays.asList('a','!','.',',',' ','z','y','x','w',
                        'v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b'));
                assertEquals(correctList, drum.getWheel());
            } catch(IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }

        @Test
        @DisplayName("Check that TickDown function works")
        public void checkThatTickDownFunctionWorks(){
            try{
                Drum drum = new Drum("A");
                drum.tickDown(true);
                ArrayList<Character> correctList = new ArrayList<>(Arrays.asList('.',',',' ','z','y','x','w',
                        'v','u','t','s','r','q','p','o','n','m','l','k','j','i','h','g','f','e','d','c','b','a','!'));
                assertEquals(correctList, drum.getWheel());
            } catch(IllegalArgumentException e) {
                fail("checkDrumWithSettingA failed");
            }
        }
    }
}
