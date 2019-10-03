package Functions;

import java.util.Map;

public interface Value {
    public long evaluate(Map<String, Long> values);
    public long evaluate();
}
