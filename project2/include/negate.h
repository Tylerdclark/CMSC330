//
// Created by Tyler Clark on 9/30/20.
//

#ifndef PROJECT2_NEGATE_H
#define PROJECT2_NEGATE_H

class Negate: public SubExpression
{
public:
    Negate(Expression* left): SubExpression(left)
    {
    }
    int evaluate()
    {
        return !left->evaluate();
    }
};

#endif //PROJECT2_NEGATE_H
