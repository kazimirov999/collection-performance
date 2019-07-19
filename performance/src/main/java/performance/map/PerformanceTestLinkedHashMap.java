package performance.map;

import org.openjdk.jmh.annotations.*;
import performance.TestData;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
@State(Scope.Benchmark)
public class PerformanceTestLinkedHashMap extends PerformanceTestMap<LinkedHashMap> {

    @Param({"100", "1000", "1000000"})
    int size;


    @Setup(Level.Iteration)
    public void setUp() {
        middleIndex = size/2;
        data = new LinkedHashMap();
        data = getTestData(size, data);
        testData = (TestData) data.get("John_"+(size/2));
        key = testData.getName();
    }

}
