package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)

public class HashSetTest extends PerformanceTestSet<HashSet> {

    @Param({"100", "1000", "10000", "100000", "1000000"})
    public int size;

    @Setup(Level.Iteration)
    public void setupCollection (){
        middleIndex = size/2;
        data = new HashSet (Arrays.asList(getTestData(size)));
        testData =  new TestData("№ " + middleIndex, middleIndex);
    }

}
