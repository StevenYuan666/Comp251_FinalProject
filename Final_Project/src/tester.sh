#!/bin/bash

check=$(ls | grep "US_elections.java")
if [[ -z check ]]
then
	echo "Please put this scripts in the same directory of your US_elections.java file"
	exit 1
fi

echo "-----Start The Tester For Comp251 Final Project-----"
echo
echo "Compiling Your code"
javac US_elections.java
result=$?
if [[ result -ne 0 ]]
then
	echo "Compiled Error!"
	exit 2
fi
echo "Compiled Successfully"
echo

score=0
echo "US_elections.Test1"
echo "Expected: 50"
result=$(java US_elections open_case_1.txt)
echo "You got: $result"
if [[ $result -eq 50 ]]
then
	score=$((score+1))
fi
echo

echo "US_elections.Test2"
echo "Expected: -1"
result=$(java US_elections open_case_2.txt)
echo "You got: $result"
if [[ $result -eq -1 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test3"
echo "Expected: 32"
result=$(java US_elections open_case_3.txt)
echo "You got: $result"
if [[ $result -eq 32 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test4"
echo "Expected: 352"
result=$(java US_elections open_case_4.txt)
echo "You got: $result"
if [[ $result -eq 352 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test5"
echo "Expected: -1"
result=$(java US_elections open_case_5.txt)
echo "You got: $result"
if [[ $result -eq -1 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test6"
echo "Expected: 0"
result=$(java US_elections open_case_6.txt)
echo "You got: $result"
if [[ $result -eq 0 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test7"
echo "Expected: 302"
result=$(java US_elections open_case_7.txt)
echo "You got: $result"
if [[ $result -eq 302 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test8"
echo "Expected: -1"
result=$(java US_elections open_case_8.txt)
echo "You got: $result"
if [[ $result -eq -1 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test9"
echo "Expected: 303"
result=$(java US_elections open_case_9.txt)
echo "You got: $result"
if [[ $result -eq 303 ]]
then
        score=$((score+1))
fi
echo

echo "US_elections.Test10"
echo "Expected: 2018"
result=$(java US_elections open_case_10.txt)
echo "You got: $result"
if [[ $result -eq 2018 ]]
then
        score=$((score+1))
fi
echo

echo "Your Final Score: $score / 10"
