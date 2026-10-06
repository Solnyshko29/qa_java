package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    private FelineBehavior felineBehavior;

    private Lion lion;

    @BeforeEach
    public void setUp() throws Exception {
        lion = new Lion("Самец", felineBehavior);
    }

    @Test
    public void getKittensReturnsCount() {
        when(felineBehavior.getKittens()).thenReturn(3);

        assertEquals(3, lion.getKittens());
        verify(felineBehavior).getKittens();
    }

    @Test
    public void getFoodRequestsPredatorFood() throws Exception {
        List<String> food = List.of("Животные");
        when(felineBehavior.getFood("Хищник")).thenReturn(food);

        assertEquals(food, lion.getFood());
        verify(felineBehavior).getFood("Хищник");
    }

    @Test
    public void getFoodWorksWithRealFeline() throws Exception {
        Lion realLion = new Lion("Самец", new Feline());

        assertEquals(List.of("Животные", "Птицы", "Рыба"), realLion.getFood());
    }

    @Test
    public void getKittensWorksWithRealFeline() throws Exception {
        Lion realLion = new Lion("Самка", new Feline());

        assertEquals(1, realLion.getKittens());
    }
}
