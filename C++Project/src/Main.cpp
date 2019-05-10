/*
 * Main.cpp
 * Main function for my first C++ Project
 * Created on: May 12, 2016
 *      Author: HDamron1
 */
#include <iostream>
#include "My_Classes.h"

int main() {
	std::cout << "Hello World" << std::endl;
	std::cout << "This program will calculate the area and perimeter of a rectangle.\n"
			<< "Enter the width of the rectangle: ";
	int width;
	std::cin >> width;
	std::cout << "Enter the height of the rectangle: ";
	int height;
	std::cin >> height;

	Rectangle* rect = new Rectangle(width, height);
	std::cout << "The area is " << rect->area() << " and the perimeter is " << rect->perimeter() << std::endl;

	return 0;
}
