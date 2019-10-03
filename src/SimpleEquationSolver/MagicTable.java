package SimpleEquationSolver;

import java.util.ArrayList;
import java.util.List;

// This class takes in an A and B.
// These represent the values found in
// some equation like AX + BY = D
public class MagicTable {
    private long[][] _table; // An array of columns arrays.
    private long finalX;
    private long finalY;
    private long finalRemainder;

    public MagicTable(long A, long B) {
        _table = new long[4][1000]; // Hacky, should be rewritten.
        _table[2][0] = A;
        _table[2][1] = B;
        _table[0][0] = 1l;
        _table[0][1] = 0l;
        _table[1][0] = 0l;
        _table[1][1] = 1l;
        completeTable();
        finalX = _table[0][_table[0].length-1];
        finalY = _table[1][_table[0].length-1];
        finalRemainder = _table[2][_table[0].length-1];
    }

    public long getFinalRemainder() {
        return finalRemainder;
    }

    public long getFinalX() {
        return finalX;
    }

    public long getFinalY() {
        return finalY;
    }

    public long getIniitialA() {
        return _table[2][0];
    }

    public long getIniitialB() {
        return _table[2][1];
    }

    private void completeTable() {
        // Start by filling in the columns 2 and 3.
        int counter = 1;
        while(_table[2][counter-1] % _table[2][counter] != 0) {
            // First off, if the array is running short
            // (trying to enter at position counter+1 will fail)
            // extend it.
            if (counter >= _table[0].length) {
                _table = extend(_table, 100);
            }

            // _table[3][counter] needs to be set to _table[2][counter-1] / _table[2][counter], but rounded down.
            _table[3][counter] = _table[2][counter-1] / _table[2][counter]; // Rounds down automatically.

            // _table[2][counter+1] needs to be set to _table[2][counter-1] % _table[2][counter]
            _table[2][counter+1] = _table[2][counter-1] % _table[2][counter];


            // If _table[2][counter+1] is now equal to 1, quit and make the array stop at that number.
            if (_table[2][counter+1] == 1) {
                _table = extend(_table, -(_table[0].length - counter - 2));
                break;
            }
            counter++;
        }

        // Now, fill in columns 0 and 1.
        for (int i = 2; i < _table[0].length; i++) {
            // Start with 0:
            // _table[0][i] should be set to _table[0][i-2] - (_table[0][i-1] * table[3][i-1].
            _table[0][i] = _table[0][i-2] - (_table[0][i-1] * _table[3][i-1]);

            // _table[1][i] should be set to _table[1][i-2] - (_table[1][i-1] * table[3][i-1].
            _table[1][i] = _table[1][i-2] - (_table[1][i-1] * _table[3][i-1]);

        }
    }

    private static long[][] extend(long[][] table, int amount) {
        // Makes a copy of table, but with `amount` more rows.
        long[][] output = new long[4][table[0].length + amount];

        int smallestLength = table[0].length;
        if (table[0].length > output[0].length) {
            smallestLength = output[0].length;
        }
        for(int i = 0; i < table.length; i++) {
            for (int j = 0; j < smallestLength; j++) {
                output[i][j] = table[i][j];
            }
        }
        return output;
    }

    public long[][] getTable() {
        return _table;
    }
}
