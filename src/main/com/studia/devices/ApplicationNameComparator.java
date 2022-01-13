package main.com.studia.devices;

import java.util.Comparator;

public class ApplicationNameComparator implements Comparator<Application> {

    @Override
    public int compare(Application o1, Application o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        } else {
            return o1.applicationName.compareTo(o2.applicationName);
        }
    }
}
