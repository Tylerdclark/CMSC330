/**
    CMSC 330 Asn 2: Expression evaluator
    @file minus.h
    @author Tyler Clark
    @date 10/12/20
*/

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
