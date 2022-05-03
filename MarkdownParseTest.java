import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;
import static org.junit.Assert.*;       // imports Junit assert method
import org.junit.*;                    // imports Junit

public class MarkdownParseTest {      // creates class for testing
    @Test                            // informs Junit that we will be testing
    public void addition() {        // Test case that will check for a specfic case (addition)
        assertEquals(2, 1 + 1);    // checks to see if the output matches the expected output

    }

    @Test
    public void links() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> results = MarkdownParse.getLinks(content);
        assertEquals(results, List.of("https://something.com", "some-thing.html"));

     }
}