/**
    CMSC 330 Asn 2: Expression evaluator
    @file and.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_AND_H
#define PROJECT2_AND_H

class And : public SubExpression
{
public:
    And(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() && right->evaluate();
    }
};

#endif //PROJECT2_AND_H
