package performance.queue;

import org.openjdk.jmh.annotations.Benchmark;
import performance.TestData;

import java.util.Queue;

public abstract class PerformanceTestQueue<T extends Queue> {
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
    public void testRemove(){
        data.remove(testData);
    }

    @Benchmark
    public void testPoll(){
        data.poll();
    }

    @Benchmark
    public void testPeek(){
        data.peek();
    }

    @Benchmark
    public void testOffer(){
        data.offer(testData);
    }

    @Benchmark
    public void testElement(){
        data.element();
    }
}
