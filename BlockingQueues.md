# Blocking Queues
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
