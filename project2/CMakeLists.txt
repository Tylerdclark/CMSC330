cmake_minimum_required(VERSION 3.17)
project(project2)

set(CMAKE_CXX_STANDARD 20)
include_directories(include)
set(SOURCES
        src/module3.cpp
        src/parse.cpp
        src/symboltable.cpp
        src/subexpression.cpp
        src/operand.cpp
        src/variable.cpp
        )
add_executable(project2 ${SOURCES})