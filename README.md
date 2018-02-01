# Learn Java ![Java](https://raw.githubusercontent.com/Pangaj/Java/master/java.jpg)

- [Blocking Queues](#blocking-queues)
- [Maps](#maps)


## Blocking Queues
* A blocking queue is a queue that **blocks**,
  - When you try to **dequeue** from it when the queue is **empty**, or
  - When you try to **enqueue** items to it when the queue is **already full**.

  - A thread trying to dequeue from an empty queue is blocked until some other thread inserts an item into the queue.
  - A thread trying to enqueue an item in a full queue is blocked until some other thread makes space in the queue, either by dequeuing one or more items or clearing the queue completely.

#### Most BlockingQueue follows the below:
  * Does not support null values
  * Thread Safe
  * Have **remainingCapacity** as param to get total number of unfilled items
  * **put** - item will insert into the queue if **remainingCapacity** not equals to zero. i.e., It has some space in the array. Else, it will **block the queue until another thread frees the item in current queue**  
  * **take** - item will take from the queue if any exists, else It will **block the queue untill another thread adds element into current queue**

  ##### There are 7 types of Blocking Queues. They are,
    1. ArrayBlockingQueue
    2. DelayQueue
    3. LinkedBlockingDeque
    4. LinkedBlockingQueue
    5. LinkedTransferQueue
    6. PriorityBlockingQueue
    7. SynchronousQueue

### 1. ArrayBlockingQueue
  * Backed by Array
  * Bounded in size. You to specify the total Capacity at the time of initialisation

### 2. DelayQueue
  * Unbounded queue
  * Can only taken if delay has expired
  * If any delay has expired 1st, then queue will contain element as head.
  * Delay units in nanoSeconds
  * Size of array returns both expired and unexpired elements
  * An item is expired only if its delay is <= 0, i.e., must equal to or lesser than 0
  * Unexpired elements cannot be removed treated as normal elements

### 3. LinkedBlockingDeque
  * These are Optionally bounded, If unspecify Capacity then, it will take its bound as **MAX_VALUE**
  * Deque refers to a **double-ended queue** where elements can be added to or removed from either the front (head) or back (tail)
  * addFirst(Object o) will add element at first position
  * takeLast() will get the element from its last position
  * Other than this we have addLast() and takeFirst()
  * removeFirstOccurance and removeLastOccurance

### 4. LinkedBlockingQueue
  * These are Optionally bounded, If unspecify Capacity then, it will take its bound as **MAX_VALUE**
  * High throughput than Array-based queue
  * But, less predictable performace in most concurrent appications
  * Dynamic creation of nodes

### 5. LinkedTransferQueue
  * Unbounded queue
  * **transfer**
    - Using **put** & **take** we could wait until the an element is freed or added into the current queue respectively.
    - But using **transfer** you could even **wait until another thread fetch your item from the queue**
  * This **cannot be done in any BlockingQueue** except ***SynchronousQueue***

### 6. PriorityBlockingQueue
  * Unbounded queue
  * But, additional of nodes may fail if **OutOfMemoryError**
  * If you need to traversal in order then use, Arrays.sort(pq.toArray())
  * **drainTo** can used to remove some or all elements in priority order and place them in another collection

### 7. SynchronousQueue
  * **Does not have internal capacity** not event one
  * Each insert wait for corresponding remove operation by another thread & vice versa
  * **No iteration** as nothing to iterate
  * If you try to add node in the queue,, then it will be head
  * If no elements in queue, **poll()** will **return null**
  * *Instead of put, if you use* ***add*** *then will throw exception as* **Queue full exception**


  |          |Throws Exception|Special Value|  Blocks  |         Times Out           |
  |:---------|:--------------:|:-----------:|:--------:|:---------------------------:|
  | Insertion|    add ( O )   | offer ( O ) | put ( O )| Offer (O, timeout, timeUnit)|
  | Deletion |   remove ( O ) |  poll ()    |  take () | poll (O, timeout, timeUnit) |
  | Examine  |    element ()  |  peek ()    |

## Maps
|         Property             |          HashMap            |            TreeMap                      |    LinkedHashMap    |
|:-----------------------------|:---------------------------:|:---------------------------------------:|:-------------------:|
|          Order               |No guarantee for the order   |Sorted according to the natural ordering |    Insertion order  |
| get/put/remove/ containsKey  |           O (1)             |              O (log n)                  |        O (1)        |
|         Interface            |           Map               |       Map / NavigableMap/ SortedMap     |         Map         |
|     Null value & keys        |         allowed             |              only values                |       allowed       |
|      Implementation          |         Buckets             |            Red-Black trees              |Double-linked buckets|
|      IsSynchronised          |     Not Synchronised        |            Not Synchronised             |  Not Synchronised   |
