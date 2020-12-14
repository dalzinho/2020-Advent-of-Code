package day._14.transformer;

import day._14.input.DockingDataInput;
import day._14.input.MemoryInput;

import java.util.*;
import java.util.stream.Collectors;

public class KeyMaskingTransformer extends MemoryInputTransformer {

    @Override
    public List<MemoryInput> transformMemoryInputs(DockingDataInput dockingDataInput) {
        List<MemoryInput> allInputs = new ArrayList<>();
        for (MemoryInput memoryInput : dockingDataInput.getMemoryInputs()) {
            final List<MemoryInput> memoryInputWithExplodedKeys = applyMask(dockingDataInput.getMask(), memoryInput.getAddress())
                    .stream()
                    .map(masked -> {
                        long decimalKey = convert36BitToDecimal(masked);
                        return new MemoryInput(decimalKey, memoryInput.getValue());
                    })
                    .collect(Collectors.toList());

            allInputs.addAll(memoryInputWithExplodedKeys);
        }
        return allInputs;
    }

    private List<String> applyMask(String mask, long address) {

        String addressBits = convertDecimalTo36Bit(address);

        StringBuilder maskedAddress = new StringBuilder();
        for (int i = 0; i < mask.length(); i++) {
            if (mask.charAt(i) == '0') {
                maskedAddress.append(addressBits.charAt(i));
            } else {
                maskedAddress.append(mask.charAt(i));
            }
        }

        List<String> keys = new ArrayList<>();

        Deque<String> deque = new ArrayDeque<>();
        deque.push(maskedAddress.toString());
        int index;

        while (!deque.isEmpty()) {
            String target = deque.pop();

            if ((index = target.indexOf('X')) != -1) {
                for (char c : Arrays.asList('0', '1')) {
                    final String next = buildNext(target, index, c);
                    deque.push(next);
                }
            } else {
                keys.add(target);
            }
        }
        return keys;
    }

    private String buildNext(String target, int index, char next) {
        return new StringBuilder(target.substring(0, index))
                .append(next)
                .append(target.substring(index + 1))
                .toString();
    }
}
