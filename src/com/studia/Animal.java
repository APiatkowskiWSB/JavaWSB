package com.studia;

public class Animal {
    private static final Double DEFAULT_ANIMAL_WEIGHT = 1.0;
    private static final Double DEFAULT_DOG_WEIGHT = 12.0;
    private static final Double DEFAULT_CAT_WEIGHT = 2.3;

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", alive=" + alive +
                '}';
    }

    final String species;
    String name;
    private Double weight;
    Integer age;
    Boolean alive;

    Animal(String species) {
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

    void feed() {
        weight++;
        System.out.println("Moja waga to: " + weight);
    }

    void feed(Double foodWeight) {
        weight += foodWeight;
        System.out.println("Moja waga to: " + weight);
    }

    Double getWeight() {
        return weight;
    }
}
