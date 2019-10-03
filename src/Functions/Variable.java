package Functions;

import java.util.Map;

public class Variable implements Value {
    private String _name;

    public Variable(String name, long value) {
        _name = name;
    }

    public long evaluate() {
        throw new RuntimeException("Can't evaluate on null input for VariableValue array.");
    }

    public long evaluate(Map<String, Long> values) {
        try {
            return values.get(_name);
        } catch (Exception e) {
            throw new RuntimeException("No variable found in values with name " + getName());
        }
    }

    public String getName() {
        return _name;
    }
}
