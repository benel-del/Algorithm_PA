package pa2;

import java.io.*;

// boundary : 좌표 기준 O.
// x좌표 사용 : o.
// 뭐가 문제지.

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
	
	// ENTIRE
	private int i, j ,k;    // for FOR statement

	// QUICKSORT
	//private int q;          // use in quickSort()
	private double pivot;   // used in partition()
	private point temp = new point();     // used in swap()

	// DIVDE & CONQUER
	private double  boundary;
	private double min, min2;     // min distance
	private int inner;      // number of left point in boundary-min ~ boundary
	   
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
		
		// x 기준
		quickSort(0, pnt.length - 1);      // for divide left, right in divide&conquer
        
		min = getDist(pnt[0], pnt[pnt.length - 1]);
		divide(0, pnt.length - 1);

		// y 기준
		quickSort2(0, pnt.length - 1);      // for divide left, right in divide&conquer
        
		min2 = getDist(pnt[0], pnt[pnt.length - 1]);
		divide2(0, pnt.length - 1);
		
		return Math.min(min, min2);
		//return min;
    }
	
	// QUICKSORT
	private void quickSort(int p, int r){
		if(p < r){
			int q = partition(p, r);
			quickSort(p, q - 1);
			quickSort(q + 1, r);
		}
	}
	private int partition(int p, int r){
		pivot = pnt[r].x;
		i = p - 1;
		for(j = p; j < r; j++){
			if(pnt[j].x <= pivot){
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, r);

		return i + 1;
	}
	private void swap(int a, int b){
		temp.x = pnt[a].x;
		temp.y = pnt[a].y;
		pnt[a].x = pnt[b].x;
		pnt[a].y = pnt[b].y;
		pnt[b].x = temp.x;
		pnt[b].y = temp.y;
	}

	// DIVIDE & CONQUER
	private void divide(int p, int r){   // array, start position, end position
		if(p + 1 < r){
			int left = 0;
			boundary = (pnt[p].x + pnt[r].x) / 2;
			for(i = p; i <= r; i++){
				if(pnt[i].x <= boundary)
					left++;
			}
			divide(p, p + left - 1);
			divide(p + left, r);
			getSubMinDist(p, r, left);
		}
	}       
	private void getSubMinDist(int p, int r, int left){
		System.out.println("p: "+ p + ", r: " + r + ", left: " + left);

		inner = 0;
		for(i = p + left - 1; i >= p && pnt[i].x > boundary - min; i--){      // boundary-min ~ boundary
			inner++;
		}
		for(i = p + left; i <= r && pnt[i].x < boundary + min; i++){      // boundary ~ boundary+min
			for(j = p + left - 1, k = 0; k < inner; j--, k++){
				min = Math.min(min, getDist(pnt[i], pnt[j]));
			}
		}
	}

	private double getDist(point a, point b){
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
	
	
	private void quickSort2(int p, int r){
		if(p < r){
			int q = partition2(p, r);
			quickSort(p, q - 1);
			quickSort(q + 1, r);
		}
	}
	private void getSubMinDist2(int p, int r, int left){
		System.out.println("p: "+ p + ", r: " + r + ", left: " + left);

		inner = 0;
		for(i = p + left - 1; i >= p && pnt[i].y > boundary - min2; i--){      // boundary-min ~ boundary
			inner++;
		}
		for(i = p + left; i <= r && pnt[i].y < boundary + min2; i++){      // boundary ~ boundary+min
			for(j = p + left - 1, k = 0; k < inner; j--, k++){
				min2 = Math.min(min2, getDist(pnt[i], pnt[j]));
			}
		}
	}
	private int partition2(int p, int r){
		pivot = pnt[r].y;
		i = p - 1;
		for(j = p; j < r; j++){
			if(pnt[j].y <= pivot){
				i++;
				swap(i, j);
			}
		}
		swap(i + 1, r);

		return i + 1;
	}
	private void divide2(int p, int r){   // array, start position, end position
		if(p + 1 < r){
			int left = 0;
			boundary = (pnt[p].y + pnt[r].y) / 2;
			for(i = p; i <= r; i++){
				if(pnt[i].y <= boundary)
					left++;
			}
			divide(p, p + left - 1);
			divide(p + left, r);
			getSubMinDist2(p, r, left);
		}
	}
	
	
}