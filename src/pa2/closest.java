package pa2;

import java.io.*;

// boundary : 좌표 기준 O.
// x좌표 사용 : o.
// 경우의 수 확인

// + stack over flow 해결
// + same point 해결

// => step2, step3: complete(약 188.5ms). step1: must be solved.

// IF boundary == x of any point ??
// 혹시 data store limitation? 소수점 오차??	=> bigDecimal??	=> must be import... no!!!!!!

// test code에 소수점 이하 16자리 이상의 좌표 존재.. double은 15자리까지만 표현 가능
// double 범위 : 15개의 유효 숫자를 가지며, -1.7E+308의 근사값 ~ 15개의 유효 숫자를 가지며, 1.7E+308의 근사값



// boundary 기준 x만 보지 말고 y도 볼까?

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
    private int q;          // use in quickSort()
    private double pivot;   // used in partition()
    private point temp = new point();       // used in swap()

    // DIVDE & CONQUER
    private double  boundary;
    private double min = -1.0, min2 = -1.0; // min distance
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

         quickSort(0, pnt.length - 1);      // for divide left, right in divide&conquer
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
                 if(q == -1)
                         return;
                 /* stack overflow */
                 quickSort(p, q - 1);
                 quickSort(q + 1, r);
         }
 }
 private int partition(int p, int r){
         pivot = pnt[r].x;
         i = p - 1;
         for(j = p; j < r; j++){
                 if(pnt[j].x <= pivot){
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
    private void divide(int p, int r){   // array, start position, end position
            if(p + 1 < r){
                    int left = 0;
                    double boundary = (pnt[p].x + pnt[r].x) / 2;
                    for(i = p; i <= r; i++){
                            if(pnt[i].x <= boundary)
                                    left++;
                    }

                    /* StackOverFlow */
                    if(p + left - 1 != r)
                            divide(p, p + left - 1);
                    if(p + left != p)
                            divide(p + left, r);
                    getSubMinDist(p, r, left, boundary);
            }
            else if(p + 1 == r){    // 2개 비교
                    min = Math.min(min, getDist(pnt[p], pnt[r]));
            }
    }
    private void getSubMinDist(int p, int r, int left, double boundary){
            //System.out.println("p: "+ p + ", r: " + r + ", left: " + left);

            inner = 0;
            for(i = p + left - 1; i >= p && pnt[i].x >= boundary - min; i--){      // boundary-min ~ boundary
                    inner++;
            }
            for(i = p + left; i <= r && pnt[i].x <= boundary + min; i++){      // boundary ~ boundary+min
                    for(j = p + left - 1, k = 0; k < inner; j--, k++){
                            min = Math.min(min, getDist(pnt[i], pnt[j]));
                    }
            }
    }
	private double getDist(point a, point b){                                                                                   
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
	 
	
}