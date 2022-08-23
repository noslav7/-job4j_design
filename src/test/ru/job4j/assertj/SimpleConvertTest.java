package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleConvertTest {
    @Test
    void checkToArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "first", "second", "fifth");
        assertThat(list).first().isEqualTo("first")
                .isNotNull();
    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> stringSet = simpleConvert.toSet("first", "second", "third", "fourth", "fifth");
        assertThat(stringSet).filteredOnAssertions(e -> assertThat(e)
                .hasSizeLessThan(7)
                .contains("second")
                .doesNotContain("sixth"));
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("1", "1", "2", "2", "3", "3");
        assertThat(map).hasSize(3)
                .containsKeys("1", "3", "2")
                .containsValues(2, 4, 0)
                .doesNotContainKey("0")
                .doesNotContainValue(5)
                .containsEntry("2", 2);
    }
}