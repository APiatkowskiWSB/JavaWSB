package main.com.studia.devices;

import main.com.studia.creatures.Human;

public interface Saleable {
    void sale();

    void getPrice();

    void sell(Human seller, Human buyer, Double price);
}
