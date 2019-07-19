package performance.set;

import org.openjdk.jmh.annotations.Benchmark;
import performance.TestData;

import java.util.Set;

public abstract class PerformanceTestSet<T  extends Set> {

    protected T data;
    protected TestData testData;
    protected int middleIndex;

    public  TestData[] getTestData(int amount){

        TestData[] testData = new TestData[amount];

        for(int i = 0; i < amount; i++){
            testData[i] = new TestData( i, "John_" + i);
        }

        return testData;
    }

    @Benchmark
    public void testAdd(){
        data.add(testData);
    }

    @Benchmark
    public void testContains(){
        data.contains(testData);
    }

    @Benchmark
    public void testRemove(){
        data.remove(testData);
    }

}
