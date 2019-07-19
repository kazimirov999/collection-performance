package performance.list;


import org.openjdk.jmh.annotations.Benchmark;
import performance.TestData;

import java.util.List;


public abstract class PerformanceTestList<T extends List> {

    protected T data;
    protected TestData testData;
    protected int middleIndex;

    public  TestData[] getTestData(int amount){

        TestData[] listTestData = new TestData[amount];

        for(int i = 0; i < amount; i++){
            listTestData[i] = new TestData( i, "John_" + i);
        }

        return listTestData;
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
    public void testAddAt(){
        data.add(middleIndex, testData);
    }

    @Benchmark
    public void testGet(){
        data.get(middleIndex);
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
