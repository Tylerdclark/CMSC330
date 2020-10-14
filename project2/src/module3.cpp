/**
    CMSC 330 Asn 2: Expression evaluator
    @file module3.cpp
    @author Tyler Clark
    @date 10/12/20
*/

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

void parseAssignments(std::stringstream &in);

int main()
{
    std::ifstream file("../input.txt"); //works in IDE
    if (!file)
    {
        file = std::ifstream("input.txt"); //works in command-line
    }
    
    Expression *expression;
    char paren, comma;
    if (file.is_open())
    {
        std::string line;
        while (std::getline(file, line))
        {
            std::stringstream in(line);
            in >> paren;
            std::cout << line << " ";
            expression = SubExpression::parse(in);
            in >> comma;
            parseAssignments(in);
            int result = expression->evaluate();
            std::cout << "Value = " << result << std::endl;
            symbolTable.reset();
        }
        file.close();
    }
    else
    {
        std::cerr << "File not found. Try moving file and ensure it is named 'input.txt'.\n";
    }
    return 0;
}

void parseAssignments(std::stringstream &in)
{
    char assignop, delimiter;
    std::string variable;
    int value;
    do
    {
        variable = parseName(in);
        in >> std::ws >> assignop >> value >> delimiter;
        symbolTable.insert(variable, value);
    } while (delimiter == ',');
}