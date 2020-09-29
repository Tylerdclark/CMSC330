//
// Created by Tyler Clark on 9/28/20.
//

#ifndef PROJECT2_DIVIDE_H
#define PROJECT2_DIVIDE_H

class Divide: public SubExpression
{
public:
    Divide(Expression* left, Expression* right): SubExpression(left, right)
    {
    }
    int evaluate()
    {
        return left->evaluate() / right->evaluate();
    }
};

#endif //PROJECT2_DIVIDE_H
