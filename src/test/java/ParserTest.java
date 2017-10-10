import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {

    @Test
    public void test_line1Reader(){
        Parser parser = new Parser();
        assertThat(parser.line1Reader(("   "))).contains("1", "4");
        assertThat(parser.line1Reader((" _ "))).contains("2", "3", "5", "6", "7", "8", "9");
        assertThat(parser.line1Reader((" a "))).contains("?");
    }

    @Test
    public void test_line2Reader(){
        Parser parser = new Parser();
        assertThat(parser.line2Reader((" _|"))).contains("2", "3");
        assertThat(parser.line2Reader(("  |"))).contains("1", "7");
        assertThat(parser.line2Reader(("|_ "))).contains("5", "6");
        assertThat(parser.line2Reader(("|_|"))).contains("4", "8", "9");
    }

    @Test
    public void test_line3Reader(){
        Parser parser = new Parser();
        assertThat(parser.line3Reader(("  |"))).contains("1", "4", "7");
        assertThat(parser.line3Reader(("|_ "))).contains("2");
        assertThat(parser.line3Reader((" _|"))).contains("3", "5", "9");
        assertThat(parser.line3Reader(("|_|"))).contains("6", "8");
    }

    @Test
    public void test_parseDigit(){
        Parser parser = new Parser();
        String[] input = {" _ ", "|_ ", " _|"};
        assertThat(parser.parseDigit(input)).isEqualTo("5");
    }

    @Test
    public void test_arrayIntersection() {
        Parser parser = new Parser();
        assertThat(parser.arrayIntersection(new String[]{"1","2","3"}, new String[]{"2","3","4"}, new String[]{"3","4","5"})).isEqualTo(new String[]{"3"});
    }
}