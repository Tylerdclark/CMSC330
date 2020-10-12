//
// Created by Tyler Clark on 9/26/20.
//


#include <utility>
#include <vector>

#include "symboltable.h"

void SymbolTable::insert(std::string variable, int value) {
    const Symbol &symbol = Symbol(std::move(variable), value);
    elements.push_back(symbol);
}

int SymbolTable::lookUp(const std::string &variable) const {
    for (const auto &element : elements)
        if (element.variable == variable)
            return element.value;
    return -1;
}
