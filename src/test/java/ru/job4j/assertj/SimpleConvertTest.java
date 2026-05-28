package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).isNotNull()
                .isNotEmpty()
                .hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).isNotNull()
                .isNotEmpty()
                .hasSize(5)
                .contains("second", "five")
                .containsAnyOf("zero", "five", "six")
                .doesNotContain("zero", "six");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set set = simpleConvert.toSet("first", "second", "three", "four", "four", "five", "five");
        assertThat(set).isNotNull()
                .isNotEmpty()
                .hasSize(5)
                .contains("second", "five")
                .containsOnly("first", "second", "three", "four", "five")
                .containsAnyOf("zero", "five", "six")
                .containsExactlyInAnyOrder("first", "second", "three", "four", "five")
                .doesNotContain("zero", "six");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("zero", "first", "second", "three");
        assertThat(map).isNotNull()
                .isNotEmpty()
                .hasSize(4)
                .containsKeys("first", "second")
                .containsValues(1, 2)
                .doesNotContainKey("six")
                .doesNotContainValue(4)
                .containsEntry("zero", 0);
    }
}