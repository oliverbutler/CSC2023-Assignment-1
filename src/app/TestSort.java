
/*************************************************/
/***  Simple test class for Sort class         ***/
/***                                           ***/
/***  Author: Jason Steggles    20/09/2019     ***/
/*************************************************/


public class TestSort
{
	public static void main(String[] args) 
    {
        Sort sortTest = new Sort(50);
        
        /** Some simple tests using class Sort **/
        
        /** Display two comparison counters **/
        System.out.println("\n\nInsertion sort comparison counter: " + sortTest.compIS);
        System.out.println("Quicksort comparison counter: " + sortTest.compQS);
        
        /** Read in test data into array **/
        sortTest.readIn("src/app/test1.txt");
        
        /** Display array **/
        sortTest.display(15,"Values in test1.txt");

        sortTest.insertion();
        sortTest.display(15, "Insertion sorted");

        
    }
    
} /** End of TestSort class **/
