//
// Created by Tyler Clark on 9/26/20.
//

#include <cctype>
#include <sstream>
#include <string>

#include "parse.h"

std::string parseName(std::stringstream &in)
{
    char alnum;
    std::string name = "";

    in >> std::ws;
    while (isalnum(in.peek()))
    {
        in >> alnum;
        name += alnum;
    }
    return name;
}