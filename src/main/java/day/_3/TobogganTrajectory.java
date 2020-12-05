package day._3;

import java.util.List;
import java.util.stream.Collectors;

public class TobogganTrajectory {

    public long process(List<String> map, List<List<Integer>> slopes) {
        return slopes.stream()
                .map(l -> countTrees(map, l.get(0), l.get(1)))
                .reduce((a, b) -> a * b)
                .orElse(0L);
    }


    private long countTrees(final List<String> map, int slopeX, int slopeY) {
        final List<String> interestingRows = map.stream()
                .filter(list -> map.indexOf(list) % slopeY == 0)
                .collect(Collectors.toList());

        int xCount = 0;
        int treeCount = 0;

        for (String row : interestingRows) {
            if (row.charAt(xCount) == '#') {
                treeCount++;
            }
            xCount += slopeX;

            if (xCount > row.length() - 1) {
                xCount = xCount - row.length();
            }
        }
        return treeCount;
    }


}
