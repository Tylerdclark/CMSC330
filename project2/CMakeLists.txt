cmake_minimum_required(VERSION 3.17)
project(project2)

set(CMAKE_CXX_STANDARD 20)
include_directories(include)


add_executable(project2
        src/module3.cpp
        include/expression.h
        include/subexpression.h
        src/subexpression.cpp
        include/plus.h
        include/operand.h
        src/operand.cpp
        include/variable.h
        src/variable.cpp
        include/literal.h
        include/symboltable.h
        src/symboltable.cpp 
        include/parse.h
        src/parse.cpp include/minus.h include/times.h include/divide.h)