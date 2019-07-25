package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)

public class HashMapTest extends PerformanceTestMap <HashMap> {

    @Param({"100", "1000", "10000", "100000", "1000000"})
    public int size;

    @Setup(Level.Iteration)
    public void setupCollection (){
        middleIndex = size/2;
        data = new HashMap<>();
        data = getTestData(size, data);
        testData =  (TestData) data.get(middleIndex);
        key = testData.index;
    }

}