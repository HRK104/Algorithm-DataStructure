

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;


/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestantsâ€™
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ï‚· Each contestant walks at a given estimated speed.
 *    ï‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */


public class CompetitionFloydWarshall{

    public  Digraph graph;
    public int minSpeed;
    public double maxPath;
    public String filename;
    public int sA;
    public int sB;
    public int sC;


    CompetitionFloydWarshall (String filename, int sA, int sB, int sC){
        try{

        	this.filename = filename;
            File file = new File(filename);
            Scanner in = new Scanner(file);

            this.graph = new Digraph(in);
            this.filename = filename;
            
            minSpeed = 0;
//            if(sA>0) minSpeed = sA;
//            if(sB>0 && sB<minSpeed) minSpeed = sB;
//            if(sC>0 && sC>minSpeed) minSpeed = sC;
            this.sA = sA;
            this.sB = sB;
            this.sC = sC;
            this.minSpeed = Math.min(Math.min(sA,sB),sC);
            

            this.maxPath = 0.0;

        } catch (FileNotFoundException | NullPointerException | UnsupportedOperationException e){

            this.filename = null;
            this.graph = null;
        }

        if(/*this.shortestPaths != null &&*/ this.graph != null &&this.graph.getValid() /*&& !this.shortestPaths.hasNegativeCycle*/){


            for (int v = 0; v < this.graph.V(); v++) {
            	FloydWarshallSP sp = new FloydWarshallSP(graph,v);
                for (int w = 0; w < sp.table.length; w++) {
                	for(int k=0; k< sp.table[w].length; k++) {
                		if(sp.table[w][k] > maxPath) maxPath = sp.table[w][k];
                	}

                }
            }
        }
        
        
        
        
        
        
        

        
        
        
    }


    public int timeRequiredforCompetition(){

    	if(sA>100 || sB >100 || sC>100 || sA<50 || sB<50 || sC<50) return -1;
    	if(this.maxPath <= 0.0 || this.minSpeed <= 0 || this.filename == null || this.minSpeed < 50 || this.minSpeed > 100) return -1;
        double time = (1000*this.maxPath)/this.minSpeed;
        return (int) Math.ceil(time);
    }
}