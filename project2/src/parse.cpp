/**
    CS-11 Asn 2
    checks.cpp
    Purpose: Calculates the total of 6 checks

    @author Tyler Clark
    @version 1.1 4/10/16
*/

#include <cctype>
#include <iostream>
#include <string>
using namespace std;

#include "parse.h"


/**
    Sample summary

    @param digit the single digit to encode.
    @return a bar code of the digit using "|" as the long
    bar and "," as the half bar.
*/
string parseName()
{
    char alnum;
    string name = "";

    cin >> ws;
    while (isalnum(cin.peek()))
    {
        cin >> alnum;
        name += alnum;
    }
    return name;
}