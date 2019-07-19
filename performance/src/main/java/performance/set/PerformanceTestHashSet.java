package performance.set;

import org.openjdk.jmh.annotations.*;
import performance.TestData;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
@State(Scope.Benchmark)
public class PerformanceTestHashSet extends PerformanceTestSet<HashSet> {
    @Param({"100", "1000", "1000000"})
    int size;

    @Setup(Level.Iteration)
    public void setUp() {
        middleIndex = size/2;
        data = new HashSet<>(Arrays.asList(getTestData(size)));
        testData = new TestData(size/2, "John_" + size/2);
    }

}