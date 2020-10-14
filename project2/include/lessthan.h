/**
    CMSC 330 Asn 2: Expression evaluator
    @file lessthan.h
    @author Tyler Clark
    @date 10/12/20
*/

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
