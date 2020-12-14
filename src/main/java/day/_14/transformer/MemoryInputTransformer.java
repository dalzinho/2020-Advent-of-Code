package day._14.transformer;

import day._14.input.DockingDataInput;
import day._14.input.MemoryInput;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public abstract class MemoryInputTransformer {

    public abstract List<MemoryInput> transformMemoryInputs(DockingDataInput memoryInputs);

    protected String convertDecimalTo36Bit(long decimal) {
        final String binaryString = Long.toBinaryString(decimal);
        return StringUtils.leftPad(binaryString, 36, "0");
    }

    protected long convert36BitToDecimal(String thirtySixBit) {
        return Long.parseLong(thirtySixBit, 2);
    }
}
