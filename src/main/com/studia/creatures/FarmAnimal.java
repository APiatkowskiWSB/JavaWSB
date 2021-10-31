package main.com.studia.creatures;

public class FarmAnimal extends Animal implements Edbile {

    public FarmAnimal(String species) {
        super(species);
    }

    @Override
    public void beEaten() {
        System.out.println("Moze byc zjedzony");
    }
}
