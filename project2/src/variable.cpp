/**
    CMSC 330 Asn 2: Expression evaluator
    @file variable.cpp
    @author Tyler Clark
    @date 10/12/20
*/

#include <strstream>
#include <vector>


#include "expression.h"
#include "operand.h"
#include "variable.h"
#include "symboltable.h"

extern SymbolTable symbolTable;

int Variable::evaluate()
{
    return symbolTable.lookUp(name);
}