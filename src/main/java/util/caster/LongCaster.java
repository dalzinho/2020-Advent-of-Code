package util.caster;

public class LongCaster implements Caster<Long> {

    @Override
    public Long cast(String s) {
        return Long.parseLong(s);
    }
}
