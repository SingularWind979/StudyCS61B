import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestWordUtils {
    @Test
    public void testLongestWithAList() {
        MyList<String> input = new AList<>();
        input.addFirst("hi");
        input.addLast("world");

        String excepted = "world";
        String actual = WordUtils.longest(input);

        assertThat(actual).isEqualTo(excepted);
    }

    @Test
    public void testLongestWithDLList() {
        MyList<String> words = new DLList<>();
        words.addFirst("hello");
        words.addLast("java");

        String excepted = "hello";
        String actual = WordUtils.longest(words);

        assertThat(actual).isEqualTo(excepted);
    }
}
