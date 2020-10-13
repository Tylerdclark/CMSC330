//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_SYMBOLTABLE_H
#define PROJECT2_SYMBOLTABLE_H

#include <string>
#include <utility>

class SymbolTable
{
public:
    SymbolTable() = default;

    void insert(std::string variable, int value);

    [[nodiscard]] int lookUp(const std::string &variable) const;

    void reset() { elements.clear(); }

private:
    struct Symbol
    {
        Symbol(std::string variable, int value)
        {
            this->variable = std::move(variable);
            this->value = value;
        }

        std::string variable;
        double value;
    };

    std::vector<Symbol> elements;
};

#endif //PROJECT2_SYMBOLTABLE_H
