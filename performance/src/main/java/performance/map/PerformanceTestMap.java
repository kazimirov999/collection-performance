package performance.map;


import org.openjdk.jmh.annotations.Benchmark;
import performance.TestData;

import java.util.Map;


public abstract class PerformanceTestMap<T extends Map> {

    protected T data;
    protected TestData testData;
    protected String key;
    protected int middleIndex;

    public  T getTestData(int amount, T data){
        TestData[] testData = new TestData[amount];

        for(int i = 0; i < amount; i++){
            testData[i] = new TestData( i, "John_" + i);
        }

        for(int i=0;i<amount;i++){
            data.put(testData[i].getName(), testData[i]);
        }

        return data;
    }


    @Benchmark
    public void testGet(){
        data.get(key);
    }

    @Benchmark
    public void testContainsKey(){
        data.containsKey(key);
    }

    @Benchmark
    public void testContainsValue(){
        data.containsValue(testData);
    }

    @Benchmark
    public void testPut(){
        data.put(key, testData);
    }

    @Benchmark
    public void testRemove(){
        data.remove(key);
    }

    @Benchmark
    public void testReplace(){
        data.replace(key, testData);
    }
}
