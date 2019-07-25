package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Set;

@State(Scope.Benchmark)

public class PerformanceTestSet<T extends Set> {

    protected T data;
    public int middleIndex;
    protected TestData testData;

    public TestData[] getTestData(int lenght) {

        TestData[] testData = new TestData[lenght];
        for (int i = 0; i < lenght; i++) {

            testData[i] = new TestData("№ " + i, i);
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