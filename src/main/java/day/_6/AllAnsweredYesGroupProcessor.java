package day._6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnsweredYesGroupProcessor implements GroupProcessor {

    public long process(List<String> answers) {
        Map<String, Integer> wordCount = new HashMap<>();

        answers.forEach(answer -> {
            final String[] split = answer.split("");
            for (String s : split) {
                wordCount.merge(s, 1, Integer::sum);
            }
        });

        return wordCount.entrySet().stream()
                .filter(entry -> entry.getValue() == answers.size())
                .count();
    }
}
