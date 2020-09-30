//
// Created by Tyler Clark on 9/29/20.
//

#ifndef PROJECT2_GREATERTHAN_H
#define PROJECT2_GREATERTHAN_H

class GreaterThan: public SubExpression
{
public:
    GreaterThan(Expression* left, Expression* right): SubExpression(left, right)
    {
    }
    int evaluate()
    {
        return left->evaluate() > right->evaluate();
    }
};

#endif //PROJECT2_GREATERTHAN_H
