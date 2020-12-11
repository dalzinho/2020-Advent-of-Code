package day._10;

import java.util.*;
import java.util.stream.Collectors;

public class AdapterArray {
    public long solve(final List<Long> longs) {
        final List<Long> sorted = longs.stream().sorted().collect(Collectors.toList());

        Map<Long, Long> distanceMap = new HashMap<>();
        distanceMap.put(3L, 1L);

        long previous = 0;
        for (long joltage : sorted) {
            final long distance = joltage - previous;
            distanceMap.merge(distance, 1L, Long::sum);
            previous = joltage;
        }

        return distanceMap.get(1L) * distanceMap.get(3L);
    }

    // lifted off reddit
    public long solve2(final List<Long> longs) {
        longs.add(0L);
        final List<Long> sorted = longs.stream().sorted().collect(Collectors.toList());

        final long[] dp = new long[sorted.size()];
        Arrays.fill(dp, -1);
        return recursivePathFinder(sorted, 0, dp);
    }

    public static long recursivePathFinder(List<Long> sequence, int index, long[] dp) {
        if (index == sequence.size() - 1) {
            return 1;
        }

        if (dp[index] != -1) {
            return dp[index];
        } else {
            long count = 0;
            for (int i = index + 1; i <= Math.min(index + 3, sequence.size() - 1); i++) {
                if (sequence.get(index) + 3 >= sequence.get(i)) {
                    count += recursivePathFinder(sequence, i, dp);
                }
            }
            dp[index] = count;
            return count;
        }

    }

//    public long solve2(List<Long> inputs) {
//        inputs.add(0L);
//        Collections.sort(inputs);
//        Map<Long, List<Long>> targetWithChildren = new HashMap<>();
//
//        for (int i = inputs.size() - 1; i >= 0; i --) {
//            targetWithChildren.put(inputs.get(i), new ArrayList<>());
//            for (int j = 3; j > 0; j--) {
//                long candidateChild = inputs.get(i) - j;
//                if (inputs.contains(candidateChild)) {
//                    targetWithChildren.get(inputs.get(i)).add(candidateChild);
//                }
//            }
//        }
//
//        Map<Long, Long> pathsToGlory = new HashMap<>();
//        pathsToGlory.put(0L, 1L);
//
//        long total = -1;
//        for (int i = 1; i < inputs.size(); i++) {
//            total = 0;
//            for (long l : targetWithChildren.get(inputs.get(i))) {
//                total += pathsToGlory.get(l);
//            }
//            pathsToGlory.put(inputs.get(i), total);
//        }
//
//        return total;
//    }
}
