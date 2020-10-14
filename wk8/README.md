# Week 8 discussion

## Initial question

Many programming languages, especially older ones, provide no language support for concurrency. C and C++ are examples of such languages. Is it essential that a language include syntax for concurrency to be able to write concurrent programs in that language? If not, how is it accomplished? What are the advantages and disadvantages of including support for concurrency in a language?

## My response

I would have to say that it is not entirely true that C++ does not support concurrency. As of C++-11 threads were introduced and even in later updates, more tools were added that aid in concurrency. The below chart from [this site](https://www.educative.io/blog/modern-multithreading-and-concurrency-in-cpp) shows the timeline of concurrent features brought to C++.

![concurrency chart](wee8pic0.png)

As we reach the absolute minimum size of transistors in CPUs, increased cores become more of a lucrative improvement for next gen CPUs. To match the increasing cores and in an attempt to capitalize on the imminent improvements, concurrency will prove very important. As long as programming languages provide the use of external libraries, it is not absolutely essential for a language to provide syntax for concurrency. For example, In Python, the threading, asyncio, and multiprocessing libraries all provide a means to concurrency in a language that does not contain the syntax for concurrency.

A benefit of including native concurrency in a language is that you would not need to load an external library. In concurrency itself, there are many benefits:

* Better use of multi-core systems (talked on above)
* I/O can happen simultaneously while tasks are running
* Long tasks need not delay short tasks
* Better control of tasks with preconditions, where they can be suspended and resumed freely.
  
But, there are also the disadvantages:

* Inherent complexity of designing a program with many threads
* Concurrent tasks can corrupt the consistent state of a program
* Deadlock can occur when tasks wait for each other indefinitely
  
In addition to the previous disadvantages, the overhead of scheduling and synchronization associated with concurrency mustn't outweigh the serial version of the program! Sometimes it's just more efficient to not use concurrency. It becomes important to understand which tasks should be implemented concurrently.
