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

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() throws FileNotFoundException    {

    	String filename = "input-B.txt";
    	int sA = 60;
    	int sB = 80;
    	int sC = 50;
    	CompetitionDijkstra tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	int ans = tmp.timeRequiredforCompetition();
    	System.out.println("first experiment");
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	System.out.println("minSpeed: "+tmp.minSpeed);
    	//assertEquals("Result: ",38,ans);
    	
    	System.out.println("test input-M");
    	filename = "input-M.txt";
    	sA = 81;
        sB = 70;
    	sC = 61;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	
    	filename = "input-D.txt";
    	sA = 50;
        sB = 80;
    	sC = 60;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	
    	
    	filename = "input-I.txt";
    	sA = 72;
        sB = 70;
    	sC = 65;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	
    	
    	filename = "tinyEWD.txt";
    	sA = 70;
        sB = 70;
    	sC = 70;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	
    	
    	System.out.println("when the speed is over 100");
    	filename = "tinyEWD.txt";
    	sA = 120;
        sB = 270;
    	sC = 100;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	
    	//assertEquals("Result: ",27,ans);
    	
    	filename = "test1.txt";
    	sA = 50;
        sB = 60;
    	sC = 70;
    	tmp = new CompetitionDijkstra(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	//assertEquals("Result: ",3660,ans);
    	
    	System.out.println("CompetitionDijkstra d = new CompetitionDijkstra(null, -1, -1, -1);");
    	CompetitionDijkstra d = new CompetitionDijkstra(null, -1, -1, -1);
    	ans = d.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	//assertEquals("result:", -1, ans);
    	
    	System.out.println("d = new CompetitionDijkstra(\"\", -1, -1, -1);");
    	d = new CompetitionDijkstra("", -1, -1, -1);
    	ans = d.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	//assertEquals("result:", -1, ans);
    	
    	System.out.println("d = new CompetitionDijkstra(\"\", -1, -1, -1);");
    	d = new CompetitionDijkstra("tinyEWD.txt", -1, -1, -1);
    	ans = d.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	//assertEquals("result:", -1, ans);
    }

    @Test
    public void testFWConstructor() throws FileNotFoundException  {
//        //TODO
    	System.out.println("");
    	System.out.println("");
    	System.out.println("start testFWConstructor");
    	String filename = "input-B.txt";
    	int sA = 60;
    	int sB = 80;
    	int sC = 50;
    	CompetitionFloydWarshall tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	int ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	System.out.println("minSpeed: "+tmp.minSpeed);
    	//assertEquals("Result: ",27,ans);
    	
    	
    	System.out.println("test input-M");
    	filename = "input-M.txt";
    	sA = 81;
        sB = 70;
    	sC = 61;
    	tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	//assertEquals("Result: ",27,ans);
    	
    	
    	
    	filename = "input-I.txt";
    	sA = 72;
        sB = 70;
    	sC = 65;
    	tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	//assertEquals("Result: ",27,ans);
    	
    	filename = "input-D.txt";
    	sA = 50;
        sB = 80;
    	sC = 60;
    	tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	
    	
    	sA = 70;
        sB = 70;
    	sC = 70;
    	tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	
    	 filename = "test1.txt";
    	 sA = 50;
         sB = 60;
    	 sC = 70;
    	 tmp = new CompetitionFloydWarshall(filename, sA, sB, sC);
    	 ans = tmp.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	//assertEquals("Result: ",2615,ans);
    	
    	
    	CompetitionFloydWarshall d = new CompetitionFloydWarshall(null, -1, -1, -1);
    	ans = d.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("result:", -1, ans);
    	
    	System.out.println("d = new CompetitionFloydWarshall(\"\", -1, -1, -1)");
    	d = new CompetitionFloydWarshall("", -1, -1, -1);
    	ans = d.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("result:", -1, ans);
    	
    	d = new CompetitionFloydWarshall("tinyEWD.txt", -1, -1, -1);
    	ans = d.timeRequiredforCompetition();
    	System.out.println("time: "+ans);
    	System.out.println("maxPath: "+tmp.maxPath);
    	assertEquals("result:", -1, ans);
    }

    //TODO - more tests
    
}