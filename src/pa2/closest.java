package pa2;

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
	private int i, j ,k;	// for FOR statements

	/* QUICKSORT */
	private double pivot;	// standard index for sorting
	private point temp = new point();	// temporal space for swapping

	/* DIVIDE & CONQUER */
	private double min = -1.0;	// minimum distance
	private int inner;	// number of left point in (boundary-min) ~ boundary
	   
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
		quickSort(0, pnt.length - 1);	// for divide
		/* CASE: same point */
		if(min == 0)
			return 0;

		min = getDist(pnt[0], pnt[pnt.length - 1]);
		divide(0, pnt.length - 1);

		return min;
	}

	// QUICKSORT
	private void quickSort(int p, int r){
		if(p < r){
			int q = partition(p, r);
			/* CASE: same point */
			if(q == -1)
				return;
			quickSort(p, q - 1);
			quickSort(q + 1, r);
		}
	}
	private int partition(int p, int r){
		pivot = pnt[r].x;
		i = p - 1;
		for(j = p; j < r; j++){
			if(pnt[j].x <= pivot){
				/* CASE: same point */
				if(i != -1 && pnt[j].x == pivot && pnt[j].y == pnt[i].y) {
					min = 0;
					return -1;
				}
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
	private void divide(int p, int r){	// p: start position, r: end position
		if(p + 1 < r){	// length > 2
			int left = 0;	// number of the point:x <= boundary 
			double boundary = (pnt[p].x + pnt[r].x) / 2;
			for(i = p; i <= r; i++){
				if(pnt[i].x <= boundary)
					left++;
			}
			/* StackOverFlow */
			if(p + left - 1 != r)	// avoid to infinite loop
				divide(p, p + left - 1);
			if(p + left != p)	// avoid to infinite loop
				divide(p + left, r);
			getSubMinDist(p, r, left, boundary);
		}
		else if(p + 1 == r){	// length: 2 
			min = Math.min(min, getDist(pnt[p], pnt[r]));
		}
	}
	private void getSubMinDist(int p, int r, int left, double boundary){
		inner = 0;
		for(i = p + left - 1; i >= p && pnt[i].x >= boundary - min; i--){	// (boundary-min) ~ boundary
			inner++;
		}
		for(i = p + left; i <= r && pnt[i].x <= boundary + min; i++){	// boundary ~ (boundary+min)
			for(j = p + left - 1, k = 0; k < inner; j--, k++){
				min = Math.min(min, getDist(pnt[i], pnt[j]));
			}
		}
	}
	private double getDist(point a, point b){                                                                                   
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
}