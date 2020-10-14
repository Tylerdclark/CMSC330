/**
    CMSC 330 Asn 2: Expression evaluator
    @file operand.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_OPERAND_H
#define PROJECT2_OPERAND_H

class Operand : public Expression
{
public:
    static Expression *parse(std::stringstream &in);
};

#endif //PROJECT2_OPERAND_H
