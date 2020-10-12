/**
    CS-11 Asn 2
    checks.cpp
    Purpose: Calculates the total of 6 checks

    @author Tyler Clark
    @version 1.1 4/10/16
*/

#include <cctype>
#include <sstream>
#include <string>

#include "parse.h"

std::string parseName(std::stringstream &in) {
    char alnum;
    std::string name = "";

    in >> std::ws;
    while (isalnum(in.peek())) {
        in >> alnum;
        name += alnum;
    }
    return name;
}