//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_LITERAL_H
#define PROJECT2_LITERAL_H

class Literal: public Operand
{
public:
    Literal(int value)
    {
        this->value = value;
    }
    double evaluate()
    {
        return value;
    }
private:
    int value;
};

#endif //PROJECT2_LITERAL_H
