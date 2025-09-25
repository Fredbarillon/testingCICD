
import org.app.WordGenerator;
import org.junit.jupiter.api.*;
import java.security.SecureRandom;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WordGeneratorTest {

    private List<String> testList() {
        return List.of("test1", "test2", "test3", "test4");
    }


    private SecureRandom testRandom(int value) {
        return new SecureRandom() {
            @Override public int nextInt(int size) {
                // On vérifie que la borne est bien la taille de la liste
                assertThat(size).isEqualTo(testList().size());
                return value;
            }
        };
    }

    @Test
    @Order(1)
    void getWord_shouldReturnWordAtIndex() {
        WordGenerator gen = new WordGenerator(testList(), testRandom(0));
        assertThat(gen.getWord(1)).isEqualTo("test1");
        assertThat(gen.getWord(2)).isEqualTo("test2");
    }

    @Test
    @Order(2)
    void getRandomWord_shouldReturnWordWithinRange() {
        WordGenerator generator = new WordGenerator(testList(), testRandom(4));
        assertThat(generator.getRandomWord()).isEqualTo("test1");
    }

}
