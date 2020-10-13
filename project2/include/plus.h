//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_PLUS_H
#define PROJECT2_PLUS_H

class Plus : public SubExpression
{
public:
    Plus(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() + right->evaluate();
    }
};

#endif //PROJECT2_PLUS_H
