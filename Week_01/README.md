学习笔记

##### 本周学习知识点：数组、链表、跳表、栈、队列、优先队列、双端队列

###### 数组

线性数据结构，连续的内存空间存储相同类型的元素。

优点：访问速度快。时间复杂度O(n)。

缺点：删除和新增元素时，需要移动数据元素。时间复杂度O(n)。

###### 链表

线性数据结构，非连续的内存空间存储。

优点：删除和新增的时间复杂度是O(1)，不需要移动节点

缺点：访问速度慢，只能从第一个节点开始遍历

###### 跳表

在链表的基础上，创建索引，解决了链表访问速度慢的问题

优点：访问速度快，适合于范围查找。原理简单，效率比较高

缺点：删除和新增元素时，需要维护索引

###### 栈

先进后出的数据结构

Java中的类为`Stack`，继承`Vector`，提供的方法有push、pop、peek、empty、search都是线程安全的，用`sychronized`修饰方法。

###### 队列

先进先出数据结构，一端进一端出

Java中的类为`Queue`，继承`Collection`，提供的方法有add、offer、remove、poll、peek等。

###### 优先队列

Java中的类为`PriorityQueue`，继承`AbstractQueue`，出队时根据优先级先出队最大的元素，元素要实现`Comparator`作为比较元素大小的依据。

###### 双端队列

Java中的类为`Deque`，继承`Queue`，顾名思义，队列的头和尾都可以进队和出队操作。提供的方法有addFirst、addLast、offerFirst、offerLast、removeFirst、removeLast、pollFirst、pollLast、getFirst、getLast、peekFirst等等。

