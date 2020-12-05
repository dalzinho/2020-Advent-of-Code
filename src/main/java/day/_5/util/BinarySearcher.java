package day._5.util;

import java.util.List;

public class BinarySearcher {

    public int find(int max, List<Boolean> steps) {
        int nextMin = 0;
        int nextMax = max;

        for (int i = 0; i < steps.size() - 1; i++) {
            boolean step = steps.get(i);
            int midPoint = (nextMin + nextMax) / 2;

            if (step) {
                nextMin = midPoint + 1;
            } else {
                nextMax = midPoint;
            }
        }

        return steps.get(steps.size() - 1) ? nextMax : nextMin;
    }

}
