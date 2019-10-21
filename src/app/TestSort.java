
/*************************************************/
/***  Simple test class for Sort class         ***/
/***                                           ***/
/***  Author: Jason Steggles    20/09/2019     ***/
/*************************************************/


public class TestSort {
	public static void main(String[] args) {

    int testResults[][] = new int[3][6]; // Multidimentional array to store results

    // Algorithm 1: Insertion Sort
    // Algorithm 2: Quicksort
    // Algorithm 3: Newsort

    for(int alg=0; alg<3; alg++) { // For each algorithm
      for(int test=0; test<6; test++) { // For each test
        Sort sortTest; // Initialize sort
        if(test<3) sortTest = new Sort(50); // First 3 tests are 50 long
        else sortTest = new Sort(1000); // Last 3 tests are 1000 long
        sortTest.readIn("src/app/test" + (test+1) + ".txt"); // Read in the test
        if(test==0) { // For the first test print the necessary info
          System.out.println("\n\n-======================[Algorithm " + (alg+1) + "]======================-");
          sortTest.display(15, "Unsorted:");
        }
        sortTest.sort(alg); // Sort for the right algorithm, see sort
        testResults[alg][test] = sortTest.comp; // Removed unnecasary compIS etc. and reduced to one variable
        if(test==0) sortTest.display(15, "Sorted:");
      }
    }
    System.out.format("\n\n%10s |%10s |%10s |%10s\n", "Test", "Insertion", "Quicksort", "Newsort"); // Print table
    for(int i=0; i<6; i++)
      System.out.format("%10s |%10d |%10d |%10d\n", "test" + (i+1) + ".txt", testResults[0][i], testResults[1][i], testResults[2][i]);
  }

} /** End of TestSort class **/
