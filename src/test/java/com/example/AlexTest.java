package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlexTest {

    @Mock
    private FelineBehavior felineBehavior;

    private Alex alex;

    @BeforeEach
    public void setUp() throws Exception {
        alex = new Alex(felineBehavior);
    }

    @Test
    public void getFriendsReturnsMartyGloriaAndMelman() {
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void doesHaveManeIsTrueBecauseAlexIsMale() {
        assertTrue(alex.doesHaveMane());
    }

    @Test
    public void getFoodReturnsAnimalsForAlexAndBehavior() throws Exception {
        List<String> food = List.of("Животные");
        when(felineBehavior.getFood("Хищник")).thenReturn(food);

        assertEquals(food, alex.getFood());
        verify(felineBehavior).getFood("Хищник");
    }
}
