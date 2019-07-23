package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Map;

@State(Scope.Benchmark)

public class PerformanceTestMap<T extends Map> {

        protected T data;
        public int middleIndex;
        protected TestData testData;
        protected Integer key;

        public T getTestData (int lenght, T data) {
            TestData[] testData = new TestData[lenght];
            for (int i = 0; i<lenght; i++){
                testData [i] =  new TestData("№ " + i, i);
            }
            for (int i = 0; i< lenght; i++){
                data.put(testData[i].index, testData[i]);
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
