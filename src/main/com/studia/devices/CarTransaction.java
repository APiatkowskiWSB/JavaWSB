package main.com.studia.devices;

import main.com.studia.creatures.Human;

import java.time.LocalDateTime;

public class CarTransaction {

    private final Human buyer;
    private final Human seller;
    private final Double price;
    private final LocalDateTime date;

    public CarTransaction(Human buyer, Human seller, Double price) {
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.date = LocalDateTime.now();
    }

    public Human getBuyer() {
        return buyer;
    }

    public Human getSeller() {
        return seller;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "CarTransaction{" +
                "buyer=" + buyer.firstName +
                ", seller=" + seller.firstName +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
