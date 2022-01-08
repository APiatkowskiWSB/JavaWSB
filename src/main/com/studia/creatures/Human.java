package main.com.studia.creatures;

import main.com.studia.devices.Car;
import main.com.studia.devices.Phone;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Human extends Animal {

    public final static String HUMAN_SPECIES = "homo sapiens";
    public String firstName;
    String lastName;
    Animal animal;
    private Car car;
    double salary;
    public Double cash;
    public Phone phone;
    private Map<LocalDateTime, Double> getSalaryHistory = new HashMap<>();

    public Human(String firstName) {
        super(HUMAN_SPECIES);
        this.firstName = firstName;
        this.cash = 0.0;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void checkIfHumanCanBuyCar(Car car) {
        if (salary > car.getValue()) {
            System.out.println("Udalo sie kupic samochod za gotowke");
            this.car = car;
        } else if (salary / 12 > car.getValue()) {
            System.out.println("Udalo sie kupic samochod na kredyt");
            this.car = car;
        } else {
            System.out.println("zapisz sie na studia i znajdz nowa robote albo idz po podwyzke");
        }
    }

    @Override
    public String toString() {
        return "Human{" +
                "animal=" + animal +
                ", car=" + car +
                ", salary=" + salary +
                '}';
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        System.out.println("Nie mozna kupowac ludzi");
    }
}
