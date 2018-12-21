package edu.ceng;

import java.util.List;

/**
 * Created by Ahmeett on 20.12.2016.
 */
public class Route {
    public List<Integer> integers;

    public Route(List<Integer> integers) {
        this.integers = integers;
    }

    public int distance() {
        int count = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (i != integers.size() - 1){
                count += TurkishNetwork.distance[integers.get(i)][integers.get(i + 1)];
            }
            else count += TurkishNetwork.distance[integers.get(0)][integers.get(integers.size() - 1)];
        }
        return count;

    }

    @Override
    public String toString() {

        String result = distance() + "km:";
        for (int i = 0; i < integers.size(); i++) {
            result += TurkishNetwork.cities[integers.get(i)] + "->";
            if (i == integers.size() - 1) result += TurkishNetwork.cities[integers.get(0)];
        }
        return result;
    }
}
