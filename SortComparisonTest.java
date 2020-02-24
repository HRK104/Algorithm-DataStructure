//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//public class SortComparisonTest {
//
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
//
//}
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2020
 */



/*
 * 
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 *      MergeIterative, because the results of this algorithm are more various than those of others.
 * b. Which algorithm has the biggest difference between the best and worst performance, based on the type of input, for the input of size 1000? Why?
 *      
 * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time based on the input size? Please consider only input files with random order for this answer.
 * d. Did you observe any difference between iterative and recursive implementations of merge sort?
 * e. Which algorithm is the fastest for each of the 7 input files?
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] nums = new double[0];
    	assertEquals( "Checking sortComparison for emty array", null, new SortComparison().insertionSort(nums) );
    	assertEquals( "Checking sortComparison for emty array", null, new SortComparison().selectionSort(nums) );
    	assertEquals( "Checking sortComparison for emty array", null, new SortComparison().quickSort(nums) );
    	assertEquals( "Checking sortComparison for emty array", null, new SortComparison().mergeSortIterative(nums) );
    	assertEquals( "Checking sortComparison for emty array", null, new SortComparison().mergeSortRecursive(nums) );
    }

    
    @Test
    public void testSort() {
    	double[] numbers = {2.0,3.0,7.0,5.0,4.0};
    	SortComparison sort = new SortComparison();
    	assertEquals( "Checking insertionSort for {2.0,3.0,7.0,5.0,4.0}", "[2.0, 3.0, 4.0, 5.0, 7.0]", sort.toString(new SortComparison().insertionSort(numbers)) );
    	assertEquals( "Checking selectionSort for {2.0,3.0,7.0,5.0,4.0}", "[2.0, 3.0, 4.0, 5.0, 7.0]", sort.toString(new SortComparison().selectionSort(numbers))  );
    	assertEquals( "Checking quickSort for {2.0,3.0,7.0,5.0,4.0}", "[2.0, 3.0, 4.0, 5.0, 7.0]", sort.toString(new SortComparison().quickSort(numbers))  );
    	assertEquals( "Checking mergeSortIterative for {2.0,3.0,7.0,5.0,4.0}", "[2.0, 3.0, 4.0, 5.0, 7.0]", sort.toString(new SortComparison().mergeSortIterative(numbers))  );
    	assertEquals( "Checking mergeSortRecursive for {2.0,3.0,7.0,5.0,4.0}", "[2.0, 3.0, 4.0, 5.0, 7.0]", sort.toString(new SortComparison().mergeSortRecursive(numbers))  );
    }
    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args) 
    {
    	try {
    		//todo: do experiments as per assignment instructions
        	String[][] result = new String [8][6];
        	result[0][0] ="               ";
        	result[1][0] ="10 random";
        	result[2][0] ="100 random";
        	result[3][0] ="1000 random";
        	result[4][0] ="1000 few unique";
        	result[5][0] ="1000 nearly ordered";
        	result[6][0] ="1000 reverse order";
        	result[7][0] ="1000 sorted";
        	result[0][1] =" Quick ";
        	result[0][2] =" Insert ";
        	result[0][3] =" Selection ";
        	result[0][4] =" MergeRecursive ";
        	result[0][5] =" MergeIterative ";
        	result[0][6] =" Quick ";
        	
        	
        	FileReader fileReader = new FileReader("words.txt");// Enter the entire path of the file if needed
    		BufferedReader bufferedReader = new BufferedReader(fileReader); 
    		boolean endOfFile = false;
    		while(!endOfFile)
    		{
            	String wordLine = bufferedReader.readLine();
            	if (wordLine != null) 
            	{
            		endOfFile = false;
            	} 
            	else 
            	{
            		endOfFile = true;
            	}
            	result[1][1] = null;
            }
        	
        	
        	for(int i=0;i<result.length;i++) {
        		for(int j=0;j<result[i].length;j++) {
        			if(result[i][j]==null) {
        				if(j==6) System.out.println("");
        				else System.out.print("");
        			}
        			else {
        				if(j==6) System.out.println(result[i][j]);
        				else System.out.print(result[i][j]);
        			}
        		}
        	}
    	}
    	catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
        //TODO: implement this method
    }

    

}
