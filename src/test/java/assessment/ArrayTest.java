package assessment;

import org.junit.Assert;
import org.junit.Test;
import support.ArrayHandler;

public class ArrayTest {
    @Test
    public void testReverseArray() {
        int[][] inputs = {
                {1, 2, 3, 4},
                null,
                {},
                {5},
                {2, 13, 36, 12, 0}
        };

        int[][] expects = {
                {4, 3, 2, 1},
                null,
                {},
                {5},
                {0, 12, 36, 13, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            ArrayHandler.reverseArray(inputs[i]);
            Assert.assertTrue(ArrayHandler.compareArrays(expects[i], inputs[i]));
        }
    }

    @Test
    public void testPushZerosToTheEnd() {
        int[][] inputs = {
                {1},
                null,
                {},
                {0},
                {0, 13, 36, 12, 0},
                {0, 0, 0},
                {1, 0},
                {0, 1},
                {3, 2}
        };

        int[][] expects = {
                {1},
                null,
                {},
                {0},
                {13, 36, 12, 0, 0},
                {0, 0, 0},
                {1, 0},
                {1, 0},
                {3, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            ArrayHandler.pushZerosToTheEnd(inputs[i]);
            Assert.assertTrue(ArrayHandler.compareArrays(expects[i], inputs[i]));
        }
    }
}
