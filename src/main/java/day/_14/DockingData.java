package day._14;

import day._14.input.DockingDataInput;
import day._14.input.InputTranslator;
import day._14.transformer.MemoryInputTransformer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DockingData {

    private final InputTranslator inputTranslator;
    private final MemoryInputTransformer memoryInputTransformer;

    protected DockingData(InputTranslator inputTranslator, MemoryInputTransformer memoryInputTransformer) {
        this.inputTranslator = inputTranslator;
        this.memoryInputTransformer = memoryInputTransformer;
    }

    public long solve(List<String> inputs) {
        Map<Long, Long> memMap = new HashMap<>();

        final List<DockingDataInput> dockingDataInputs = inputTranslator.translateInputs(inputs);

        for (DockingDataInput dockingDataInput : dockingDataInputs) {
            memoryInputTransformer.transformMemoryInputs(dockingDataInput)
                    .forEach(memoryInput -> memMap.put(memoryInput.getAddress(), memoryInput.getValue()));
        }

        return memMap.values().stream().mapToLong(Long::longValue).sum();
    }
}
