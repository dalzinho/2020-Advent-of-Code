package util;

import java.util.List;

public interface ResultProcessor<T, R> {

    R process(List<T> groupAnswers);
}
