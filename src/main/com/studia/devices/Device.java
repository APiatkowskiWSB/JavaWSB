package main.com.studia.devices;

public abstract class Device {
    final Integer yearOfPRoduction;
    final String producer;
    final String model;

    public Device(Integer yearOfPRoduction, String producer, String model) {
        this.yearOfPRoduction = yearOfPRoduction;
        this.producer = producer;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Device{" +
                "yearOfPRoduction=" + yearOfPRoduction +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    abstract public void turnOn();
}
