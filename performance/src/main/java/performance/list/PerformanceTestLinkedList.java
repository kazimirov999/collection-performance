package performance.list;

import org.openjdk.jmh.annotations.*;
import performance.TestData;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
@State(Scope.Benchmark)
public class PerformanceTestLinkedList extends PerformanceTestList<LinkedList>{
    @Param({"100", "1000", "1000000"})
    int size;

    @Setup(Level.Iteration)
    public void setUp() {
        middleIndex = size/2;
        data = new LinkedList<>(Arrays.asList(getTestData(size)));
        testData = (TestData) data.get(middleIndex);
    }

}
