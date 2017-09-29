package support;

public final class ArrayHandler {
    private ArrayHandler() {}

    public static void reverseArray(int[] array) {
        if (array != null && array.length > 1) {
            int len = array.length;

            for (int i = 0; i <= (len - 1) / 2; i++) {
                swapIntegers(array, i, len - 1 - i);
            }
        }
    }

    public static void pushZerosToTheEnd(int[] array) {
        if (array != null && array.length > 1) {
            int len = array.length;

            for (int i = 0, j = 0; j < len; j++) {
                if (array[j] != 0) {
                    if (i < j) {
                        swapIntegers(array, i, j);
                    }
                    i++;
                }
            }
        }
    }

    private static void swapIntegers(int[] array, int i, int j) {
        if (checkSwapParameters(array, i, j)) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private static boolean checkSwapParameters(final int[] array, int i, int j) {
        if (array == null || array.length <= 1 || i == j) {
            return false;
        }

        int len = array.length - 1;

        if (i < 0 || j < 0 || i > len || j > len) {
            return false;
        }

        return true;
    }

    public static boolean compareArrays(final int[] a, final int[] b) {
        if (a == null || b == null) {
            return a == b;
        }

        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
