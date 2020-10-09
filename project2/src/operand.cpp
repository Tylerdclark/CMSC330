//
// Created by Tyler Clark on 9/26/20.
//

#include <cctype>
#include <iostream>
#include <sstream>
#include <list>
#include <string>


#include "expression.h"
#include "subexpression.h"
#include "operand.h"
#include "variable.h"
#include "literal.h"
#include "parse.h"

Expression* Operand::parse(std::stringstream& in)
{
    char paren;
    double value;

    in >> std::ws;
    if (isdigit(in.peek()))
    {
        in >> value;
        Expression* literal = new Literal(value);
        return literal;
    }
    if (in.peek() == '(')
    {
        in >> paren;
        return SubExpression::parse();
    }
    else
        return new Variable(parseName());
    return 0;
}
