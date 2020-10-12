package pa2;

import java.io.*;

public class pa2 {
	public static void main(String args[]) throws Exception{
		int i=0;
		int[] x = {4, 10, 5, -2, -1, 6, 3, 6, -9, 5};
		int[] y = {9, 3, 10, 5, -9, -3, 10, -10, 4, 2};
		closest clo = new closest();
		point[] p = new point[10];
		for(i=0;i<10;i++){
			p[i] = new point();
			p[i].x = x[i];
			p[i].y = y[i];
		}
		clo.setPoints(p);
		System.out.println("Minimum distance: "+clo.getMinDist());
		for(i=0;i<10;i++)       p[i] = null;
		p = null;
		clo = null;
	}
}