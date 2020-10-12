//
// Created by Tyler Clark on 9/28/20.
//

#ifndef PROJECT2_TIMES_H
#define PROJECT2_TIMES_H

class Times : public SubExpression {
public:
    Times(Expression *left, Expression *right) : SubExpression(left, right) {
    }

    int evaluate() {
        return left->evaluate() * right->evaluate();
    }
};

#endif //PROJECT2_TIMES_H
