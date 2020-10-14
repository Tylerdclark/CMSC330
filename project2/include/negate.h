/**
    CMSC 330 Asn 2: Expression evaluator
    @file negate.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_NEGATE_H
#define PROJECT2_NEGATE_H

class Negate : public SubExpression
{
public:
    explicit Negate(Expression *left) : SubExpression(left)
    {
    }

    int evaluate() override
    {
        return !left->evaluate();
    }
};

#endif //PROJECT2_NEGATE_H
