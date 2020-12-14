package day._14.input;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DockingDataInput {

    private String mask;
    private List<MemoryInput> memoryInputs = new ArrayList<>();

    private void addValues(Integer key, Integer value) {
        memoryInputs.add(new MemoryInput(key, value));
    }

    public void addValues(String key, String value) {
        int k = Integer.parseInt(key);
        int v = Integer.parseInt(value);
        addValues(k, v);
    }
}
