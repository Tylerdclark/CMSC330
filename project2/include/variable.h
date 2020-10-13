#include <utility>

//
// Created by Tyler Clark on 9/26/20.
//

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
