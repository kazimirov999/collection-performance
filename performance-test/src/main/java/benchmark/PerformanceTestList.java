package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.List;

@State(Scope.Benchmark)

public class PerformanceTestList <T extends List> {
    protected T data;
    public int middleIndex;
    protected TestData testData;

    public TestData[] getTestData (int lenght) {
        TestData[] testData = new TestData[lenght];
        for (int i = 0; i<lenght; i++){
            testData [i] =  new TestData("№ " + i, i);
        }
        return testData;
    }

    @Benchmark
    public void testAdd(){
        data.add(testData);
    }

    @Benchmark
    public void testAddAll(){
        data.addAll(data);
    }

    @Benchmark
    public void testGet(){
        data.get(middleIndex);
    }
    @Benchmark
    public void testClear(){
        data.clear();
    }
}
