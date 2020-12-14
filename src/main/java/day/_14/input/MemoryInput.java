package day._14.input;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
public class MemoryInput {
    private long address;
    private long value;

    public MemoryInput(long address, long value) {
        this.address = address;
        this.value = value;
    }
}
