public class ColorFrame extends Frame{
    
    public ColorFrame(int n, int m){
        super(n,m);
    }

    private int[] valToRGB(double rgb){
        int[] ret = new int[3];
        ret[0] =  ((int) rgb >> 16 ) & 255;
        ret[1] = ((int) rgb >> 8 ) & 255;
        ret[2] = ((int) rgb) & 255; 
        return ret;

    }

    private double RGBToVal(int r, int g, int b){
        double ret = (r<<16) | (g<<8) | b;
        return ret;
    }

    public void set(int n, int m, int r, int g, int b){
        double val = RGBToVal(r, g, b);
        super.set(n, m, val);
    }

    public int[] getRGB(int i, int j){
        double val = super.get(i, j);
        return valToRGB(val);
    }

    @Override
    public void changeBrightness(double delta) {
        for(int i = 0; i<super.rows; i++){
            for(int j = 0; j<super.cols; j++){
                int[] rgb = getRGB(i, j);
                int r = (int) (rgb[0]*delta);
                int g = (int) (rgb[1]*delta);
                int b = (int) (rgb[2]*delta);
                Double newval = RGBToVal(r, g, b);
                if((0<=r && r<=255) && (0<=g && g<=255) && (0<=b && g<=255)){
                    set(i,j,newval);
                }
            }
        }

    }

    public void changeRGB(int dr, int dg, int db){
        for(int i = 0; i<super.rows; i++){
            for(int j = 0; j<super.cols; j++){
                int[] rgb = getRGB(i, j);
                int r = (int) (rgb[0]*dr);
                int g = (int) (rgb[1]*db);
                int b = (int) (rgb[2]*db);
                Double newval = RGBToVal(r, g, b);
                if((0<=r && r<=255) && (0<=g && g<=255) && (0<=b && g<=255)){
                    set(i,j,newval);
                }
            }
        }
    }
    
}
