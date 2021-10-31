package main.com.studia.devices;

import main.com.studia.Human;
import main.com.studia.Saleable;

public class Car extends Device implements Saleable {
    Double weight;
    Integer doors;
    Double value;

    public Car(String model, String producer, Integer yearOfProduction) {
        super(yearOfProduction, producer, model);
    }

    public Double getValue() {
        return value;
    }

    public int hashCode() {
        double result = 31 * 7 * model.hashCode() *
                producer.hashCode() *
                weight * doors * value;
        return (int) result;
    }
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if (o == null || o instanceof Car) {
            return false;
        }
        Car car = (Car) o;
        return model == car.model &&
                producer == car.producer &&
                weight == car.weight &&
                doors == car.doors &&
                car.value == car.value;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", weight=" + weight +
                ", doors=" + doors +
                ", value=" + value +
                '}';
    }

    public void turnOn(){
        System.out.println("Przekrecam kluczyk");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(this.equals(seller.car)) {
            System.out.println("Sprzedajacy posiada ten samochod do sprzedania");
            if(buyer.cash >= price) {
                System.out.println("Kupujacy ma wystarczajaco gotówki");
                buyer.cash -= price;
                seller.cash += price;
                seller.car = null;
                System.out.println(seller.firstName + " sprzedal telefon " + this.producer + " " + this.model);
                buyer.car = this;
                System.out.println(buyer.firstName + " kupil telefon " + this.producer + " " + this.model);
                System.out.println("Transakcja zakonczona");
            }else{
                System.out.println("Kupujacy nie ma wystarczaco gotówki, transakcja niemożliwa");
            }
        }else {
            System.out.println("Sprzedajacy nie posiada tego samochodu");
        }
    }

    @Override
    public void sale() {

    }

    @Override
    public void getPrice() {

    }
}
