package benchmark;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.LinkedList;

public class BenchmarkMain {
    public static void main(String[] args) throws RunnerException {
        final Options options = new OptionsBuilder()
                .include(ArrayListTest.class.getSimpleName())
                .include(LinkedList.class.getSimpleName())
                .include(TreeMapTest.class.getSimpleName())
                .include(HashMapTest.class.getSimpleName())
                .include(LinkedHashMapTest.class.getSimpleName())
                .include(TreeSetTest.class.getSimpleName())
                .include(HashSetTest.class.getSimpleName())
                .include(LinkedHashSetTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();

    }
}