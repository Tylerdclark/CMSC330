# Week 6 discussion

## Initial question

One important difference between languages that provide syntax to encapsulate the definition of user defined data types is whether the syntax requires the specification details to be separated from the implementation details. Ada requires such a separation. In Ada, the specification information must be placed in the package specification and the implementation details in the package body. Where must the representation details be placed?

Compare Ada with both C++ and Java in this regard. Take and defend a position as to whether requiring separation of the specification and representation information for a data type is a good language design decision.

## My response

Separating specification and implementation can be desired because it can keep the implementation code hidden and allow a user to use the class effectively. It avoids distracting with the implementation details, and further prevents unintended changes to the compiled code. As this week's module states, this separation is in relation to the OOP idea of data abstraction. Another good use of this separation is with larger projects. When the implementation hasn't changed, then there is no need to recompile the implementation file (At least with C++).

With C++, it is not required to separate implementation and specification, but often desired due to the reasons stated above. Specification can be placed in the public part of the header file, which consists of the function prototypes (function prototypes for methods not forward-facing can also be placed in the private portion). Additionally for C++, representation is placed in header file, but in the private portion. The implementation of the functions could be found in the source file.

With Ada, this separation is required and revolves around "packages". Those packages are not so much about how the program will run, but rather how it is constructed and how it is to be understood and maintained. The package specification has all the subprogram specifications, variables, types, constants which will be visible to anyone who uses the "with" keyword with the package. Like C++'s header file, the representation details must be in the specification, but can be declared public or private. It is essential that the representation details are in the package specification so that the compiler can properly allocate memory.

With java, the separation is not required but is possible through use of an interface, which can be seen as a kind of a "contract" to the user of it.  Those interfaces are collections of abstract methods, constants, default methods, static methods, and/or nested types. With Java, a class can implement multiple interfaces.
