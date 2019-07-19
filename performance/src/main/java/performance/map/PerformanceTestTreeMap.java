package performance.map;

import org.openjdk.jmh.annotations.*;
import performance.TestData;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
@State(Scope.Benchmark)
public class PerformanceTestTreeMap extends PerformanceTestMap<TreeMap> {

    @Param({"100", "1000", "1000000"})
    int size;


    @Setup(Level.Iteration)
    public void setUp() {
        middleIndex = size/2;
        data = new TreeMap<>();
        data = getTestData(size, data);
        testData = (TestData) data.get("John_"+(size/2));
        key = testData.getName();
    }

}