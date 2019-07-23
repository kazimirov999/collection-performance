# collection-performance

**ArrayList** is implemented internally as a regular array. 
Therefore, when inserting an element into the middle, you must first move all elements one after it, and only then insert a new element into the vacant space. 
But it quickly implements taking and changing an element — get, set operations — because in them we simply refer to the corresponding element of the array.

**LinkedList** is implemented internally in a different way.
It is implemented as a linked list: a set of separate elements, each of which stores a link to the next and previous elements. 
To insert an element in the middle of such a list, it is enough to change the links of its future neighbors.
 But to get the element with the number 130, you need to go through all the objects from 0 to 130 sequentially. 
In other words, the set and get operations are implemented very slowly here.

**The Map <K, V>** interface represents a display or, in other words, a dictionary, where each element represents a key-value pair. 
At the same time, all keys are unique within the Map object. 
Such collections facilitate the search for an item if we know the key — the unique identifier of the object.

The **HashMap** class uses a hash table to store the card, providing quick execution time for get () and put () queries for large sets. 
The class implements the Map interface (data storage in the form of key / value pairs). 
Keys and values can be of any type, including null.

In this case, all keys must be unique, and the values can be repeated. This implementation does not guarantee the order of the elements.
**LinkedHashMap** will iterate in the order in which the records were placed on the map.

**TreeMap** will iterate according to the "natural order" of keys according to their compareTo () method (or external Comparator). 
In addition, it implements the SortedMap interface, which contains methods that depend on this sorting order.

**HashSet, TreeSet and LinkedHashSet** are part of the Set family. 
In Set sets, each element is stored in only one instance, and different Set implementations use a different order of element storage. 
In **HashSet**, the order of the elements is determined by a complex algorithm. 
If the storage order is important to you, use the **TreeSet** container, in which objects are stored sorted in ascending order by comparison 
or **LinkedHashSet** with the storage of items in order of addition.



| Benchmark                 | 100            |          1000  |         10000|  100000| 1000000| Units|
| ------------------------- |:--------------:| --------------:| --------------:|  --------------:|--------------:| ------:|
|ArrayListTest.testAdd|48,110|43,516|32,854|22,012|19,041|ns/op|
|ArrayListTest.testAddAll|132893130,000|152132394,118|128835123,077|247088760,000|227826616,667|ns/op|
|ArrayListTest.testClear|1,900|2,179|2,363|1,715|1,813|ns/op|
|ArrayListTest.testGet|1,492|1,361|1,352|1,428|1,399|ns/op|
|HashMapTest.testContainsKey|2,479|2,956|2,901|2,972|3,052|ns/op|
|HashMapTest.testContainsValue|114,817|1350,550|18205,749|289113,791|4119122,131|ns/op|
|HashMapTest.testGet|2,481|2,910|2,889|2,925|2,948|ns/op|
|HashMapTest.testPut|10,788|11,544|10,085|12,443|12,565|ns/op|
|HashMapTest.testRemove|2,414|2,226|2,130|2,129|2,193|ns/op|
|HashMapTest.testReplace|8,783|4,136|5,096|5,291|5,007|ns/op|
|HashSetTest.testAdd|22,533|24,191|23,269|34,642|40,424|ns/op|
|HashSetTest.testContains|17,524|18,391|19,762|20,792|26,652|ns/op|
|HashSetTest.testRemove|13,381|12,851|14,813|14,494|17,255|ns/op|
|LinkedHashMapTest.testContainsKey|2,527|2,927|3,059|3,045|3,085|ns/op|
|LinkedHashMapTest.testContainsValue|88,261|1264,614|23209,272|281877,496|4088287,755|ns/op|
|LinkedHashMapTest.testGet|2,685|3,295|3,369|3,355|3,393|ns/op|
|LinkedHashMapTest.testPut|10,830|11,224|8,961|13,974|14,263|ns/op|
|LinkedHashMapTest.testRemove|2,188|2,194|2,288|2,198|2,240|ns/op|
|LinkedHashMapTest.testReplace|9,758|4,604|5,533|5,410|9,470|ns/op|
|LinkedHashSetTest.testAdd|23,126|25,376|25,657|30,361|34,483|ns/op|
|LinkedHashSetTest.testContains|17,818|17,822|18,035|20,119|24,365|ns/op|
|LinkedHashSetTest.testRemove|13,130|12,551|13,197|13,701|16,287|ns/op|
|LinkedListTest.testAdd|87,594|84,910|84,297|90,365|74,901|ns/op|
|LinkedListTest.testAddAll|75371864,706|81828707,143|120154209,091|150522428,571|427663280,000|ns/op|
|LinkedListTest.testClear|2,170|2,383|2,209|3,917|3,244|ns/op|
|LinkedListTest.testGet|31,072|526,789|5667,442|158752,317|903405,771|ns/op
|TreeMapTest.testContainsKey|18,388|21,103|25,354|34,499|40,778|ns/op|
|TreeMapTest.testContainsValue|149,018|2122,008|31948,040|626895,050|4596170,183|ns/op|
|TreeMapTest.testGet|18,336|21,135|25,284|34,274|39,666|ns/op|
|TreeMapTest.testPut|19,237|25,193|37,062|42,242|59,242|ns/op|
|TreeMapTest.testRemove|14,727|19,514|23,716|36,909|35,063|ns/op|
|TreeMapTest.testReplace|18,282|22,341|28,058|37,071|41,983|ns/op|
|TreeSetTest.testAdd|2,688|3,408|3,462|3,291|3,268|ns/op|
|TreeSetTest.testContains|2,032|2,032|2,033|2,074|2,062|ns/op|
|TreeSetTest.testRemove|1,827|1,938|1,957|1,927|1,920|ns/op|