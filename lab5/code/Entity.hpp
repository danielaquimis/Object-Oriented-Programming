#ifndef _ENTITY_
#define _ENTITY _

#include <iostream>
using namespace std;
#include "Vec2D.hpp"
#include "Nameable.hpp"
#include "Comparable.hpp"


class Entity: public Comparable<Entity>{ //fix ,Comparable

protected:
    Vec2D *pos;
    std::string name;
    int energy;

public:

    Entity(Vec2D *p, string n, int en): pos( new Vec2D(p)), name(n), energy(en) {}

    string getName() {
        return name;
    }

    void setName(string name){
        this->name = name;
    }

    int compareTo(Entity *e){ //pointer o algo?
        if(this->energy> e->energy){
            return 1;
        }
        return 0;
    }

    //declaration of an abstract method -> class is abstract
    virtual void update() = 0;
};

#endif