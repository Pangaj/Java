# Learn Java ![Java](https://raw.githubusercontent.com/Pangaj/Java/master/java.jpg)

- [Blocking Queues](#blocking-queues)
- [Maps](#maps)
- [Compare i7 vs Xeon processor](#compare-i7-vs-xeon-processor)
- [HashMap - Why not thread safe?](#HashMap-Why-not-thread-safe?)

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

## Compare i7 vs Xeon processor
### Intel Core i7/i5 Pros

 - **Overclocking**
  - Unlocked i5 and i7 processors are designed to be ***overclocked***, meaning **they can run at higher clock speeds** than what they’re qualified for, assuming the right voltage and BIOS settings
  - This equates to free power and more value, a feature that Xeons do not have.

- **GHz per dollar**
  - For pure Gigahertz speed for the money, the 2011 and 1150 i7’s come out on top every time, making them the ***best value for single threaded applications***
  - For example a **4-core i7-7700 running at 3.6GHz** retails for around ***$300***. The comparable **quad core Xeon running at that clock speed** will cost about ***$50 more***


- **On board graphics**
    - *i7 and i5 processors all come with onboard graphics, meaning a discrete video card is not required for video display*, whereas *Xeon processor-based PCs cannot be configured without discrete video*

### Xeon Pros

- **L3 cache**
    - CPU caches are like small batches of memory that the processor keeps close by to speed up certain applications
    - Most **Xeon processors have 15-30MB of L3 cache** depending on the model, close to ***double their i7 counterparts***
    - This ***extra cache is one reason*** why Xeon’s are so much faster at **high demand workstation** applications than i7.


- **Support for ECC RAM**
    - ***Error Checking and Correction (ECC) RAM*** *detects and corrects most common data corruption before it occurs, eliminating the cause of many system crashes and translating to more stable overall performance*
    - **Only Xeon processors support ECC RAM**


- **More cores, multi CPU options**
    - If your applications require as **many CPU cores as possible**, Xeon is what you need
    - The **new Xeon v4 processors max out at 18 cores (36 after Hyperthreading)** whereas even the ***new Broadwell-E i7-6950X has just 10***
    - Multi-CPU configurations are also only possible with Xeon, as is featured in our HD360MAX workstation


- **Longevity (under heavy load)**
    - Xeon processors are **qualified to handle heavier, more intensive loads day in and day out**
    - For the serious workstation user, this can translate to better longevity over i7 counterparts


- **Hyperthreading at a lower pricepoint**
    - Most of the advantages of Xeon processors come to users in a higher price range, but not this one
    - **All Xeons come with Hyperthreading**
      - A process essentially **doubling the CPU cores through the creation of virtual cores**
      - Where i5 processors do not, many users shopping in this price range may find the Xeons to be a better value, assuming their specific application supports these virtual cores

## HashMap - Why not thread safe?
- In general, HashMap uses **HashFunction** to compute index into array of buckets and sets
- Most hashTable desinged imprefect HashFunction, which cause **collision**, where *same index for more than one key used widely because of more efficient*

## [Collision](https://en.wikipedia.org/wiki/Collision_(computer_science)
- A collision or classh occurs when **2 distinct input to same output**
- **Unavoidable** whenever memebers of ***very large set are mapped to relatively short bit string***
- Follows ***Pigeon hole principle*** where total birds are 10 and total box are 9, then one box will contain 2 pigeon

## HashCode
- ***Never misuse hashCode as a key***
- ***Do not use hashCode in distributed applications***
- *Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified*
- This integer ***need not remain consistent from one execution of an application to another*** execution of the same application
- **Default hashCode** provided by object -> derived by *Mapping the memory address to integer value*.
