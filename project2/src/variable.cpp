//
// Created by Tyler Clark on 9/26/20.
//

#include <strstream>
#include <vector>


using namespace std;

#include "expression.h"
#include "operand.h"
#include "variable.h"
#include "symboltable.h"

extern SymbolTable symbolTable;

double Variable::evaluate()
{
    return symbolTable.lookUp(name);
}