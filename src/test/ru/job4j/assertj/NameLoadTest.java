package ru.job4j.assertj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {


    @Test
    void whenEmptyThanIllegalStateException() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("collection contains no data");
    }

    @Test
    void whenNoEqualSymbolThanIllegalArgumentException() {
        NameLoad nameLoad = new NameLoad();
        String name = "someName";
        assertThatThrownBy(() -> nameLoad.validate(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain the symbol \"=\"", name));
    }

    @Test
    void whenStartsWithEqualSymbolThanIllegalArgumentException() {
        NameLoad nameLoad = new NameLoad();
        String name = "=anyName";
        assertThatThrownBy(() -> nameLoad.validate(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain a key", name));
    }

    @Test
    void whenEqualLastSymbolThanIllegalArgumentException() {
        NameLoad nameLoad = new NameLoad();
        String name = "anyName=";
        assertThatThrownBy(() -> nameLoad.validate(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain a value", name));
    }
}