package internal.api.backend.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NameUtilsTest {

    @Test
    void nameSizeTest(){
        assertEquals(10, NameUtils.generateNames(10).size());
        assertEquals(20, NameUtils.generateNames(20).size());
        assertEquals(30, NameUtils.generateNames(30).size());
    }

    @Test
    void noRepeatNames(){
        List<String> names = NameUtils.generateNames(10);
        assertEquals(names.size(), new HashSet<>(names).size());
    }
}