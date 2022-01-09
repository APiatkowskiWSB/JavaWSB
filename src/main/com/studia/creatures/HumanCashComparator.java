package main.com.studia.creatures;

import java.util.Comparator;

public class HumanCashComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        } else {
            return o1.compareTo(o2);
        }
    }
}
