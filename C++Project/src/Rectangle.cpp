/*
 * Rectangle.cpp
 *
 *  Created on: May 12, 2016
 *      Author: HDamron1
 */

#include "My_Classes.h"

int width, height;

Rectangle::Rectangle(int w, int h) {
	width = w;
	height = h;
}

Rectangle::~Rectangle() {

}

double Rectangle::area() {
	return width * height;
}

double Rectangle::perimeter() {
	return 2 * width + 2 * height;
}

