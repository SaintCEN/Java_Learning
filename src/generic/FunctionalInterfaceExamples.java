package generic;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.concurrent.Callable;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) throws Exception {
        builtInFunctionalInterfaces();
        customFunctionalInterface();
        methodReferences();
        lambdaExpressions();
    }

    // 1. 内置函数式接口示例
    public static void builtInFunctionalInterfaces() {
        // Predicate - 断言，接受一个参数返回boolean
        Predicate<String> isLong = s -> s.length() > 5;
        System.out.println("Is 'HelloWorld' long? " + isLong.test("HelloWorld"));

        // Function - 函数，接受一个参数返回一个结果
        Function<Integer, String> intToHex = i -> "0x" + Integer.toHexString(i);
        System.out.println("255 in hex: " + intToHex.apply(255)); // 0xff

        // Consumer - 消费者，接受一个参数无返回值
        Consumer<String> printWithStars = s -> System.out.println("*** " + s + " ***");
        printWithStars.accept("Important Message");

        // Supplier - 供应者，无参数返回一个值
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random number: " + randomSupplier.get());

        // UnaryOperator - 一元操作，接受一个参数返回同类型结果
        UnaryOperator<String> repeatTwice = s -> s + s;
        System.out.println("Repeat 'Hi': " + repeatTwice.apply("Hi")); // HiHi

        // BinaryOperator - 二元操作，接受两个同类型参数返回同类型结果
        BinaryOperator<Integer> max = Integer::max;
        System.out.println("Max of 3 and 5: " + max.apply(3, 5)); // 5
    }

    // 2. 自定义函数式接口示例
    public static void customFunctionalInterface() {
        // 使用自定义接口
        StringFormatter upperCaseFormatter = s -> s.toUpperCase();
        StringFormatter exclamationFormatter = s -> s + "!";

        // 组合格式化器
        StringFormatter combinedFormatter = upperCaseFormatter.andThen(exclamationFormatter);

        System.out.println("Formatted string: " + combinedFormatter.format("hello")); // HELLO!

        // 使用静态工厂方法
        StringFormatter reverseFormatter = StringFormatter.reverse();
        System.out.println("Reversed string: " + reverseFormatter.format("world")); // dlrow
    }

    // 3. 方法引用示例
    public static void methodReferences() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // 静态方法引用
        System.out.println("Printing names using static method reference:");
        names.forEach(System.out::println);

        // 实例方法引用
        String prefix = "Name: ";
        System.out.println("\nAdding prefix using instance method reference:");
        names.stream()
                .map(prefix::concat)
                .forEach(System.out::println);

        // 构造方法引用
        System.out.println("\nCreating new strings using constructor reference:");
        names.stream()
                .map(String::new)
                .forEach(System.out::println);
    }

    // 4. Lambda表达式示例
    public static void lambdaExpressions() throws Exception {
        // Runnable - 无参数无返回值
        Runnable greeting = () -> System.out.println("Hello from Runnable!");
        new Thread(greeting).start();

        // 等待线程完成
        Thread.sleep(100);

        // Callable - 无参数有返回值
        Callable<String> callable = () -> "Result from Callable at " + System.currentTimeMillis();
        System.out.println(callable.call());

        // 自定义函数式接口
        MathOperation addition = (a, b) -> a + b;
        MathOperation multiplication = (a, b) -> a * b;

        System.out.println("10 + 5 = " + operate(10, 5, addition)); // 15
        System.out.println("10 * 5 = " + operate(10, 5, multiplication)); // 50
    }

    // 辅助方法，用于演示自定义函数式接口
    private static int operate(int a, int b, MathOperation operation) {
        return operation.operate(a, b);
    }

    // 自定义函数式接口
    @FunctionalInterface
    interface StringFormatter {
        String format(String input);

        // 默认方法，用于组合格式化器
        default StringFormatter andThen(StringFormatter after) {
            return input -> after.format(this.format(input));
        }

        // 静态工厂方法
        static StringFormatter reverse() {
            return s -> new StringBuilder(s).reverse().toString();
        }
    }

    // 另一个自定义函数式接口
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
}