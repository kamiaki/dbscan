package top.dainel.thunder.warning.dbscan;

import java.util.Arrays;

/**
 * 用Circle来标记各个区域123
 */
public class Circle  {
    private Double[] c=new Double[3];//c[0]->经度 c[1]->纬度 c[2]->半径
    public Circle(Double x,Double y,Double r){
        this.c[0]=x;
        this.c[1]=y;
        this.c[2]=r;
    }
    public Circle(){

    }
    public Double getLongitude(){
        return getX();
    }
    public Double getLatitude(){
        return getY();
    }
    public Double getR(){
        return c[2];
    }
    public Double getX(){
        return c[0];
    }
    public Double getY(){
        return c[1];
    }
    public void setLongitude(Double v){
        this.setX(v);
    }
    public void setLatitude(Double v){
        this.setY(v);
    }
    public void setR(Double v){
        this.c[2]=v;
    }
    public void setX(Double v){
        this.c[0]=v;
    }
    public void setY(Double v){
        this.c[1]=v;
    }

    public void addLongitude(Double v){
        this.addX(v);
    }
    public void addLatitude(Double v){
        this.addY(v);
    }
    public void addX(Double v){
        if(this.c[0]==null){
            this.c[0]=v;
        }else{
            this.c[0]+=v;
        }
    }
    public void addY(Double v){
        if(this.c[1]==null){
            this.c[1]=v;
        }else{
            this.c[1]+=v;
        }
    }
    public void addR(Double v){
        if(this.c[2]==null){
            this.c[2]=v;
        }else{
            this.c[2]+=v;
        }
    }
    public double get(int index){
        return c[index];
    }
    public void set(int index,double v){
        c[index]=v;
    }
    public Double[] toArray(){
        return c;
    }

	@Override
	public String toString() {
		return "Circle [c=" + Arrays.toString(c) + "]";
	}

}
