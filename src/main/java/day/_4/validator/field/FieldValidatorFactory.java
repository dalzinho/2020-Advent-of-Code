package day._4.validator.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldValidatorFactory {

    private FieldValidatorFactory() {}

    public static List<FieldValidator> getValidators() {
        List<FieldValidator> list = new ArrayList<>();

        list.add(new YearFieldValidator("byr", 1920, 2002));
        list.add(new YearFieldValidator("iyr", 2010, 2020));
        list.add(new YearFieldValidator("eyr", 2020, 2030));
        list.add(new HeightFieldValidator("hgt"));
        list.add(new RegexMatchingFieldValidator("hcl", "#[0-9a-z]{6}"));
        list.add(new ListMatchingFieldValidator("ecl", Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth")));
        list.add(new RegexMatchingFieldValidator("pid", "\\d{9}"));

        return list;
    }
}
