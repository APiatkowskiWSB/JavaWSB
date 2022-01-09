package main.com.studia.creatures;

import main.com.studia.devices.Car;
import main.com.studia.devices.Phone;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Human extends Animal implements Comparable<Human>{

    public final static String HUMAN_SPECIES = "homo sapiens";
    public final static int DEFAULT_GARAGE_SIZE = 5;
    public String firstName;
    String lastName;
    Animal animal;
    public Car[] garage;
    double salary;
    public Double cash;
    public Phone phone;
    private Map<LocalDateTime, Double> getSalaryHistory = new HashMap<>();

    public Human(String firstName) {
        super(HUMAN_SPECIES);
        this.firstName = firstName;
        this.cash = 0.0;
        this.garage = new Car[DEFAULT_GARAGE_SIZE];
    }

    public Human(String firstname, int garageSize) {
        super(HUMAN_SPECIES);
        this.firstName = firstname;
        garage = new Car[garageSize];
    }

    public void getSalary() {
        if (getSalaryHistory.size() == 0) {
            System.out.println("Dane o wypłacie nidy nie były pobierane");
        } else {
            getSalaryHistory.entrySet().stream()
                    .forEach(x -> System.out.println("Dane byly pobierane dnia " + x.getKey() + " a wyplata wtedy wynosila " + x.getValue()));
        }
        System.out.println("Aktualna wypłata wynosi: " + salary);
        getSalaryHistory.put(LocalDateTime.now(), salary);
    }

    public void setSalary(Double salary) {
        if (salary < 0) {
            System.out.println("Salary nie moze byc mniejsze niz 0");
        } else {
            System.out.println("Dane zostaly wyslane do systemu ksiegowego");
            System.out.println("Koniecznie odbierz aneks do umowy u pani Hani z kadr");
            System.out.println("ZUS i US juz wiedza o zmianie wyplaty i nie ma sensu ukrywac dochodu");
            this.salary = salary;
        }
    }

    public Car getCar(int index) {
        return garage[index];
    }

    public void setCar(Car car, int index) {
        if (index >= garage.length){
            System.out.println("Nie ma takiego miejsca w garazu");
            return;
        }
        if (garage[index] != null)
        this.garage[index] = car;
        else System.out.println("To miejsce w garazu jest zajete, wybierz inne miejsce");
    }

    public void checkIfHumanCanBuyCar(Car car) {
        if (salary > car.getValue()) {
            System.out.println("Udalo sie kupic samochod za gotowke");
            int i = 0;
            while(garage[i] == null){
                this.garage[i] = car;
            }
        } else if (salary / 12 > car.getValue()) {
            if (addCarToGarage(car)) {
                System.out.println("Nie kupisz auta bo nie masz miejsca w garazu");
                return;
            }
            System.out.println("Udalo sie kupic samochod na kredyt");
        } else {
            System.out.println("zapisz sie na studia i znajdz nowa robote albo idz po podwyzke");
        }
    }

    public void getCarsValue() {
        int carsValue = 0;
        for(int i = 0; i< garage.length; i++) {
            if(garage[i]!=null) {
                carsValue += garage[i].getValue();
            }
        }
        System.out.println(this.firstName + " posiada samochody o wartosci " + carsValue);
    }

    public boolean addCarToGarage(Car car) {
        for (int i = 0; i <garage.length; i++) {
            if (garage[i]  == null) {
                garage[i] = car;
                return true;
            }
        }
        System.out.println("nie ma miejsca w garazu");
        return false;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        System.out.println("Nie mozna kupowac ludzi");
    }

    public boolean hasCar(Car newCar) {
        for (Car car: garage) {
            if(car != null && car.equals(newCar)){
                return true;
            }
        }
        return false;
    }

    public boolean hasFreeParkingSlot() {
        for (int i =0; i<garage.length; i++) {
            if (garage[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void removeCar(Car carToRemove) {
        for (int i = 0 ; i< garage.length ; i++) {
            if(garage[i].equals(carToRemove)){
                garage[i] = null;
                return;
            }
        }
    }

    @Override
    public int compareTo(Human otherHuman) {
        return this.cash.compareTo(otherHuman.cash);
    }
}
