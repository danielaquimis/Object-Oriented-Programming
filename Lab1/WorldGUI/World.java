import java.awt.*;

public class World {
    //attributes
    private int width;
    private int height;
    private Agent[] agents;
    private int numAgents;
    private double margin = 30;

    //constructor
    public World(int w, int h, int cap){
        width = w;
        height = h;
        cap = numAgents;
        agents = new Agent[10];
        for(int i = 0; i<10; i++){
            double radius = randomRadius();
            Vec2D vectorAgent = randomPos();
            double posx = vectorAgent.getX();
            double posy = vectorAgent.getY();
            agents[i] = new Agent(radius, posx, posy);
            agents[i].setSpeed(1);
            Vec2D vectorTarget = randomPos();
            agents[i].setTarget(vectorTarget.getX(), vectorTarget.getY());
        }
    }


    public void simulationStep(){
        for(int i = 0; i<10; i++){
            if (agents[i].targetReached()){
                Vec2D newtarget = randomPos();
                agents[i].setTarget(newtarget.getX(), newtarget.getY());
            }else{
                //manageCollisions();
                agents[i].updatePosition();
            }
        }
    }

    public void paintWorld(Graphics g) {
		for (int i = 0; i < 10; i++){
            agents[i].paintAgent(g);
        }
	}

    public void manageCollisions(){
        for(int i = 0; i<10; ++i){
            for(int j = i+1; j<10; ++j){
                if(agents[i].isColliding(agents[j])){
                    //if both are colliding, change direction
                    Vec2D vectorTarget = randomPos();
                    agents[i].setTarget(vectorTarget.getX(), vectorTarget.getY());
                    agents[i].updatePosition();
                    Vec2D vectorTarget2 = randomPos();
                    agents[j].setTarget(vectorTarget2.getX(), vectorTarget2.getY());
                    agents[j].updatePosition();
                }
            }
        }
    }

    //aux methods
    private Vec2D randomPos(){
        double x = margin + Math.random() * ( width - 2 * margin ) ;
        double y = margin + Math.random() * ( height - 2 * margin ) ;
        return new Vec2D ( x , y ) ;
    }

    private double randomRadius(){
        return 5 + Math.random() * ( margin - 5 ) ;
    }

}
