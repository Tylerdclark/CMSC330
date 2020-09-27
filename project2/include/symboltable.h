//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_SYMBOLTABLE_H
#define PROJECT2_SYMBOLTABLE_H

class SymbolTable
{
public:
    SymbolTable() {}
    void insert(string variable, double value);
    double lookUp(string variable) const;
private:
    struct Symbol
    {
        Symbol(string variable, double value)
        {
            this->variable = variable;
            this->value = value;
        }
        string variable;
        double value;
    };
    vector <Symbol> elements;
};
#endif //PROJECT2_SYMBOLTABLE_H
