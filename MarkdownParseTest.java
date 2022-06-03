import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.io.IOException;
import static org.junit.Assert.*;       // imports Junit assert method
import org.junit.*;                    // imports Junit
import java.util.ArrayList; 


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

    // @Test
    // public void newFile2Test() throws IOException{
    //     String markdown = Files.readString(Path.of("test-file3.md"));
    //     assertEquals(List.of(), MarkdownParse.getLinks(markdown));
    // }

    @Test 
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);

        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> snippet1ExpectedLinks = new ArrayList<>();
        snippet1ExpectedLinks.add("url.com");
        snippet1ExpectedLinks.add("google.com");
        snippet1ExpectedLinks.add("google.com");
        snippet1ExpectedLinks.add("ucsd.edu");

        for (int i=0; i < links.size(); i++){
            System.out.println(snippet1ExpectedLinks.get(i));
            System.out.println(links.get(i));
            assertEquals(snippet1ExpectedLinks.get(i), links.get(i));
        }
    }

    @Test 
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);

        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> snippet2ExpectedLinks = new ArrayList<>();
        snippet2ExpectedLinks.add("a.com");
        snippet2ExpectedLinks.add("b.com");
        snippet2ExpectedLinks.add("a.com(())");
        snippet2ExpectedLinks.add("example .com");

        for (int i=0; i < links.size(); i++){
            System.out.println(snippet2ExpectedLinks.get(i));
            System.out.println(links.get(i));
            assertEquals(snippet2ExpectedLinks.get(i), links.get(i));
        }
    }

    @Test 
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);

        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> snippet3ExpectedLinks = new ArrayList<>();
        snippet3ExpectedLinks.add("https://www.twitter.com");
        snippet3ExpectedLinks.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        snippet3ExpectedLinks.add("https://www.github.com");
        snippet3ExpectedLinks.add("https://cse.ucsd.edu/");

        for (int i=0; i < links.size(); i++){
            assertEquals(snippet3ExpectedLinks.get(i), links.get(i));
        }
    }
}