//
// Created by Tyler Clark on 9/26/20.
//
#ifndef PROJECT2_SUBEXPRESSION_H
#define PROJECT2_SUBEXPRESSION_H

class SubExpression: public Expression
{
public:
    explicit SubExpression(Expression *left);
    SubExpression(Expression* left, Expression* right);
    SubExpression(Expression* left, Expression* right, Expression* condition);
    static Expression* parse(std::stringstream& in);
protected:
    Expression* left;
    Expression* right;
    Expression* condition;
};



#endif //PROJECT2_SUBEXPRESSION_H
