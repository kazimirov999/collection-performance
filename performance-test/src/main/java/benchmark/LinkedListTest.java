package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 1)

public class LinkedListTest extends PerformanceTestList <LinkedList> {

    @Param({"100", "1000", "10000", "100000", "1000000"})
    public int size;

    @Setup(Level.Iteration)
    public void setupCollection (){
        middleIndex = size/2;
        data = new LinkedList<>(Arrays.asList(getTestData(size)));
        testData =  (TestData) data.get(middleIndex);
        System.out.println(data.size());
    }

}

