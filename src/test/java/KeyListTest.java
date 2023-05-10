import model.ListKeys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyListTest {
    ListKeys keys;

    @BeforeEach
    void setUp() {
        keys = new ListKeys();
    }

    @Test
    void getNewKey() {
        String key = keys.keyadd();
        System.out.println(key);
        assertEquals(10, key.length());
    }

    @Test
    void getAllKeys() {

    }

    @Test
    void setAllKeys() {
    }
}