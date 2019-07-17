import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void coded123456789_should_display_123456789()
    {
        ArrayList<String> encodedMessage = new ArrayList<String>();
        encodedMessage.add("    _  _     _  _  _  _  _ ");
        encodedMessage.add(" |  _| _||_||_ |_   ||_||_|");
        encodedMessage.add(" | |_  _|  | _||_|  ||_| _|");
        encodedMessage.add("                           ");

        Parser numberParser = new Parser(encodedMessage);
        numberParser.parse();
        assertEquals("123456789\n", outContent.toString());
    }

    @Test
    void coded173456789_should_display_123456789ERR()
    {
        ArrayList<String> encodedMessage = new ArrayList<String>();
        encodedMessage.add("    _  _     _  _  _  _  _ ");
        encodedMessage.add(" |   | _||_||_ |_   ||_||_|");
        encodedMessage.add(" |   | _|  | _||_|  ||_| _|");
        encodedMessage.add("                           ");

        Parser numberParser = new Parser(encodedMessage);
        numberParser.parse();
        assertEquals("173456789 ERR\n", outContent.toString());
    }

    @Test
    void coded17345678ill_should_display_12345678QMILL()
    {
        ArrayList<String> encodedMessage = new ArrayList<String>();
        encodedMessage.add("    _  _     _  _  _  _    ");
        encodedMessage.add(" |   | _||_||_ |_   ||_||_|");
        encodedMessage.add(" |   | _|  | _||_|  ||_| _|");
        encodedMessage.add("                           ");

        Parser numberParser = new Parser(encodedMessage);
        numberParser.parse();
        assertEquals("17345678? ILL\n", outContent.toString());
    }

    @AfterEach
    void restoreStreams()
    {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
