/**
    CMSC 330 Asn 2: Expression evaluator
    @file plus.h
    @author Tyler Clark
    @date 10/12/20
*/
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
