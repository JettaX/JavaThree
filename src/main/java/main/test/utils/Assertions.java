package main.test.utils;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Assertions {

    public static void assertEquals(Object actual, Object expected) {
        someWork();
        if (!actual.equals(expected)) {
            System.out.print("error");
            throw new AssertionError(
                    "Expected: ".concat(expected.toString())
                            .concat(", actual: ").concat(actual.toString()));
        }
        System.out.print("done");
    }

    @SneakyThrows
    private static void someWork() {
        System.out.print("doing test");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(100);
            System.out.print(".");
        }
    }
}
