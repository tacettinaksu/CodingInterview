"""
 * @author tace
 * @since Aug 16, 2015

Assume you have a method isSubstring which checks if one word is a
substring of another. Given two strings, s1 and s2, write code to check
if s2 is a rotation of s1 using only one call to isSubstring (i.e.,
"waterbottle" is a rotation of "erbottlewat").
"""
import sys

input = "waterbottle"
rotated = "erbottlewat"

if len(input) != len(rotated) or len(rotated) < 1:
    print ("not rotated")
    sys.exit()

if input == rotated:
    print ("equal")
    sys.exit()

    
firstLetter = input[0]
lengthInput = len(rotated)

for i in range(0, lengthInput):
    sameTillEnd = True
    if firstLetter == rotated[i]:
        index = 1;
        for j in range(i + 1, lengthInput):
            if rotated[j] != input[index]:
                sameTillEnd = False;
                break
            index = index + 1
        if  sameTillEnd:
            print ("isRotated : ", input[lengthInput - i:lengthInput] == rotated[0:i])
            sys.exit()



print ("isRotated : ", False)
            
