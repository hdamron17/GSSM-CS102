'''
Created on May 10, 2016

@author: HDamron1
'''
from pip._vendor.distlib.compat import raw_input

def println(string):
    print(string);

print("Hello World", end="\nHi Bob\n");
if True :
    println("True is True");
else: 
    print("True is False");
b = 9;
print("b = ", b , ' this uses single quotation marks)');

beans = raw_input("Enter a string: ");
println((beans + " ") * 7);

for i in range(0, 5):
    print(i, " ", end="");
    
comp_num = 5 + 4j;
print(comp_num);

print("sqrt(-4) = ", (-4) ** 0.5);

if((True & True) and (True or False)):
    print("True");
    
    