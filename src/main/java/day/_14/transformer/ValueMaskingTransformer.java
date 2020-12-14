package day._14.transformer;

import day._14.input.DockingDataInput;
import day._14.input.MemoryInput;

import java.util.List;
import java.util.stream.Collectors;

public class ValueMaskingTransformer extends MemoryInputTransformer {

    @Override
    public List<MemoryInput> transformMemoryInputs(DockingDataInput dockingDataInput) {
        return dockingDataInput.getMemoryInputs().stream()
                .map(memoryInput -> {
                    final String thirtySixBit = convertDecimalTo36Bit(memoryInput.getValue());
                    final String maskedString = applyMask(dockingDataInput.getMask(), thirtySixBit);
                    memoryInput.setValue(convert36BitToDecimal(maskedString));
                    return memoryInput;
                })
                .collect(Collectors.toList());
    }

    private String applyMask(String mask, String input) {
        StringBuilder maskedInput = new StringBuilder();

        for (int i = 0; i < 36; i++) {
            if (mask.charAt(i) == 'X') {
                maskedInput.append(input.charAt(i));
            } else {
                maskedInput.append(mask.charAt(i));
            }
        }

        return maskedInput.toString();
    }
}
