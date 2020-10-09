//
// Created by Tyler Clark on 9/26/20.
//

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <fstream>
#include "expression.h"
#include "subexpression.h"
#include "symboltable.h"
#include "parse.h"

SymbolTable symbolTable;

void parseAssignments(std::stringstream& in);

int main()
{
    std::ifstream file("../input.txt");
    Expression* expression;
    char paren, comma;
    if (file.is_open()){
        std::string line;
        while (std::getline(file, line)) {
            std::stringstream in(line);
            in >> paren;
            std::cout << line << " ";
            expression = SubExpression::parse(in);
            in >> comma;
            parseAssignments(in);
            double result = expression->evaluate();
            std::cout << "Value = " << result << std::endl;
            symbolTable.reset();

        }
        file.close();

    }
    return 0;
}

void parseAssignments(std::stringstream& in)
{
    char assignop, delimiter;
    std::string variable;
    double value;
    do
    {
        variable = parseName(in);
        in >> std::ws >> assignop >> value >> delimiter;
        symbolTable.insert(variable, value);
    }
    while (delimiter == ',');
}