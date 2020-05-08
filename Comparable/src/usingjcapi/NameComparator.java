package usingjcapi;

import java.util.Comparator;

public class NameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        TrafficCard trafficCard1 = (TrafficCard) o1;
        TrafficCard trafficCard2 = (TrafficCard) o2;
        return trafficCard1.mOwnerName.compareTo(trafficCard2.mOwnerName);
    }
}
