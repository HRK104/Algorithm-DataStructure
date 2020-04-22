/*
 *  the differences between their implementation and performance
 *  
 *  "V" is the number of vertices
 *  "E" is the number of edges.
 *  Dijkstra:
 *   This programs implement minimum priority queue to determine the whether the cost of a node is calculated or not.
 *   The performance is O(V^2) without minimum priority queue and 0(E + VlogV) by the use of minimum priority queue.
 *  
 *  FloydWarshall:
 *   This program implements 2D array to store the data into the table.
 *   In terms of performance, it needs O(V^3) spaces
 *    
 */

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() throws IOException {

        //TODO
    	String filename = "1000EWD.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 70;
    	CompetitionDijkstra tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	int ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("Result: ",28,ans);
    	
    	filename = "tinyEWD.txt";
    	sA = 70;
        sB = 70;
    	sC = 70;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("Result: ",27,ans);
    	
    	filename = "test1.txt";
    	sA = 50;
        sB = 60;
    	sC = 70;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("Result: ",3660,ans);
    	
    	 
    }

    @Test
    public void testFWConstructor() throws IOException {
        //TODO
    	String filename = "tinyEWD.txt";
    	int sA = 50;
    	int sB = 60;
    	int sC = 70;
    	CompetitionFloydWarshall tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	int ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("Result: ",38,ans);
    	
    	sA = 70;
        sB = 70;
    	sC = 70;
    	tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("Result: ",27,ans);
    	
    	 filename = "test1.txt";
    	 sA = 50;
         sB = 60;
    	 sC = 70;
    	 tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	 ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("Result: ",3660,ans);
    }

    //TODO - more tests
    
}