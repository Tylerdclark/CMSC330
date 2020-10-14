/**
    CMSC 330 Asn 2: Expression evaluator
    @file conditional.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_CONDITIONAL_H
#define PROJECT2_CONDITIONAL_H

class Conditional : public SubExpression
{
public:
    Conditional(Expression *left, Expression *right, Expression *condition) : SubExpression(left, right, condition)
    {
    }

    int evaluate() override
    {
        if (condition->evaluate())
        {
            return left->evaluate();
        }
        return right->evaluate();
    }
};

#endif //PROJECT2_CONDITIONAL_H
