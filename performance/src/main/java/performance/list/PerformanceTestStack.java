package performance.list;

import org.openjdk.jmh.annotations.*;
import performance.TestData;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 5)
@Warmup(iterations = 2)
@State(Scope.Benchmark)
public class PerformanceTestStack extends PerformanceTestList<Stack>{
    @Param({"100", "1000", "1000000"})
    int size;

    @Setup(Level.Iteration)
    public void setUp() {
        middleIndex = size/2;
        data = new Stack<>();
        TestData[] testData = getTestData(size);
        for(int i=0;i<size;i++){
            data.push(testData[i]);
        }
        this.testData = (TestData) data.get(middleIndex);
    }

}