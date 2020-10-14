/**
    CMSC 330 Asn 2: Expression evaluator
    @file literal.h
    @author Tyler Clark
    @date 10/12/20
*/

#ifndef PROJECT2_LITERAL_H
#define PROJECT2_LITERAL_H

class Literal : public Operand
{
public:
    explicit Literal(int value)
    {
        this->value = value;
    }

    int evaluate() override
    {
        return value;
    }

private:
    int value;
};

#endif //PROJECT2_LITERAL_H
