//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_SYMBOLTABLE_H
#define PROJECT2_SYMBOLTABLE_H

#include <string>

class SymbolTable
{
public:
    SymbolTable() {}
    void insert(std::string variable, double value);
    double lookUp(std::string variable) const;
private:
    struct Symbol
    {
        Symbol(std::string variable, double value)
        {
            this->variable = variable;
            this->value = value;
        }
        std::string variable;
        double value;
    };
    std::vector <Symbol> elements;
};
#endif //PROJECT2_SYMBOLTABLE_H
