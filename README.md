# collection-performance

<b>[Java Collections Framework](https://habr.com/ru/company/luxoft/blog/256877/)</b><br />

<b>The Set Interface</b><br />

<b>HashSet, LinkedHasSet, and TreeSet</b> <br />
HashSet, LinkedHashSet and TreeSet are implementations of Set, located around the left end of the Collection interface hierarchy in Figure 1.  HashSet is the default implementation used in most cases. LinkedHashSet is like a combination of HashSet and List in that it does not allow duplicate entries as with Sets, but traverses its elements in the order they were inserted, like a List would do. TreeSet will constantly keep all its elements in some sorted order. Keep in mind, however, that there is no such thing as a free lunch and that every added feature comes at a certain cost.

<b>SortedSet and Navigable Set</b> <br />
After looking at three classes implementing Set, let’s also take a look at the two sub-interfaces we haven’t talked about yet. As the name implies, SortedSet is a Set with the property that it is always sorted. The NavigableSet interface, added with Java 6, allows us to navigate through the sorted list, providing methods for retrieving the next element greater or smaller than a given element of the Set.

<b>The List Interface</b> <br />

<b>ArrayList and LinkedList</b> <br />
ArrayList is the default implementation for List, located to the middle of the collection hierarchy in Figure 1. Like any List implementation, it does allow duplicate elements and iteration in the order of insertion. As it is based on arrays, it is very fast to iterate and read from, but very slow to add or remove an element at random positions, as it has to rebuild the underlying array structure. In contrast, LinkedList makes it easy to add or remove elements at any position in the list while being slower to read from at random positions.
As a side note, we shortly consider Vector, a class that has been around since JDK 1, even before the Collections Framework which was added with Java 2. Long story short, its performance is suboptimal, so no new code should ever have to use it. An ArrayList or LinkedList simply does a better job.

<b>The Queue Interface</b> <br />

Lastly, we take a look at the classes implementing Queue. Another thing to mention about LinkedList is that while it implements List, it actually also implements Queue. It does so based on the fact that its actual implementation as a doubly-linked list makes it quite easy to also implement the Queue interface.

<b>PriorityQueue </b> <br />
Besides LinkedList, another common Queue implementation is PriorityQueue. It is an implementation that keeps its elements ordered automatically. It has functionality similar to TreeSet, except that it allows duplicate entries.

<b>The Map Interface</b> <br />

<b>Hashtable, HashMap, and LinkedHashMap</b> <br />
The Hashtable class was the first Collection in Java 1 that was based on the hash-table data structure. Unfortunately, like Vector, the class is deprecated because of its suboptimal performance. We can forget about it and use the other Map implementations instead. HashMap is the default implementation that you will find yourself using in most cases.

<b>TreeMap</b> <br />
TreeMap class implements Map interface similar to HashMap class. The main difference between them is that HashMap is an unordered collection while TreeMap is sorted in the ascending order of its keys. TreeMap is unsynchronized collection class which means it is not suitable for thread-safe operations until unless synchronized explicitly.

[Link to an article about collections in java](https://habr.com/ru/post/237043/)

<b>[Java Microbenchmark Harness](https://shipilev.net/blog/2014/nanotrusting-nanotime/)</b><br />

JMH is a Java harness library for writing benchmarks on the JVM, and it was developed as part of the OpenJDK project. JMH provides a very solid foundation for writing and running benchmarks whose results are not erroneous since they are not affected by unwanted virtual machine optimizations. JMH itself does not prevent the pitfalls that were briefly mentioned earlier, but it greatly helps in mitigating them. (The third part of this series is dedicated to explaining practices that help you avoid such pitfalls, which is why it's arguably the most important part.)<br />
JMH is popular for writing microbenchmarks, that is, benchmarks that stress a very specific piece of code. JMH also excels at concurrent benchmarks. That being said, JMH is a general-purpose benchmarking harness, so it is useful for larger benchmarks, too.

| Benchmark                 | 100            |          1000  |         1000000|   Units|
| ------------------------- |:--------------:| --------------:| --------------:| ------:|
|ArrayList.testAdd|55.279|42.044|26.322|ns/op|
|ArrayList.testAddAt|8635.329|8669.377|101908.696|ns/op|
|ArrayList.testAddAll|94160210.175|112630780.956|300039878.095|ns/op|
|ArrayList.testContains|50.170|664.935|3161086.144|ns/op|
|ArrayList.testGet|1.414|1.416|1.415|ns/op|
|ArrayList.testRemove|108.546|1450.891|6145858.412|ns/op|
|LinkedList.testAdd|83.690|99.219|101.336|ns/op|
|LinkedList.testAddAt|114.242|696.083|910674.513|ns/op|
|LinkedList.testAddAll|104429795.229|93041835.714|397020656.000|ns/op|
|LinkedList.testContains|84.747|1045.939|3677988.543|ns/op|
|LinkedList.testGet|31.309|533.335|985744.580|ns/op|
|LinkedList.testRemove|169.487|2120.774|7219987.761|ns/op|
|Stack.testAdd|2573.602|5725.293|14.596|ns/op|
|Stack.testAddAt|8632.898|8662.802|96946.604|ns/op|
|Stack.testAddAll|119918501.750|262782804.547|313524350.794|ns/op|
|Stack.testContains|52.388|628.025|3159736.990|ns/op|
|Stack.testGet|2.417|2.350|2.437|ns/op|
|Stack.testRemove|107.981|1441.755|6162065.523|ns/op|
|Vector.testAdd|56.014|43.622|20.052|ns/op|
|Vector.testAddAt|8624.661|8654.299|102475.178|ns/op|
|Vector.testAddAll|107852778.570|104022584.779|289948014.762|ns/op|
|Vector.testContains|53.395|629.739|3193038.296|ns/op|
|Vector.testGet|2.332|2.326|2.380|ns/op|
|Vector.testRemove|109.198|1449.423|6302194.940|ns/op|
|HashMap.testContainsKey|3.708|3.669|3.670|ns/op|
|HashMap.testContainsValue|281.054|493.724|14847801.850|ns/op|
|HashMap.testGet|3.813|3.852|3.712|ns/op|
|HashMap.testPut|10.754|8.510|10.199|ns/op|
|HashMap.testRemove|3.022|6.252|3.285|ns/op|
|HashMap.testReplace|8.892|7.502|9.540|ns/op|
|LinkedHashMap.testContainsKey|3.693|3.635|3.429|ns/op|
|LinkedHashMap.testContainsValue|90.082|1250.133|4150713.182|ns/op|
|LinkedHashMap.testGet|5.680|5.565|5.095|ns/op|
|LinkedHashMap.testPut|12.570|11.794|12.254|ns/op|
|LinkedHashMap.testRemove|2.829|3.852|3.152|ns/op|
|LinkedHashMap.testReplace|7.458|7.148|9.999|ns/op|
|TreeMap.testContainsKey|41.768|57.458|136.393|ns/op|
|TreeMap.testContainsValue|143.036|1953.714|4833424.330|ns/op|
|TreeMap.testGet|41.381|57.267|139.393|ns/op|
|TreeMap.testPut|45.173|67.107|167.085|ns/op|
|TreeMap.testRemove|47.542|79.968|172.617|ns/op|
|TreeMap.testReplace|46.594|68.703|137.778|ns/op|
|ArrayDeque.testAdd|65.934|70.105|28.761|ns/op|
|ArrayDeque.testElement|1.514|1.536|1.617|ns/op|
|ArrayDeque.testOffer|60.080|55.724|41.762|ns/op|
|ArrayDeque.testPeek|1.260|1.245|1.269|ns/op|
|ArrayDeque.testPoll|1.535|1.579|1.611|ns/op|
|ArrayDeque.testRemove|176.303|2498.130|6409888.689|ns/op|
|PriorityQueue.testAdd|186.776|153.532|61.795|ns/op|
|PriorityQueue.testElement|1.245|1.245|1.364|ns/op|
|PriorityQueue.testOffer|192.352|151.888|63.874|ns/op|
|PriorityQueue.testPeek|1.150|1.108|1.144|ns/op|
|PriorityQueue.testPoll|1.728|2.098|2.862|ns/op|
|PriorityQueue.testRemove|157.416|1777.607|7801077.189|ns/op|
|HashSet.testAdd|17.969|18.059|24.216|ns/op|
|HashSet.testContains|10.880|10.504|11.323|ns/op|
|HashSet.testRemove|4.107|4.254|4.086|ns/op|
|LinkedHashSet.testAdd|20.151|18.143|18.153|ns/op|
|LinkedHashSet.testContains|10.879|10.527|13.435|ns/op|
|LinkedHashSet.testRemove|4.880|3.974|3.701|ns/op|
|TreeSet.testAdd|9.293|10.480|10.559|ns/op|
|TreeSet.testContains|8.022|4.721|5.918|ns/op|
|TreeSet.testRemove|12.447|17.526|43.553|ns/op|

<b> Java collections memory test </b> <br />

| Collection                 | 100            |          1000  |         1000000|
| ------------------------- |:--------------:| --------------:| --------------:|
|ArrayList|9280|100176|100947144|
|LinkedList|11232|121632|120111584|
|Vector|9488|100368|101328080|
|Stack|9488|100368|101328080|
|HashSet|13120|128288|136380704|
|LinkedHashSet|13928|136296|144380712|
|TreeSet|12880|129312|135995488|
|ArrayDeque|9288|100272|101036128|
|PriorityQueue|9256|99872|100639744|
|HashMap|13088|133056|136428672|
|LinkedHashMap|13896|141064|144428680|q
|TreeMap|12848|132848|136040048|