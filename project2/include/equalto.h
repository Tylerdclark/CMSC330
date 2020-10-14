/**
    CMSC 330 Asn 2: Expression evaluator
    @file equalto.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_EQUALTO_H
#define PROJECT2_EQUALTO_H

class EqualTo : public SubExpression
{
public:
    EqualTo(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() == right->evaluate();
    }
};

#endif //PROJECT2_EQUALTO_H
