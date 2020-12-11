package day._07;

import util.Solution;

import java.util.List;
import java.util.Map;

public abstract class HandyHaversacksSolution implements Solution<String, Long> {

    /**
     *
     * pretty shamelessly ripped off from /u/debunked, see here:
     *
     * https://www.reddit.com/r/adventofcode/comments/k8a31f/2020_day_07_solutions/geywwmd
     */

    protected final BagBuilder bagBuilder;
    protected final String targetColour;

    public HandyHaversacksSolution(BagBuilder bagBuilder, String targetColour) {
        this.bagBuilder = bagBuilder;
        this.targetColour = targetColour;
    }

    @Override
    public Long solve(List<String> inputs) {
        final Map<String, Bag> bagMap = bagBuilder.buildBags(inputs);
        return calculateAnswerFromBag(bagMap);
    }

    protected abstract long calculateAnswerFromBag(Map<String, Bag> bagMap);
}
