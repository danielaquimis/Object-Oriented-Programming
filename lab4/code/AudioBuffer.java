public class AudioBuffer extends Vector{

    public AudioBuffer(int dim){
        super(dim);
    }

    public void changeVolume(double delta){
        super.multiply(delta);
    }

}
