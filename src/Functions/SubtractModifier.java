package Functions;

import java.util.Map;

public class SubtractModifier implements Value {
    private Value _val1;
    private Value _val2;

    public SubtractModifier(Value val1, Value val2) {
        _val1 = val1;
        _val2 = val2;
    }


    @Override
    public long evaluate(Map<String, Long> values) {
        return _val1.evaluate(values) - _val2.evaluate(values);
    }

    @Override
    public long evaluate() {
        return _val1.evaluate() - _val2.evaluate();
    }
}
