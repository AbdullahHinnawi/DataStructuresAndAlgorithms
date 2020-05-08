package usingjcapi;

import java.util.Comparator;

public class BalanceComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        TrafficCard trafficCard1 = (TrafficCard) o1;
        TrafficCard trafficCard2 = (TrafficCard) o2;
        return (int) (trafficCard1.mBalance - trafficCard2.mBalance);
    }
}
