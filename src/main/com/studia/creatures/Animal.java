package main.com.studia.creatures;

import main.com.studia.devices.Saleable;
import java.util.Objects;

public abstract class Animal implements Saleable ,Feedable {
    private static final Double DEFAULT_ANIMAL_WEIGHT = 1.0;
    private static final Double DEFAULT_DOG_WEIGHT = 12.0;
    private static final Double DEFAULT_CAT_WEIGHT = 2.3;

    final String species;
    String name;
    private Double weight;
    Integer age;
    Boolean alive;

    public Animal(String species) {
        this.species = species; //wartosc z parametru
        this.alive = true; //wartosc domyslna
        if (this.species == "canis") {
            this.weight = DEFAULT_DOG_WEIGHT;
        } else if (this.species == "felis") {
            this.weight = DEFAULT_CAT_WEIGHT;
        } else {
            this.weight = DEFAULT_ANIMAL_WEIGHT;
        }
    }



    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void feed() {
        weight++;
        System.out.println("Moja waga to: " + weight);
    }

    public void feed(Double foodWeight) {
        weight += foodWeight;
        System.out.println("Moja waga to: " + weight);
    }

    Double getWeight() {
        return weight;
    }

    @Override
    public void sale() {
        System.out.println("Sprzedaj");
    }

    @Override
    public void getPrice() {

    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(this.equals(seller.animal)) {
            System.out.println("Sprzedajacy posiada to zwierze do sprzedania");
            if(buyer.cash >= price) {
                System.out.println("Kupujacy ma wystarczajaco gotówki");
                buyer.cash -= price;
                seller.cash += price;
                seller.animal = null;
                System.out.println(seller.firstName + " sprzedal " + this.species + "za cene " + price);
                buyer.animal = this;
                System.out.println(buyer.firstName + " kupil " + this.species + "za cene " + price);
                System.out.println("Transakcja zakonczona");
            }else{
                System.out.println("Kupujacy nie ma wystarczaco gotówki, transakcja niemożliwa");
            }
        }else {
            System.out.println("Sprzedajacy nie posiada tego zwierzecia");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(species, animal.species) && Objects.equals(name, animal.name) && Objects.equals(weight, animal.weight) && Objects.equals(age, animal.age) && Objects.equals(alive, animal.alive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, name, weight, age, alive);
    }
}
