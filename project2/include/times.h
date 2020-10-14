/**
    CMSC 330 Asn 2: Expression evaluator
    @file times.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_TIMES_H
#define PROJECT2_TIMES_H

class Times : public SubExpression
{
public:
    Times(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() * right->evaluate();
    }
};

#endif //PROJECT2_TIMES_H
