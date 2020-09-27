//
// Created by Tyler Clark on 9/26/20.
//

#ifndef PROJECT2_VARIABLE_H
#define PROJECT2_VARIABLE_H

class Variable: public Operand
{
public:
    Variable(string name)
    {
        this->name = name;
    }
    double Variable::evaluate();
private:
    string name;
};

#endif //PROJECT2_VARIABLE_H
