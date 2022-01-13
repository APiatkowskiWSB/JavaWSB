package main.com.studia.devices;

import java.util.Comparator;

public class ApplicationValueComparator implements Comparator<Application> {

    @Override
    public int compare(Application o1, Application o2) {
        if (o1 == null && o2 == null || o1.price == o2.price) {
            return 0;
        } else if (o1 == null || o1.price < o2.price) {
            return -1;
        } else {
            return 1;
        }
    }
}
