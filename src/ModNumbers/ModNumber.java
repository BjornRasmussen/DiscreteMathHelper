package ModNumbers;

public class ModNumber {
    private long _value;
    private long _mod;

    public ModNumber(long value, long mod) {
        _value = value % mod;
        _mod = mod;
    }

    public long getMod() {
        return _mod;
    }

    public long getValue() {
        return _value;
    }

    public ModNumber add(ModNumber other) {
        validateModSame(other);
        return new ModNumber(getValue() + other.getValue(), getMod());
    }

    public ModNumber subtract(ModNumber other) {
        validateModSame(other);
        return new ModNumber(getValue() - other.getValue(), getMod());
    }

    public ModNumber multiply(ModNumber other) {
        validateModSame(other);
        return new ModNumber(getValue() * other.getValue(), getMod());
    }

    public ModNumber multiply(long other) {
        return new ModNumber(getValue() * other, getMod());
    }

    public ModNumber getInverse() {
        for (long i = 1; i < getMod(); i++) {
            if (multiply(i).equals(1l)) {
                return new ModNumber(i, getMod());
            }
        }
        // If this runs, no value was found.
        return null;
    }

    private void validateModSame(ModNumber other) {
        if (other.getMod() != getMod()) {
            throw new IllegalArgumentException("Mismatched mods");
        }
    }

    public boolean equals(ModNumber other) {
        return getMod() == other.getMod() && getValue() == other.getValue();
    }

    public boolean equals(long other) {
        return getValue() == other;
    }
}
