package Functions;

import java.util.Map;

public class AddModifier implements Modifier {
    Value[] _values;

    public AddModifier(Value[] values) {
        _values = values;
    }

    public AddModifier(Value val1, Value val2) {
        _values = new Value[2];
        _values[0] = val1;
        _values[1] = val2;
    }


    @Override
    public long evaluate(Map<String, Long> values) {
        long output = 0;
        for (Value v : _values) {
            output += v.evaluate(values);
        }
        return output;
    }

    @Override
    public long evaluate() {
        long output = 0;
        for (Value v : _values) {
            output += v.evaluate();
        }
        return output;
    }
}
