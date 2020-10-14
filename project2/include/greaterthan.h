/**
    CMSC 330 Asn 2: Expression evaluator
    @file greaterthan.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_GREATERTHAN_H
#define PROJECT2_GREATERTHAN_H

class GreaterThan : public SubExpression
{
public:
    GreaterThan(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() > right->evaluate();
    }
};

#endif //PROJECT2_GREATERTHAN_H
