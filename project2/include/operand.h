//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_OPERAND_H
#define PROJECT2_OPERAND_H

class Operand : public Expression
{
public:
    static Expression *parse(std::stringstream &in);
};

#endif //PROJECT2_OPERAND_H
