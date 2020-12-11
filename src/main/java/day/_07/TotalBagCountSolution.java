package day._07;

import java.util.Map;

public class TotalBagCountSolution extends HandyHaversacksSolution {
    public TotalBagCountSolution(BagBuilder bagBuilder, String targetColour) {
        super(bagBuilder, targetColour);
    }

    @Override
    protected long calculateAnswerFromBag(Map<String, Bag> bagMap) {
        final Bag bag = bagMap.get(targetColour);
        return bag.countContained();
    }
}
