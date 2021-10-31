package main.com.studia;

public interface Saleable {
    void sale();
    void getPrice();
    void sell(Human seller, Human buyer, Double price);
}
