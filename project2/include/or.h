//
// Created by Tyler Clark on 9/29/20.
//

#ifndef PROJECT2_OR_H
#define PROJECT2_OR_H

class Or : public SubExpression {
public:
    Or(Expression *left, Expression *right) : SubExpression(left, right) {
    }

    int evaluate() override {
        return left->evaluate() || right->evaluate();
    }
};

#endif //PROJECT2_OR_H
