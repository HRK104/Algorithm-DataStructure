// -------------------------------------------------------------------------

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author
 *  @version HT 2020
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	
    	if(a.length==0) return null;
        //todo: implement the sort
    	double tmp;
		for(int i=1;i<a.length;i++) {
			for(int j=i;j>0;j--) {
				if(a[j]<a[j-1]) {
					tmp = a[j-1];
					a[j-1]=a[j];
					a[j] = tmp;
				}
			}
		}
		return a;
    }//end insertionsort
	
	    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

    	if(a.length==0) return null;
         //todo: implement the sort
        int n= a.length;
		
		for(int i=0;i<n-1;i++) {
			
			int min_index =i;
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[min_index]) min_index = j;
			}
			
			double temp = a[i];
			a[i] = a[min_index];
			a[min_index] = temp;
		}
		return a;
    }//end selectionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
    	if(a.length==0) return null;
		 //todo: implement the sort
    	partition(a,0,a.length-1);
    	return a;

    }//end quicksort
    
    static void partition(double[] numbers, int lo, int hi) {
    	int i = lo;
    	int j = hi+1;
    	double pivot = numbers[lo];
    	
    	while(true) {
    		while((numbers[++i]<(pivot)  )) {
    			if(i == hi) break;
    			}
    		while((pivot<(numbers[--j]) )) {
    			if(j == lo) break;
    			}
    		if(i >= j) break;
    		double temp = numbers[i];
    		numbers[i] = numbers[j];
    		numbers[j] = temp;
    	}
    	numbers[lo] = numbers[j];
    	numbers[j] = pivot;
    	//return j;
    }
    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

    	if(a.length==0) return null;
		 //todo: implement the sort
    	int N = a.length;
    	double [] aux = new double[N];
    	for(int sz =1;sz<N;sz++) {
    		for(int lo=0;lo<N-1;lo++) {
    			merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    		}
    	}
    	return a;
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	if(a.length==0) return null;
    	double [] aux = new double[a.length];
    	sortRecursive(a,aux,0,a.length-1);
    	return a;
    	//todo: implement the sort
	
   }//end mergeSortRecursive
    	
    static void sortRecursive(double[]a, double[] aux, int lo, int hi) {
    	if(hi<=lo) return;
    	int mid = lo +(hi-lo)/2;
    	sortRecursive(a,aux,lo,mid);
    	sortRecursive(a,aux,mid+1,hi);
    	merge(a,aux,lo,mid,hi);
    }
    
    public static void merge(double[]a, double[] aux, int lo, int mid, int hi) {
    	for(int k=lo;k<=hi;k++) aux[k] = a[k];
    	
    	int i=lo, j=mid+1;
    	for(int k=lo;k<=hi;k++) {
    		if(i>mid) a[k] = aux[j++];
    		else if(j>hi) a[k] = aux[i++];
    		else if(aux[j]<aux[i]) a[k] = aux[j++];
    		else a[k] = aux[i++];
    	}
    }

   public static String toString(double[]a) {
	   return Arrays.toString(a);
   }

    public static void main(String[] args) {

    	
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
        	tmp = insertionSort(num10);
        	endTime = System.currentTimeMillis();
        	result[1][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = selectionSort(num10);
        	endTime = System.currentTimeMillis();
        	result[1][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortRecursive(num10);
        	endTime = System.currentTimeMillis();
        	result[1][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortIterative(num10);
        	endTime = System.currentTimeMillis();
        	result[1][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = quickSort(num10);
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
        	tmp = insertionSort(num100);
        	endTime = System.currentTimeMillis();
        	result[2][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = selectionSort(num100);
        	endTime = System.currentTimeMillis();
        	result[2][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortRecursive(num100);
        	endTime = System.currentTimeMillis();
        	result[2][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortIterative(num100);
        	endTime = System.currentTimeMillis();
        	result[2][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = quickSort(num100);
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
        	tmp = insertionSort(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = selectionSort(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortRecursive(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortIterative(num1000);
        	endTime = System.currentTimeMillis();
        	result[3][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = quickSort(num1000);
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
        	tmp = insertionSort(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = selectionSort(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortRecursive(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortIterative(num1000fu);
        	endTime = System.currentTimeMillis();
        	result[4][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = quickSort(num1000fu);
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
        	tmp = insertionSort(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = selectionSort(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortRecursive(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortIterative(num1000no);
        	endTime = System.currentTimeMillis();
        	result[5][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = quickSort(num1000no);
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
        	tmp = insertionSort(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = selectionSort(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortRecursive(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortIterative(num1000ro);
        	endTime = System.currentTimeMillis();
        	result[6][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = quickSort(num1000ro);
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
        	tmp = insertionSort(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][1] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = selectionSort(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][2] ="       "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortRecursive(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][3] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = mergeSortIterative(num1000so);
        	endTime = System.currentTimeMillis();
        	result[7][4] ="         "+(endTime - startTime)+"ms";
        	
        	startTime = System.currentTimeMillis();
        	tmp = quickSort(num1000so);
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

 }//end class
