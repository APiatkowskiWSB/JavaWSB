package com.studia;


import com.studia.devices.Car;

public class Main {

    public static void main(String[] args) {
        Integer x = 149;
        Car car =new Car("S3","Audi");
//        car.model ="S3";
//        car.producer="Audi";
        car.setWeight(1745.0);
        car.setDoors(4);

        System.out.println(car.getWeight());
        System.out.println(car.getProducer());
        System.out.println(car.getWeight());
        System.out.println(car.getDoors());
        car.turnOn();

        Animal dog = new Animal("canis");
        dog.name = "Yogi";
//        dog.weight = 13.6;
        dog.age = 4;
        dog.alive = true;

        System.out.println(dog.name);
        System.out.println(dog.species);

        Double weightBeforeBreakfast=dog.getWeight();

        dog.feed();
        dog.feed();
        dog.feed();

        dog.feed(0.5);

        System.out.println("Przytylem "+(dog.getWeight()-weightBeforeBreakfast)+"kg");

        Animal cat = new Animal("felis");
        dog.name = "Gwiazdka";

        Human human = new Human();
        human.animal = cat;

        System.out.println(human.toString());
        System.out.println(car.toString());
        System.out.println(dog.toString());


    }
}
