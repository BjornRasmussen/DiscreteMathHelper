package Functions;

import java.util.Map;

public class Constant implements Value {
    // Stores a constant value, but encapsulated into a Functions.Value.
    private long _value;

    public Constant(long value) {
        _value = value;
    }

    public long evaluate() {
        return _value;
    }

    public long evaluate(Map<String, Long> notUsed) {
        return evaluate();
    }
}
