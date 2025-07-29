
#include <iostream>


#include "Agent.hpp"

int main() {

	//create instances of Agent

	Vec2D v1(1,1);
	Agent a1(&v1, "laia", 100, 0.2 );

	Vec2D v2(0,0);
	Agent a2(&v2, "daniela", 50, 1 );

	a1.setSpeed(0.5);
	a1.setTarget(&v2);
	std::cout << "target reached: " << a1.targetReached() << "\n"; //false because no update yet, so agent1 is at (1,1)
	
	while(a1.targetReached()!=1){
		a1.update();
	}
	std::cout << "target reached: " << a1.targetReached() << "\n"; //true because we updated until target reached

	//reached target is the position of the other agent so now they are colliding
	std::cout << "agent "<< a1.getName() << " is colliding agent " << a2.getName() << ": " << a1.isColliding(&a2) << "\n"; //true
	
	std::cout << "agent "<< a1.getName() << " has higher enery than agent " << a2.getName() << ": " << a1.compareTo(&a2) << "\n"; //true, laia has 100, daniela 50   
}

