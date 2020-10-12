//
// Created by Tyler Clark on 9/26/20.
//

#include <iostream>
#include <sstream>

#include "expression.h"
#include "subexpression.h"
#include "operand.h"
#include "plus.h"
#include "minus.h"
#include "times.h"
#include "divide.h"
#include "greaterthan.h"
#include "lessthan.h"
#include "equalto.h"
#include "and.h"
#include "or.h"
#include "negate.h"
#include "conditional.h"

SubExpression::SubExpression(Expression *left) {
    this->left = left;
}

SubExpression::SubExpression(Expression *left, Expression *right) {
    this->left = left;
    this->right = right;
}

SubExpression::SubExpression(Expression *left, Expression *right, Expression *condition) {
    this->left = left;
    this->right = right;
    this->condition = condition;
}

Expression *SubExpression::parse(std::stringstream &in) {
    Expression *left, *right, *condition;
    char operation, paren, query;
    left = Operand::parse(in);
    in >> operation;
    if (operation == '!') {
        in >> paren;
        return new Negate(left);
    } else if (operation == ':') {
        right = Operand::parse(in);
        in >> query;
        condition = Operand::parse(in);
        in >> paren;
        return new Conditional(left, right, condition);
    } else {
        right = Operand::parse(in);
        in >> paren;
    }


    switch (operation) {
        case '+':
            return new Plus(left, right);
        case '-':
            return new Minus(left, right);
        case '*':
            return new Times(left, right);
        case '/':
            return new Divide(left, right);
        case '>':
            return new GreaterThan(left, right);
        case '<':
            return new LessThan(left, right);
        case '=':
            return new EqualTo(left, right);
        case '&':
            return new And(left, right);
        case '|':
            return new Or(left, right);
    }
    return nullptr;
}