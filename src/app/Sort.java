
/*****************************************************/
/*** Sort class currently contains some initial    ***/
/*** methods for implementing sorting algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/19   ***/
/***     Extended by: ?                            ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

  /** Size of array **/
  private int size;

  /** Number of used elements in array **/
  private int usedSize;

  /** Array of integers **/
  private int[] A;

  /** Global variables for counting sort comparisons **/
  public int comp; /** Global comparison count for any Sort **/

  /*****************/
  /** Constructor **/
  /*****************/
  Sort(int max) {
    /** Initialiase global sort count variables **/
    comp = 0;
    
    /** Initialise size variables **/
    usedSize = 0;
    size = max;
    
    /** Create Array of Integers **/
    A = new int[size];
  }

  public void sort(int alg) {
    if(alg==0) insertion();
    if(alg==1) quicksort(0, usedSize-1);
    if(alg==2) newsort();
  }

  ////////////////////
  // Insertion sort //
  ////////////////////

  public void insertion() {
    int i,j,key;
    for(i=1; i < usedSize; i++) {
      key = A[i];
      j = i;
      while(j>0 && key < A[j-1]) {
        A[j] = A[j-1];
        comp++;
        j--;
      }
      comp++;
      A[j] = key;
    }
  }
 
  ///////////////
  // Quicksort //
  ///////////////

  public void quicksort(int L, int R) {
    if(R>L) {
      int p = partition(L, R);
      quicksort(L, p-1);
      quicksort(p+1, R);
    }
  }

  private int partition(int L, int R) {
    int v = A[R];
    int pL = L;
    int pR = R;
    while(pL < pR) {
      while(A[pL] < v) {
        pL++;
        comp++;
      }
      comp++;
      while(A[pR] >= v && pR > L) {
        pR--;
        comp++;
      }
      comp++;
      if(pL < pR) swap(pL, pR);
    } 
    swap(pL, R);
    return pL;
  }

  private void swap(int a, int b) {
    int temp = A[a];
    A[a] = A[b];
    A[b] = temp;
  }

  /////////////
  // newsort //
  /////////////

  public void newsort() {
    int pos = 0;
    while(pos<usedSize) {
      int min = findMinFrom(pos);
      for(int i=pos; i<usedSize; i++) {
        if(A[i]==min) {
          swap(i, pos);
          pos++;
        }
        comp++;
      }
    }
  }

  public int findMinFrom(int pos) {
    int min = A[pos];
    // comp++;
    for(int i=pos+1; i<usedSize; i++) {
      if(A[i]<min) {
        min=A[i];
      }
      comp++;
    }
    return min;
  }

  /*********************************************/
  /*** Read a file of integers into an array ***/
  /*********************************************/
  public void readIn(String file) {
    try {
      /** Initialise loop variable **/
      usedSize = 0;
      
      /** Set up file for reading **/
      FileReader reader = new FileReader(file);
      Scanner in = new Scanner(reader);
      
      /** Loop round reading in data while array not full **/
      while(in.hasNextInt() && (usedSize < size)) {
        A[usedSize] = in.nextInt();
        usedSize++;
      }  
    } catch (IOException e) {
      System.out.println("Error processing file " + file);
    }
  }

  /**********************/
  /*** Display array  ***/
  /**********************/
  public void display(int line, String header) {
    /*** Integer Formatter - three digits ***/
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);

    /** Print header string **/
    System.out.print("\n"+header);

    /** Display array data **/
    for (int i=0;i<usedSize;i++) {
      /** Check if new line is needed **/
      if (i%line == 0) { 
          System.out.println(); 
      }

      /** Display an array element **/
      System.out.print(FI.format(A[i])+" ");
    }
  }
}
