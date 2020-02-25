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
 	  	
                              Insert     Selection     MergeRecursive     MergeIterative     Quick 
   10 random                       0ms          0ms            0ms            0ms             0ms
   100 random                      0ms          0ms            0ms            3ms             1ms
   1000 random                     6ms          2ms            0ms            513ms             1ms
   1000 few unique                 1ms          0ms            0ms            505ms             1ms
   1000 nearly ordered             1ms          0ms            0ms            437ms             0ms
   1000 reverse order              1ms          0ms            0ms            501ms             0ms
   1000 sorted                     0ms          1ms            0ms            506ms             0ms

 */

/*
 * 
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 *      MergeIterative, because the results of this algorithm are more various than those of others.
 * b. Which algorithm has the biggest difference between the best and worst performance, based on the type of input, for the input of size 1000? Why?
 *      insertion sort, best for "1000sorted" and worst for "1000 random"
 *      This is because insertion sort need not to inverse all elements of the array if several parts of the array are already sorted. 
 * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time based on the input size? Please consider only input files with random order for this answer.
 *      The best is mergeRecursive and the worst is mergeIterative
 * d. Did you observe any difference between iterative and recursive implementations of merge sort?
 *      MergeSortRecursive uses one more function to merge the array at first, comparing to mergeIterative
 * e. Which algorithm is the fastest for each of the 7 input files?
 *      QuickSort
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
    	double[] numbers = {7.0,2.0,3.0,5.0,4.0};
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
    	SortComparison sort = new SortComparison();
        try {
    		
        	String[][] result = new String [8][6];
        	result[0][0] ="                      ";
        	result[1][0] ="10 random             ";
        	result[2][0] ="100 random            ";
        	result[3][0] ="1000 random           ";
        	result[4][0] ="1000 few unique       ";
        	result[5][0] ="1000 nearly ordered   ";
        	result[6][0] ="1000 reverse order    ";
        	result[7][0] ="1000 sorted           ";
        	result[0][1] =" Insert ";
        	result[0][2] =" Selection ";
        	result[0][3] =" MergeRecursive ";
        	result[0][4] =" MergeIterative ";
        	result[0][5] =" Quick ";
        	//result[0][6] =" Quick ";
        	
        	
        	
        	//todo: do experiments as per assignment instructions
        	long startTime,endTime;
        	double []tmp;
        	int count;
        	
        	//10 random
        	double []num10 = new double[10]; 
        	FileReader fileReader = new FileReader("numbers10.txt");// Enter the entire path of the file if needed
    		BufferedReader bufferedReader = new BufferedReader(fileReader); 
    		boolean endOfFile = false;
    		count=0;
    		while(!endOfFile&&count<10)
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
            	num10[count] = Double.parseDouble(wordLine);
            	count++;
            }
    		
    		startTime = System.currentTimeMillis();
        	tmp = sort.insertionSort(num10);
        	endTime = System.currentTimeMillis();
        	result[1][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.selectionSort(num10);
        	endTime = System.currentTimeMillis();
        	result[1][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortRecursive(num10);
        	endTime = System.currentTimeMillis();
        	result[1][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortIterative(num10);
        	endTime = System.currentTimeMillis();
        	result[1][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.quickSort(num10);
        	endTime = System.currentTimeMillis();
        	result[1][5] ="          "+(endTime - startTime)+"ms";
        	
        	//100 random
        	double []num100 = new double[100]; 
        	fileReader = new FileReader("numbers100.txt");// Enter the entire path of the file if needed
    		bufferedReader = new BufferedReader(fileReader); 
    		endOfFile = false;
    		count=0;
    		while(!endOfFile&&count<100)
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
            	num100[count] = Double.parseDouble(wordLine);
            	count++;
            }
    		
    		startTime = System.currentTimeMillis();
        	tmp = sort.insertionSort(num100);
        	endTime = System.currentTimeMillis();
        	result[2][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.selectionSort(num100);
        	endTime = System.currentTimeMillis();
        	result[2][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortRecursive(num100);
        	endTime = System.currentTimeMillis();
        	result[2][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortIterative(num100);
        	endTime = System.currentTimeMillis();
        	result[2][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.quickSort(num100);
        	endTime = System.currentTimeMillis();
        	result[2][5] ="          "+(endTime - startTime)+"ms";
        	
        	
        	//1000 random
        	double []num1000 = new double[1000]; 
        	fileReader = new FileReader("numbers1000.txt");// Enter the entire path of the file if needed
    		bufferedReader = new BufferedReader(fileReader); 
    		endOfFile = false;
    		count=0;
    		while(!endOfFile&&count<1000)
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
            	num1000[count] = Double.parseDouble(wordLine);
            	count++;
            }
    		
    		startTime = System.currentTimeMillis();
        	tmp = sort.insertionSort(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.selectionSort(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortRecursive(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp =sort.mergeSortIterative(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.quickSort(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][5] ="          "+(endTime - startTime)+"ms";
        	
        	
        	//1000 few unique
        	double []num1000fu = new double[1000]; 
        	fileReader = new FileReader("numbers1000Duplicates.txt");// Enter the entire path of the file if needed
    		bufferedReader = new BufferedReader(fileReader); 
    		endOfFile = false;
    		count=0;
    		while(!endOfFile&&count<1000)
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
            	num1000fu[count] = Double.parseDouble(wordLine);
            	count++;
            }
    		
    		startTime = System.currentTimeMillis();
        	tmp = sort.insertionSort(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.selectionSort(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortRecursive(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortIterative(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.quickSort(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][5] ="          "+(endTime - startTime)+"ms";
        	
        	
        	
        	//1000 nearly ordered
        	double []num1000no = new double[1000]; 
        	fileReader = new FileReader("numbersNearlyOrdered1000.txt");// Enter the entire path of the file if needed
    		bufferedReader = new BufferedReader(fileReader); 
    		endOfFile = false;
    		count=0;
    		while(!endOfFile&&count<1000)
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
            	num1000no[count] = Double.parseDouble(wordLine);
            	count++;
            }
    		
    		startTime = System.currentTimeMillis();
        	tmp = sort.insertionSort(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.selectionSort(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortRecursive(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortIterative(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.quickSort(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][5] ="          "+(endTime - startTime)+"ms";
        	
        	
        	
        	
        	
        	//1000 reverse ordered
        	double []num1000ro = new double[1000]; 
        	fileReader = new FileReader("numbersReverse1000.txt");// Enter the entire path of the file if needed
    		bufferedReader = new BufferedReader(fileReader); 
    		endOfFile = false;
    		count=0;
    		while(!endOfFile&&count<1000)
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
            	num1000ro[count] = Double.parseDouble(wordLine);
            	count++;
            }
    		
    		startTime = System.currentTimeMillis();
        	tmp = sort.insertionSort(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.selectionSort(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortRecursive(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortIterative(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.quickSort(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][5] ="          "+(endTime - startTime)+"ms";
        	
        	
        	
        	
        	
        	
        	
        	//1000 sorted ordered
        	double []num1000so = new double[1000]; 
        	fileReader = new FileReader("numbersSorted1000.txt");// Enter the entire path of the file if needed
    		bufferedReader = new BufferedReader(fileReader); 
    		endOfFile = false;
    		count=0;
    		while(!endOfFile&&count<1000)
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
            	num1000so[count] = Double.parseDouble(wordLine);
            	count++;
            }
    		
    		startTime = System.currentTimeMillis();
        	tmp = sort.insertionSort(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.selectionSort(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortRecursive(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.mergeSortIterative(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = sort.quickSort(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][5] ="          "+(endTime - startTime)+"ms";
        	
        	
        	
        	for(int i=0;i<result.length;i++) {
        		for(int j=0;j<result[i].length;j++) {
        			if(result[i][j]==null) {
        				if(j==5) System.out.println("");
        				else System.out.print("");
        			}
        			else {
        				if(j==5) System.out.println("   "+result[i][j]);
        				else System.out.print("   "+result[i][j]);
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
    }

    

}
