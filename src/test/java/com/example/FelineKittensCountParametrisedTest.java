package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineKittensCountParametrisedTest {

    @ParameterizedTest(name = "kittensCount={0}")
    @ValueSource(ints = {0, 1, 2, 5})
    public void getKittensReturnsSpecifiedCount(int kittensCount) {
        assertEquals(kittensCount, new Feline().getKittens(kittensCount));
    }
}
