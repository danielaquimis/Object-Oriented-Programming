import java.awt.*;

public class Agent {
    private double radius;
    private Vec2D vector_target;
    private double speed;
    private Vec2D vector_agent;
    private Vec2D vector_direction;

    //constructors
    public Agent(double r, double posx, double posy){
        radius = r;
        vector_agent = new Vec2D(posx, posy);
    }
    
    //setters
    public void setTarget(double tx, double ty){
        //1
        vector_target = new Vec2D(tx,ty);
        //2
        vector_direction = new Vec2D(vector_target.getX(), vector_target.getY());
        vector_direction.subtract(vector_agent);
        vector_direction.normalize();

        //same
        //double newposx = tx - vector_agent.getX();
        //double newposy = ty - vector_agent.getY();
        //vector_direction = new Vec2D(newposx,newposy);
        //vector_direction.normalize();
    }

    public void setSpeed(double s){
        speed = s;
    }

    public void updatePosition(){

        double vx = speed*(vector_direction.getX()); 
        double vy = speed*(vector_direction.getY());
        Vec2D vector = new Vec2D(vx, vy);
        vector_agent.add(vector);


        //double vx = vector_agent.getX() + speed*(vector_direction.getX()); 
        //double vy = vector_agent.getY() + speed*(vector_direction.getY());
        //vector_agent = new Vec2D(vx, vy);
    }

    public boolean targetReached(){
        double newx = vector_target.getX() - vector_agent.getX();
        double newy = vector_target.getY() - vector_agent.getY();
        Vec2D vectornew = new Vec2D(newx, newy);
        if (vectornew.length() < radius){
            return true;
        }
        return false;
        
    }

    public boolean isColliding(Agent b){
        double newx = vector_agent.getX() - b.vector_agent.getX();
        double newy = vector_agent.getY() - b.vector_agent.getY();
        Vec2D vectornew = new Vec2D(newx, newy);
        double agentsum = radius + b.radius;
        if (vectornew.length() < agentsum){
            return true;
        }
        return false;
    }

    public void paintAgent(Graphics g) {
		int x = ( int ) (vector_agent.getX() - radius) ;
        int y = ( int ) (vector_agent.getY() - radius) ;
        int d = ( int ) (2*radius) ;
		g.setColor(Color.RED) ;
        g.fillOval(x , y , d , d ) ;
	}
}
