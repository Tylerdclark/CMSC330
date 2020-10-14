/**
    CMSC 330 Asn 2: Expression evaluator
    @file variable.h
    @author Tyler Clark
    @date 10/12/20
*/

#include <utility>

#ifndef PROJECT2_VARIABLE_H
#define PROJECT2_VARIABLE_H

class Variable : public Operand
{
public:

    explicit Variable(std::string name)
    {
        this->name = std::move(name);
    }

    int evaluate() override;

private:
    std::string name;
};

#endif //PROJECT2_VARIABLE_H
