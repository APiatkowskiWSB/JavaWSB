package main.com.studia.devices;

import java.util.Comparator;

public class Application implements Comparable<Application>{

    public String applicationName;
    public double price;
    public String version;

    public Application(String applicationName, double price, String version) {
        this.applicationName = applicationName;
        this.price = price;
        this.version = version;
    }

    @Override
    public int compareTo(Application otherApplication) {
        return this.applicationName.compareTo(otherApplication.applicationName);
    }
}
