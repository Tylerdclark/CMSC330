cmake_minimum_required(VERSION 3.17)
project(project2)

set(CMAKE_CXX_STANDARD 20)
include_directories(${PROJECT_SOURCE_DIR})
add_executable(project2 main.cpp add.cpp)