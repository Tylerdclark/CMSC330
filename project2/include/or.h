/**
    CMSC 330 Asn 2: Expression evaluator
    @file or.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_OR_H
#define PROJECT2_OR_H

class Or : public SubExpression
{
public:
    Or(Expression *left, Expression *right) : SubExpression(left, right)
    {
    }

    int evaluate() override
    {
        return left->evaluate() || right->evaluate();
    }
};

#endif //PROJECT2_OR_H
