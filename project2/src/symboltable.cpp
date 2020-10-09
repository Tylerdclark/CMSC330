//
// Created by Tyler Clark on 9/26/20.
//


#include <vector>


#include "symboltable.h"

void SymbolTable::insert(std::string variable, double value)
{
    const Symbol &symbol = Symbol(variable, value);
    elements.push_back(symbol);
}

double SymbolTable::lookUp(std::string variable) const
{
    for (int i = 0; i < elements.size(); i++)
        if (elements[i].variable == variable)
            return elements[i].value;
    return -1;
}
