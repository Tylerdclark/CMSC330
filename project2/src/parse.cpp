/**
    CMSC 330 Asn 2: Expression evaluator
    @file parse.cpp
    @author Tyler Clark
    @date 10/12/20
*/

#include <cctype>
#include <sstream>
#include <string>

#include "parse.h"

std::string parseName(std::stringstream &in)
{
    char alnum;
    std::string name;

    in >> std::ws;
    while (isalnum(in.peek()))
    {
        in >> alnum;
        name += alnum;
    }
    return name;
}