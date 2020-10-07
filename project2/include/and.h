//
// Created by Tyler Clark on 9/29/20.
//

#ifndef PROJECT2_AND_H
#define PROJECT2_AND_H

class And: public SubExpression
{
public:
    And(Expression* left, Expression* right): SubExpression(left, right)
    {
    }
    int evaluate() override
    {
        return left->evaluate() && right->evaluate();
    }
};


#endif //PROJECT2_AND_H
