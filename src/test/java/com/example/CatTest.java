package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    private Feline feline;

    private Cat cat;

    @BeforeEach
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getSoundReturnsMeow() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsMeatFromFeline() throws Exception {
        List<String> food = List.of("Рыба");
        when(feline.eatMeat()).thenReturn(food);

        assertEquals(food, cat.getFood());
        verify(feline).eatMeat();
    }
}
