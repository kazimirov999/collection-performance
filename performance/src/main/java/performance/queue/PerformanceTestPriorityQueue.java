package performance.queue;

import org.openjdk.jmh.annotations.*;
import performance.TestData;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
@State(Scope.Thread)
public class PerformanceTestPriorityQueue extends PerformanceTestQueue<PriorityQueue> {
    @Param({"100", "1000", "1000000"})
    int size;


    @Setup(Level.Iteration)
    public void setUp() {
        middleIndex = size/2;
        data = new PriorityQueue<>(Arrays.asList(getTestData(size)));
        testData = new TestData(middleIndex, "John_" + middleIndex);

    }

}
