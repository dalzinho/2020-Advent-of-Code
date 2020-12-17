package day._16;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Getter
@ToString
public class TicketValueBounds {

    private final long low;
    private final long high;

    public TicketValueBounds(long low, long high) {
        this.low = low;
        this.high = high;
    }

    public List<Long> range() {
        return LongStream.rangeClosed(low, high).boxed().collect(Collectors.toList());
    }

}
