package day._7;

import java.util.Map;

public class CountOptionsSolution extends HandyHaversacksSolution {
    public CountOptionsSolution(BagBuilder bagBuilder, String targetColour) {
        super(bagBuilder, targetColour);
    }

    @Override
    protected long calculateAnswerFromBag(Map<String, Bag> bagMap) {
        final Bag goldBag = bagMap.get(targetColour);
        return bagMap.values().stream().filter(b -> b.containsBag(goldBag)).count();
    }
}
