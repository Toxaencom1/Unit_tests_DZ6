import com.taxah.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestApp {

    @Test
    void TestWholeApp() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        String[] args = {""};

        Main.main(args);

        String capturedOutput = outputStreamCaptor.toString().trim();
        System.setOut(System.out);

        assertEquals("Первый список имеет большее среднее значение", capturedOutput);
    }
}
