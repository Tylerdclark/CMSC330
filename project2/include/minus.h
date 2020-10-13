//
// Created by Tyler Clark on 9/28/20.
//

#ifndef PROJECT2_MINUS_H
#define PROJECT2_MINUS_H

class Minus : public SubExpression
{
public:
    Minus(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() - right->evaluate();
    }
};

#endif //PROJECT2_MINUS_H
