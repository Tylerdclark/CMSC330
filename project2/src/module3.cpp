//
// Created by Tyler Clark on 9/26/20.
//

#include <iostream>
#include <string>
#include <vector>

#include "expression.h"
#include "subexpression.h"
#include "symboltable.h"
#include "parse.h"

SymbolTable symbolTable;

void parseAssignments();

int main()
{
    Expression* expression;
    char paren, comma;
    std::cout << "Enter expression: ";
    std::cin >> paren;
    expression = SubExpression::parse();
    std::cin >> comma;
    parseAssignments();
    std::cout << "Value = " << expression->evaluate() << std::endl;
    return 0;
}

void parseAssignments()
{
    char assignop, delimiter;
    std::string variable;
    double value;
    do
    {
        variable = parseName();
        std::cin >> std::ws >> assignop >> value >> delimiter;
        symbolTable.insert(variable, value);
    }
    while (delimiter == ',');
}