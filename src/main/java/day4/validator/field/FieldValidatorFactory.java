package day4.validator.field;

import java.util.ArrayList;
import java.util.List;

public class FieldValidatorFactory {

    private FieldValidatorFactory() {}

    public static List<FieldValidator> getValidators() {
        List<FieldValidator> list = new ArrayList<>();

        list.add(new YearFieldValidator("byr", 1920, 2002));
        list.add(new YearFieldValidator("iyr", 2010, 2020));
        list.add(new YearFieldValidator("eyr", 2020, 2030));
        list.add(new HeightFieldValidator("hgt"));
        list.add(new HairColourFieldValidator("hcl"));
        list.add(new EyeColourFieldValidator("ecl"));
        list.add(new PassportIdFieldValidator("pid"));

        return list;
    }
}
