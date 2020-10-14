/**
    CMSC 330 Asn 2: Expression evaluator
    @file operand.cpp
    @author Tyler Clark
    @date 10/12/20
*/

#include <cctype>
#include <iostream>
#include <sstream>
#include <list>

#include "expression.h"
#include "subexpression.h"
#include "operand.h"
#include "variable.h"
#include "literal.h"
#include "parse.h"

Expression *Operand::parse(std::stringstream &in)
{
    char paren;
    int value;

    in >> std::ws;
    if (isdigit(in.peek()))
    {

        in >> value;
        Expression *literal = new Literal(value);
        return literal;
    }
    if (in.peek() == '(')
    {
        in >> paren;
        return SubExpression::parse(in);
    }
    else
        return new Variable(parseName(in));
}
