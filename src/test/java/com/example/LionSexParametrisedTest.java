package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class LionSexParametrisedTest {

    @ParameterizedTest(name = "sex={0}, hasMane={1}")
    @CsvSource({"Самец, true", "Самка, false"})
    public void doesHaveManeMatchesSex(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, mock(FelineBehavior.class));

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @ParameterizedTest(name = "sex={0}")
    @NullSource
    @EmptySource
    @ValueSource(strings = {"Неизвестно", "самец", " Самка "})
    public void constructorRejectsInvalidSex(String sex) {
        FelineBehavior feline = mock(FelineBehavior.class);

        Exception exception = assertThrows(Exception.class, () -> new Lion(sex, feline));

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}
