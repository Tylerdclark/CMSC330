//
// Created by Tyler Clark on 9/29/20.
//

#ifndef PROJECT2_LESSTHAN_H
#define PROJECT2_LESSTHAN_H

class LessThan : public SubExpression
{
public:
    LessThan(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() < right->evaluate();
    }
};

#endif //PROJECT2_LESSTHAN_H
