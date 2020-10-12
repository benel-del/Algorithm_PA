import java.io.*;

// DO NOT modify class point, function closest(), and function setPoints(point p[])!

class point{
	public double x;
	public double y;
	public point(){
		x = 0.0;
		y = 0.0;
	}
}

public class closest{
	private point pnt[];

// If you need more member variables or member functions, declare here...
        
	public closest(){
		this.pnt = null;
	}

	public void setPoints(point p[]){
		int i = 0, n = p.length;
		this.pnt = null;
		this.pnt = new point[n];
		for(i=0;i<n;i++){
			this.pnt[i] = new point();
			this.pnt[i].x = p[i].x;
			this.pnt[i].y = p[i].y;
		}
	}
	public double getMinDist(){
		//Input source code here...
		
		return -1.0;
    }
}