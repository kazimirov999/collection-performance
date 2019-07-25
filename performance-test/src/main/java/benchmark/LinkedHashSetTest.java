package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)

public class LinkedHashSetTest extends PerformanceTestSet<LinkedHashSet> {

    @Param({"100", "1000", "10000", "100000", "1000000"})
    public int size;

    @Setup(Level.Iteration)
    public void setupCollection (){
        middleIndex = size/2;
        data = new LinkedHashSet (Arrays.asList(getTestData(size)));
        testData =  new TestData("№ " + middleIndex, middleIndex);
    }

}