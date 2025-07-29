#ifndef _AGENT_
#define _AGENT_

#include "Entity.hpp"

class Agent: public Entity{

private:
    double radius;
    Vec2D *dir;
    Vec2D *target;
    double speed;

public:
    Agent(Vec2D *p, string n, int e, double r)
        : Entity(p, n, e)
        , radius(r){
            
        }

    void setTarget(Vec2D *v){ 
        target = new Vec2D(v); 
        dir = new Vec2D(target->getX(), target->getY());
        dir->subtract(pos);
        dir->normalize();
    }

    void setSpeed(double s){ speed = s; }

    //override abstract method
    void update() {  
        double vx = speed*(dir->getX()); 
        double vy = speed*(dir->getY());
        Vec2D *vector = new Vec2D(vx, vy);
        Entity::pos->add(vector); //accedir a attribute position of entity
        delete vector;
    }

    bool targetReached(){
        
       double newx = target->getX() - pos->getX();
       double newy = target->getY() - pos->getY();
       Vec2D * newvect = new Vec2D(newx, newy);
       if(newvect->length() < radius){
        return true; 
       }
       delete newvect;
       return false;
       
    }

    bool isColliding(Agent *b){
        double newx = pos->getX() - b->pos->getX();
        double newy = pos->getY() - b->pos->getY();
        Vec2D* vec = new Vec2D(newx, newy);
        if(vec->length() < (radius + b->radius)){
            return true;
        }
        delete vec;
        return false;
    }
};
#endif