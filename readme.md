# Computer Science II
## Lab 9.0 - Sorting

A review of sorting algorithms and efficiency.

This is a lab used in Computer Science II (CSCE 156, CSCE 156H) in the 
[Department of Computer Science & Engineering](https://cse.unl.edu) at the 
[University of Nebraska-Lincoln](https://unl.edu).

Chris Bourke wrote this lab, revamped by Sarah Roscoe for Summer 2022.

## Overview

### Resources

Prior to lab you should read/review the following resources.

1.  Review insertion sort and quick sort from the class notes or from
    the following resources:

    -   <http://en.wikipedia.org/wiki/Insertion_sort>

    -   <http://en.wikipedia.org/wiki/Quick_sort>
    
    - <https://youtu.be/Hoixgm4-P4M>

2.  Familiarize yourself with sorting algorithms using the following
    site: <http://www.sorting-algorithms.com/>
    
### Lab Objectives & Topics

Following the lab, you should be able to:

-   Sort a `List` of objects by using the `Comparable<T>` interface 
    and various sorting methods including the `Collections.sort()` method.

-   Be familiar with Insertion Sort and Quick Sort algorithms and be
    able to adapt them to sort comparable objects.

-   Compare and contrast the performance of various sorting methods

-   Empirically measure the relative performance of algorithms with
    respect to the input size.
    
### Peer Programming Pair-Up

You will work on this lab with a partner. One of you should submit your code to the corresponding Handin assignment, or both of you should submit identical code. Handin link: https://cse-apps.unl.edu/handin

You will work in a pair programming setup. At the start of each lab, you may be randomly paired up with another student by a lab instructor. One of you will be designated the driver and the other the navigator.

The navigator will be responsible for reading the instructions and telling the driver what is to be done. The driver will be in charge of the keyboard and workstation (on Zoom, this means the driver shares their screen). Both driver and navigator are responsible for suggesting fixes and solutions together. Neither the navigator nor the driver is "in charge." Beyond your immediate pairing, you are encouraged to help and interact and with other pairs in the lab.

Each week you should try to alternate: if you were a driver last week, be a navigator next, etc. Resolve any issues (you were both drivers last week) within your pair. Ask the lab instructor to resolve issues only when you cannot come to a consensus.

Because of the peer programming setup of labs, it is absolutely essential that you complete any pre-lab activities and familiarize yourself with the handouts prior to coming to lab. Failure to do so will negatively impact your ability to collaborate and work with others which may mean that you will not be able to complete the lab.

## 1. Getting Started

Clone this project code for this lab from GitHub in Eclipse using the
URL: https://github.com/sroscoe2/CSCE156-Lab09.git. Refer to Lab 1.0 for
instructions on how to clone a project from GitHub.

## 2. Sorting

Being able to organize and retrieve information in large datasets is a
big research area with numerous applications. At the heart of any data
mining endeavor is the fundamental operation of sorting.

For this lab, we have provided a file containing United States
geographical data (specifically, a comprehensive list of 80264
geographical locations identified by 5-digit zip code, city, state 
and latitude/longitude). Functionality has already been provided for
processing this data file and creating a list of `Location` objects 
to hold this data. Each time you run the `main()` method in the 
`SortingPerformance` class, a random selection of locations is loaded. 
The variable `n` specifies the number of locations to be used
so that you'll be able to easily run experiments on different input sizes.

It will be your task to determine how this geographical data should be
sorted, develop several sorting algorithms to actually sort the data,
and empirically evaluate the running time of each algorithm.

## 2.1 Comparable Interface

Numerical and string data types have a *natural ordering* that is
well-defined using lexicographic ordering.  However, user defined 
types such as the `Location` object do not have an obvious natural 
ordering.  It is possible to order locations by an individual field 
(zip code, state, city) or a combination of those fields. Java 
provides a means for you to define exactly how instances of your class 
should be ordered by implementing the `Comparable<T>` interface.

If a class implements the `Comparable<T>` interface, it *must* provide 
an implementation for the following method:

`public int compareTo(T item)`

The general contract of this method is as follows:

-   It returns a negative number if `this` object should *precede*
    (come before) the `item` object

-   It returns zero if `this` object is "equivalent" to the `item` object

-   It returns a positive number if `this` object should come after the
    `item` object

## 2.2 Sorting Algorithms

You will be comparing four different sorting algorithms: selection sort,
insertion sort, quick sort, and the sorting method provided by the JDK
(Java Developer's Kit, specifically the `Collections.sort()` method, 
usually an implementation of Tim Sort).  A selection sort algorithm 
implementation has already been provided for you in the `SortingAlgorithms` 
class.  You can refer to this method if you are unclear on how to
use the `compareTo()` method to order instances. You will need to 
complete the implementations of the insertion sort and quick sort 
algorithms to sort `Location` objects. 

### 2.3 Comparing Running Times

To compare how each sorting algorithm performs, you will setup an
experiment and calculate how much time it actually takes to sort the
list of locations by using the `System.nanoTime()` method. This method 
returns the current system time, more-or-less precise to a nanosecond 
(1 second = 1,000 milliseconds = 1,000,000 microseconds = 1,000,000,000 nanoseconds). 
By taking a snapshot of the system time before and after a method call, you
can compute (roughly) the total elapsed time. As an example, consider
the following code snippet.  An example has been provided (see 
`SortingPerformance`) that times Java's `Collections.sort()` method and 
reports (an estimate of) its execution time in seconds.  Adapt this
code to perform your own emperical experiments.  Be sure to pass in a
*deep copy* of the list so as not to bias the performance by providing
it a pre-sorted list.

## 3. Activities

1.  Implement the `compareTo()` method in the `Location` class. You may 
    use whatever criteria you wish (city/state or latitude/longitude etc.).

2.  Implement the `insertionSort()` and `quickSortRecursive()` methods in 
    the `SortingAlgorithms` class. Do this by adapting the
    algorithms as presented in your text book or other resource
    (algorithms are also available in our [CS1
    textbook](https://bitbucket.org/chrisbourke/computersciencei/raw/44fb9b39be3221dc02c1b5d0712f9b9f03260e46/ComputerScienceOne.pdf).

3.  Debug your code and verify that each sorting algorithm is correctly
    sorting by using the provided JUnit test suites.

4.  Perform timed experimental runs of each of your algorithms
    on various list sizes.  Specifically, run experiments on the specified 
    list sizes below and record your findings.  For best results, run the 
    experiment several times each and take an average running time.  
    
    | Algorithm      | Theoretical Efficiency | 1,000 | 10,000 | 20,000 | 100,000 |
    |----------------|------------------------|-------|--------|--------|---------|
    | Java Sort      | O(nlog(n))             |       |        |        |         |
    | Selection Sort | O(n^2)                 |       |        |        |         |
    | Insertion Sort | O(n^2)                 |       |        |        |         |
    | Quick Sort     | O(nlog(n))             |       |        |        |         |                                               

    - Without actually running the simulation, predict the running time of
      each algorithm for n = 1,000,000 based on the theoretical efficiency
      and observed running time.

    - According to your experiments, is there a clear ranking of the
      sorting algorithms? If so, list them from best to worst. 


## 4. Testing, Submitting & Grading

* Test your programs using the provided JUnit test suite(s).  Fix any
errors and completely debug your programs.
* Submit the following files through webhandin:
  * `SortingAlgorithms.java`
* Run the grader and verify the output to complete your lab.

## Advanced Activity (Optional) 

1.  Examine the experimental data for each of the sorting algorithms on
    the various input sizes. Under the assumption that we have 1 million
    records, make a prediction, based on the observed running times on
    how long each algorithm would take to execute. Find a (or generate a
    fake) fake dataset of 1 million entries and run your experiment. Do
    your predictions match the actual running time?

2.  Implementing the `Comparable` interface means that `Location` objects 
    can only be "naturally ordered" in one way. It is often more flexible 
    to instead use a `Comparator` class
    to enable a user to order objects in any order that they want while
    reusing your methods. Rewrite each of the sorting methods to instead
    use a `Comparator<Location>` instance passed in to the method.







