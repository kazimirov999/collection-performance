package performance.memory;

import com.carrotsearch.sizeof.RamUsageEstimator;
import performance.TestData;

import java.util.*;

public class MemoryTestCollections {

    private final int SIZE_1 = 100;
    private final int SIZE_2 = 1000;
    private final int SIZE_3 = 1000000;

    private void testMemory(AbstractCollection data, int size){

        TestData[] testData = getEmployees(size);

        for(int i=0;i<size;i++){
            data.add(testData[i]);
        }

        System.out.println(RamUsageEstimator.sizeOf(data));

    }

    public void test(AbstractCollection data){
        testMemory(data, SIZE_1);
        testMemory(data, SIZE_2);
        testMemory(data, SIZE_3);
    }

    private   TestData[] getEmployees(int amount){
        TestData[] testData = new TestData[amount];

        for(int i = 0; i < amount; i++){
            testData[i] = new TestData( i, "John_" + i);
        }

        return testData;
    }
}
