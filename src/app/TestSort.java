
/*************************************************/
/***  Simple test class for Sort class         ***/
/***                                           ***/
/***  Author: Jason Steggles    20/09/2019     ***/
/*************************************************/


public class TestSort {
	public static void main(String[] args) {

    int testResults[][] = new int[3][6];

    for(int alg=0; alg<3; alg++) {
      for(int test=0; test<6; test++) {
        Sort sortTest;
        if(test<3) sortTest = new Sort(50);
        else sortTest = new Sort(1000);
        sortTest.readIn("src/app/test" + (test+1) + ".txt");
        sortTest.sort(alg);
        testResults[alg][test] = sortTest.comp;
      }
    }
    System.out.format("%10s |%10s |%10s |%10s\n", "Test", "Insertion", "Quicksort", "Newsort");
    for(int i=0; i<6; i++)
      System.out.format("%10s |%10d |%10d |%10d\n", "test" + (i+1) + ".txt", testResults[0][i], testResults[1][i], testResults[2][i]);
  } 
} /** End of TestSort class **/
