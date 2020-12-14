package day._14;

import day._14.input.DockingDataInput;
import day._14.input.InputTranslator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InputTranslatorTest extends DockingDataTest {

    private InputTranslator inputTranslator;

    @Before
    public void setUp() throws Exception {
        inputTranslator = new InputTranslator();
    }

    @Test
    public void test() {
        final List<DockingDataInput> dockingDataInputs = inputTranslator.translateInputs(testInputs);
        System.out.println(dockingDataInputs);
        assertEquals(1, dockingDataInputs.size());
    }
}