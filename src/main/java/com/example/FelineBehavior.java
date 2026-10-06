package com.example;

import java.util.List;

public interface FelineBehavior {

    List<String> getFood(String animalKind) throws Exception;

    int getKittens();
}
