*****Collections*****
1. Why do we need Collections in java?
Ans: Array are not dynamic. Once an array of a perticular size is declared,the size cannot be modified. 
To add a new element to the array, a new array has to be created with bigger size and all the elements 
from the old array copied to new array.
Collections are used in situations where data is dynamic. Collections allow adding an element, deleting 
an element and host our operations. There are a number of collections in java allowing to choose the right 
C-ollection for the right context.


2.What are the important interfaces in the collection Hierarchy?
Ans:The most important interface and their relationship are highlighted below.
interface Collection <E> extends Iterable<E>{ }

 //unique things only- Does not allows duplication.
 //If obj1.equal(obj2) then only one of them can be the 'Set'.
    interface Set<E> extends Collection<E>{}
 
 //List of thinks 
 //Care about which position each object is in
 //Elements can be added in by specifying position -where should it be added in
 //If element is added without specifying position- it is added at the end.
     interface List<E> extends Collection<E>{}
 
 //Arrange in order of processing - A to-do List for example 
 //Queue interface extends collection. So, it supports all Collection Methods.
 interface Queue<E> extends Collection<E>{}
 
   //A,C,A,C,E,C,M,D,H,=>{("A",5),("C",2)}
   //Key-Value pair {["key "]}
   
   
   
   ****Java collection interview general questions****
   ##https://howtodoinjava.com/interview-questions/useful-java-collection-interview-questions/#what_is_collection_in_java
1) What is the Java Collection framework? List down its advantages?

By definition, a collection is an object that represents a group of objects. 
Like in set theory, a set is group of elements. Easy enough !!

Prior to JDK 1.2, JDK has some utility classes such as Vector and HashTable, 
but there was no concept of Collection framework. 
Later from JDK 1.2 onwards, JDK felt the need of having a consistent support for reusable data structures. 
Finally, the collections framework was designed and developed primarily by Joshua Bloch, 
and was introduced in JDK 1.2.

Its most noticeable benefits of java collections can be listed as:

    Reduced programming effort due to ready to use code
    Increased performance because of high-performance implementations of data structures and algorithms
    Provides interoperability between unrelated APIs by establishing a common language to pass collections back and forth
    Easy to learn APIs by learning only some top level interfaces and supported operations

2) Explain Collection’s hierarchy?

Java Collection Hierarchy

          ||Collection||
          
   1.  |List| 2. |Queue| 3.|Set|        |Map|
   
   

As shown in above image, collection framework has one interface at top i.e. Collection. It is extended by Set,
List and Queue interfaces. Then there are loads of other classes in these 3 branches which we will learn in 
following questions.

Remember the signature of Collection interface. It will help you in many question.
public interface Collection extends Iterable {
//method definitions
}

Framework also consist of Map interface, which is part of collection framework. 
but it does not extend Collection interface. We will see the reason in 4th question in this question bank.


3) Why Collection interface does not extend Cloneable and Serializable interface?

Well, simplest answer is “there is no need to do it“. Extending an interface simply means that you are creating a s
ubtype of interface, in other words a more specialized behavior and Collection interface is not expected to do what 
Cloneable and Serializable interfaces do.

Another reason is that not everybody will have a reason to have Cloneable collection because if it has very large data,
then every unnecessary clone operation will consume a big memory. Beginners might use it without knowing the consequences.

Another reason is that Cloneable and Serializable are very specialized behavior and so should be implemented only 
when required. For example, many concrete classes in collection implements these interfaces. 
So if you want this feature. use these collection classes otherwise use their alternative classes.


4) Why Map interface does not extend Collection interface?

A good answer to this interview question is “because they are incompatible“. Collection has a method add(Object o). 
Map can not have such method because it need key-value pair. There are other reasons also such as Map supports keySet, 
valueSet etc. Collection classes does not have such views.

Due to such big differences, Collection interface was not used in Map interface, and it was build in separate hierarchy.
Java collection interview – List interface questions


5) Why we use List interface? What are main classes implementing List interface?

A java list is a “ordered” collection of elements. This ordering is a zero based index. 
It does not care about duplicates. Apart from methods defined in Collection interface,
it does have its own methods also which are largely to manipulate the collection based on index location of element.
These methods can be grouped as search, get, iteration and range view. All above operations support index locations.

The main classes implementing List interface are: Stack, Vector, ArrayList and LinkedList. 
Read more about them in java documentation.


6) How to convert an array of String to arraylist?

This is more of a programmatic question which is seen at beginner level. 
The intent is to check the knowledge of applicant in Collection utility classes. 
For now, lets learn that there are two utility classes in Collection framework which are mostly 
seen in interviews i.e. Collections and Arrays.

Collections class provides some static functions to perform specific operations on collection types. 
And Arrays provide utility functions to be performed on array types.
//String array
String[] words = {"ace", "boom", "crew", "dog", "eon"};
//Use Arrays utility class
List wordList = Arrays.asList(words);
//Now you can iterate over the list

Please not that this function is not specific to String class, it will return List of element of any type,
of which the array is. e.g.
//String array
Integer[] nums = {1,2,3,4};
//Use Arrays utility class
List numsList = Arrays.asList(nums);


7) How to reverse the list?

This question is just like above to test your knowledge of Collections utility class.
Use it reverse() method to reverse the list.
Collections.reverse(list);

****Java collection interview – Set interface questions***


8) Why we use Set interface? What are main classes implementing Set interface?

It models the mathematical set in set theory. Set interface is like List interface but with some differences.
First, it is not ordered collection. So no ordering is preserved while adding or removing elements. 
The main feature it does provide is “uniqueness of elements“. It does not support duplicate elements.

Set also adds a stronger contract on the behavior of the equals and hashCode operations, 
allowing Set instances to be compared meaningfully even if their implementation types differ. 
Two Set instances are equal if they contain the same elements.

Based on above reasons, it does not have operations based on indexes of elements like List. 
It only has methods which are inherited by Collection interface.

Main classes implementing Set interface are : EnumSet, HashSet, LinkedHashSet, TreeSet.
Read more on related java documentation.


9) How HashSet store elements?

You must know that HashMap store key-value pairs, with one condition i.e. keys will be unique. 
HashSet uses Map’s this feature to ensure uniqueness of elements. In HashSet class, a map declaration is as below:
private transient HashMap<E,Object> map;
 
//This is added as value for each key
private static final Object PRESENT = new Object();

So when you store a element in HashSet, it stores the element as key in map and “PRESENT” object as value.
(See declaration above).
public boolean add(E e) {
return map.put(e, PRESENT)==null;
}

I will highly suggest you to read this post: How HashMap works in java? This post will help you in 
answering all the HashMap related questions very easily.


10) Can a null element added to a TreeSet or HashSet?

As you see, There is no null check in add() method in previous question. 
And HashMap also allows one null key, so one “null” is allowed in HashSet.

TreeSet uses the same concept as HashSet for internal logic, but uses NavigableMap for storing the elements.
private transient NavigableMap<E,Object> m;
 
// Dummy value to associate with an Object in the backing Map
private static final Object PRESENT = new Object();

NavigableMap is subtype of SortedMap which does not allow null keys. So essentially, 
TreeSet also does not support null keys. It will throw NullPointerException if you try to add null element in TreeSet.


****Java collection interview – Map interface questions***

11) Why we use Map interface? What are main classes implementing Map interface?

Map interface is a special type of collection which is used to store key-value pairs.
It does not extend Collection interface for this reason. 
This interface provides methods to add, remove, search or iterate over various views of Map.

Main classes implementing Map interface are: HashMap, Hashtable, EnumMap, IdentityHashMap, LinkedHashMap and Properties.


12) What are IdentityHashMap and WeakHashMap?

IdentityHashMap is similar to HashMap except that it uses reference equality when comparing elements. 
IdentityHashMap class is not a widely used Map implementation. While this class implements the Map interface,
it intentionally violates Map’s general contract, which mandates the use of the equals() method when comparing objects.
IdentityHashMap is designed for use only in the rare cases wherein reference-equality semantics are required.

WeakHashMap is an implementation of the Map interface that stores only weak references to its keys. 
Storing only weak references allows a key-value pair to be garbage collected when its key is no longer 
referenced outside of the WeakHashMap. This class is intended primarily for use with key objects whose equals 
methods test for object identity using the == operator. Once such a key is discarded it can never be recreated, 
so it is impossible to do a look-up of that key in a WeakHashMap at some later time and be surprised that 
its entry has been removed.


13) Explain ConcurrentHashMap? How it works?

Taking from java docs:

A hash table supporting full concurrency of retrievals and adjustable expected concurrency for updates. 
This class obeys the same functional specification as Hashtable, and includes versions of methods corresponding 
to each method of Hashtable. However, even though all operations are thread-safe, retrieval operations do not
entail locking, and there is not any support for locking the entire table in a way that prevents all access.
This class is fully interoperable with Hashtable in programs that rely on its thread safety but not on 
its synchronization details.


*****Read more about how ConcurrentHashMap interview questions.+*****

14) How hashmap works?

The most important question which is most likely to be seen in every level of job interviews.
You must be very clear on this topic., not only because it is most asked question but also it will 
open up your mind in further questions related to collection APIs.

Answer to this question is very large and you should read it my post: How HashMap works? For now, 
lets remember that HashMap works on principle of Hashing.
A map by definition is : “An object that maps keys to values”. To store such structure, 
it uses an inner class Entry:
static class Entry implements Map.Entry
{
final K key;
V value;
Entry next;
final int hash;
...//More code goes here
}

Here key and value variables are used to store key-value pairs. Whole entry object is stored in an array.
/**
* The table, re-sized as necessary. Length MUST Always be a power of two.
*/
transient Entry[] table;

The index of array is calculated on basis on hashcode of Key object. Read more of linked topic.


15) How to design a good key for hashmap?

Another good question usually followed up after answering how hashmap works.
Well, the most important constraint is you must be able to fetch the value object back in future.
Otherwise, there is no use of having such a data structure. If you understand the working of hashmap,
you will find it largely depends on hashCode() and equals() method of Key objects.

So a good key object must provide same hashCode() again and again, no matter how many times it is fetched. 
Similarly, same keys must return true when compare with equals() method and different keys must return false.

For this reason, immutable classes are considered best candidate for HashMap keys.

Read more : How to design a good key for HashMap?


16) What are different Collection views provided by Map interface?

Map interface provides 3 views of key-values pairs stored in it:

    key set view
    value set view
    entry set view

All the views can be navigated using iterators.


17) When to use HashMap or TreeMap?

HashMap is well known class and all of us know that. So, I will leave this part by saying that it is used to store key-value pairs and allows to perform many operations on such collection of pairs.

TreeMap is special form of HashMap. It maintains the ordering of keys which is missing in HashMap class. This ordering is by default “natural ordering”. The default ordering can be override by providing an instance of Comparator class, whose compare method will be used to maintain ordering of keys.

Please note that all keys inserted into the map must implement the Comparable interface (this is necessary to decide the ordering). Furthermore, all such keys must be mutually comparable: k1.compareTo(k2) must not throw a ClassCastException for any keys k1 and k2 in the map. If the user attempts to put a key into the map that violates this constraint (for example, the user attempts to put a string key into a map whose keys are integers), the put(Object key, Object value) call will throw a ClassCastException.
Java collection interview – Tell the difference questions


18) Difference between Set and List?

The most noticeable differences are :

    Set is unordered collection where List is ordered collection based on zero based index.
    List allow duplicate elements but Set does not allow duplicates.
    List does not prevent inserting null elements (as many you like), but Set will allow only one null element.



19) Difference between List and Map?

Perhaps most easy question. List is collection of elements where as map is collection of key-value pairs. 
There is actually lots of differences which originate from first statement. They have separate top level interface,
separate set of generic methods, different supported methods and different views of collection.

I will take much time hear as answer to this question is enough as first difference only.



20) Difference between HashMap and HashTable?

There are several differences between HashMap and Hashtable in Java:

    Hashtable is synchronized, whereas HashMap is not.
    Hashtable does not allow null keys or values. HashMap allows one null key and any number of null values.
    The third significant difference between HashMap vs Hashtable is that Iterator in the HashMap is 
    a fail-fast iterator while the enumerator for the Hashtable is not.



21) Difference between Vector and ArrayList?

Lets note down the differences:

    All the methods of Vector is synchronized. But, the methods of ArrayList is not synchronized.
    Vector is a Legacy class added in first release of JDK. ArrayList was part of JDK 1.2, when
    collection framework was introduced in java.
    By default, Vector doubles the size of its array when it is re-sized internally. But, 
    ArrayList increases by half of its size when it is re-sized.



22) Difference between Iterator and Enumeration?

Iterators differ from enumerations in three ways:

    Iterators allow the caller to remove elements from the underlying collection during the iteration 
    with its remove() method. You can not add/remove elements from a collection when using enumerator.
    Enumeration is available in legacy classes i.e Vector/Stack etc. whereas Iterator is available in 
    all modern collection classes.
    Another minor difference is that Iterator has improved method names e.g. Enumeration.hasMoreElement()
    has become Iterator.hasNext(), Enumeration.nextElement() has become Iterator.next() etc.



23) Difference between HashMap and HashSet?

HashMap is collection of key-value pairs whereas HashSet is un-ordered collection of unique elements. 
That’s it. No need to describe further.



24) Difference between Iterator and ListIterator?

There are three Differences are there:

    We can use Iterator to traverse Set and List and also Map type of Objects. 
    But List Iterator can be used to traverse for List type Objects, but not for Set type of Objects.
    By using Iterator we can retrieve the elements from Collection Object in forward direction only 
    whereas List Iterator, which allows you to traverse in either directions using hasPrevious() 
    and previous() methods.
    ListIterator allows you modify the list using add() remove() methods. 
    Using Iterator you can not add, only remove the elements.



25) Difference between TreeSet and SortedSet?

SortedSet is an interface which TreeSet implements. That’ it !!



26) Difference between ArrayList and LinkedList?

    LinkedList store elements within a doubly-linked list data structure. ArrayList store elements within 
    a dynamically resizing array.
    LinkedList allows for constant-time insertions or removals, but only sequential access of elements. 
    In other words, you can walk the list forwards or backwards, but grabbing an element in the middle 
    takes time proportional to the size of the list. ArrayLists, on the other hand, allow random access, 
    so you can grab any element in constant time. But adding or removing from anywhere but the end requires 
    shifting all the latter elements over, either to make an opening or fill the gap.
    LinkedList has more memory overhead than ArrayList because in ArrayList each index only holds
    actual object (data) but in case of LinkedList each node holds both data and address of next and previous node.


***More collection interview questions***

27) How to make a collection read only?

Use following methods:

    Collections.unmodifiableList(list);
    Collections.unmodifiableSet(set);
    Collections.unmodifiableMap(map);

These methods takes collection parameter and return a new read-only collection with same elements as in original collection.



28) How to make a collection thread safe?

Use below methods:

    Collections.synchronizedList(list);
    Collections.synchronizedSet(set);
    Collections.synchronizedMap(map);

Above methods take collection as parameter and return same type of collection which are synchronized and thread safe.



29) Why there is not method like Iterator.add() to add elements to the collection?

The sole purpose of an Iterator is to enumerate through a collection.
All collections contain the add() method to serve your purpose. 
There would be no point in adding to an Iterator because the collection may or may not be ordered. 
And add() method can not have same implementation for ordered and unordered collections.



30) What are different ways to iterate over a list?

You can iterate over a list using following ways:

    Iterator loop
    For loop
    For loop (Advance)
    While loop

Read more : http://www.mkyong.com/java/how-do-loop-iterate-a-list-in-java/



31) What do you understand by iterator fail-fast property?

Fail-fast Iterators fail as soon as they realized that structure of Collection has been changed since iteration has begun. 
Structural changes means adding, removing or updating any element from collection while one thread is Iterating
over that collection.

Fail-fast behavior is implemented by keeping a modification count and if iteration thread realizes 
the change in modification count it throws ConcurrentModificationException.



32) What is difference between fail-fast and fail-safe?

You have understood fail-fast in previous question. Fail-safe iterators are just opposite to fail-fast. 
They never fail if you modify the underlying collection on which they are iterating, because they work on 
clone of Collection instead of original collection and that’s why they are called as fail-safe iterator.

Iterator of CopyOnWriteArrayList is an example of fail-safe Iterator also iterator written by
ConcurrentHashMap keySet is also fail-safe iterator and never throw ConcurrentModificationException.



33) How to avoid ConcurrentModificationException while iterating a collection?

You should first try to find another alternative iterator which are fail-safe. 
For example if you are using List and you can use ListIterator. If it is legacy collection, 
you can use enumeration.

If above options are not possible then you can use one of three changes:

    If you are using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes. 
    It is the recommended approach.
    You can convert the list to an array and then iterate on the array.
    You can lock the list while iterating by putting it in a synchronized block.

Please note that last two approaches will cause a performance hit.



34) What is UnsupportedOperationException?

This exception is thrown on invoked methods which are not supported by actual collection type.

For example, if you make a read-only list list using “Collections.unmodifiableList(list)” and 
then call add() or remove() method, what should happen. It should clearly throw UnsupportedOperationException.



35) Which collection classes provide random access of it’s elements?

ArrayList, HashMap, TreeMap, Hashtable classes provide random access to it’s elements.



36) What is BlockingQueue?

A Queue that additionally supports operations that wait for the queue to become non-empty when retrieving an element,
and wait for space to become available in the queue when storing an element.

BlockingQueue methods come in four forms: one throws an exception, the second returns
a special value (either null or false, depending on the operation), the third blocks the current thread 
indefinitely until the operation can succeed, and the fourth blocks for only a given maximum time limit before giving up.


****Read the example usage of blocking queue in post : How to use blocking queue?****



37) What is Queue and Stack, list down their differences?

A collection designed for holding elements prior to processing. Besides basic Collection operations, queues provide 
additional insertion, extraction, and inspection operations.
Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner.

Stack is also a form of Queue but one difference, it is LIFO (last-in-first-out).

Whatever the ordering used, the head of the queue is that element which would be removed by a call to remove() 
or poll(). Also note that Stack and Vector are both synchronized.

Usage: Use a queue if you want to process a stream of incoming items in the order that they are received.
Good for work lists and handling requests.
Use a stack if you want to push and pop from the top of the stack only. Good for recursive algorithms.



38) What is Comparable and Comparator interface?

In java. all collection which have feature of automatic sorting, uses compare methods to ensure the correct sorting 
of elements. For example classes which use sorting are TreeSet, TreeMap etc.

To sort the data elements a class needs to implement Comparator or Comparable interface. 
That’s why all Wrapper classes like Integer,Double and String class implements Comparable interface.

Comparable helps in preserving default natural sorting, whereas Comparator helps in sorting 

the elements in some special required sorting pattern. The instance of comparator if passed usually 

as collection’s constructor argument in supporting collections.



39) What are Collections and Arrays classes?

Collections and Arrays classes are special utility classes to support collection framework core classes. 
They provide utility functions to get read-only/ synchronized collections, sort the collection on various ways etc.

Arrays also helps array of objects to convert in collection objects. Arrays also have some functions which helps in 
copying or working in part of array objects.



40) Recommended resources

Well it is not interview question.. :-). This is only for fun. But you should really read my blog for more posts 
on collection framework knowledge.

I hope these java collection interview questions will help in in your next interview. Further, 
I will suggest you to read more on above questions apart from this post. A more knowledge will only help you.

Happy Learning !!
