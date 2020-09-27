//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_SUBEXPRESSION_H
#define PROJECT2_SUBEXPRESSION_H

class SubExpression: public Expression
{
public:
    SubExpression(Expression* left, Expression* right);
    static Expression* parse();
protected:
    Expression* left;
    Expression* right;
};



#endif //PROJECT2_SUBEXPRESSION_H
