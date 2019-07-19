package performance;

import com.google.common.collect.Lists;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import performance.guava.lists.PerformanceTestGuavaLists;
import performance.list.*;
import performance.map.*;
import performance.memory.MemoryTestCollections;
import performance.memory.MemoryTestMaps;
import performance.set.*;
import performance.queue.PerformanceTestArrayDeque;
import performance.queue.PerformanceTestPriorityQueue;

import java.util.*;


public class Main {
    public static void main(String[] args) throws RunnerException {

    Options options = new OptionsBuilder()
                .include(PerformanceTestArrayList.class.getSimpleName())
                .include(PerformanceTestLinkedList.class.getSimpleName())
                .include(PerformanceTestVector.class.getSimpleName())
                .include(PerformanceTestStack.class.getSimpleName())
                .include(PerformanceTestHashSet.class.getSimpleName())
                .include(PerformanceTestLinkedHashSet.class.getSimpleName())
                .include(PerformanceTestTreeSet.class.getSimpleName())
                .include(PerformanceTestHashMap.class.getSimpleName())
                .include(PerformanceTestLinkedHashMap.class.getSimpleName())
                .include(PerformanceTestTreeMap.class.getSimpleName())
                .include(PerformanceTestArrayDeque.class.getSimpleName())
                .include(PerformanceTestPriorityQueue.class.getSimpleName())
                .include(PerformanceTestGuavaLists.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(options).run();

        MemoryTestCollections memoryTestCollections = new MemoryTestCollections();
        memoryTestCollections.test(new ArrayList<>());
        memoryTestCollections.test(new LinkedList<>());
        memoryTestCollections.test(new Vector<>());
        memoryTestCollections.test(new Stack<>());
        memoryTestCollections.test(new HashSet<>());
        memoryTestCollections.test(new LinkedHashSet<>());
        memoryTestCollections.test(new TreeSet<>());
        memoryTestCollections.test(new ArrayDeque<>());
        memoryTestCollections.test(new PriorityQueue<>());

        MemoryTestMaps memoryTestMaps = new MemoryTestMaps();
        memoryTestMaps.test(new HashMap<>());
        memoryTestMaps.test(new LinkedHashMap<>());
        memoryTestMaps.test(new TreeMap<>());
    }
}
