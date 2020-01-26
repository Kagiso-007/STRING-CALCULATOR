import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void add() {
        assertEquals(5,StringCalculator.add("2,3"));
        assertEquals(6,StringCalculator.add("//1\n214"));
        assertEquals(3,StringCalculator.add("1,1\n1"));
        assertThrows(IllegalArgumentException.class, ()-> StringCalculator.add("-1,-2,4"));
        assertEquals(3,StringCalculator.add("//;\n1000;1;2"));
        assertEquals(13,StringCalculator.add("//***\n10***1***2"));
        assertEquals(13,StringCalculator.add("//[***][%%%]\n1***9%%%3"));
    }
}