

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;

import java.util.Scanner;


/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {

    public Digraph graph;
    public int minSpeed;
    public double maxPath;
    public String filename;
    public int sA;
    public int sB;
    public int sC;


    CompetitionDijkstra(String filename, int sA, int sB, int sC) {

        try{

            this.filename = filename;
            File file = new File(filename);
            Scanner in = new Scanner(file);

            this.graph = new Digraph(in);
            this.filename = filename;
            
            this.sA = sA;
            this.sB = sB;
            this.sC = sC;
            
            minSpeed = 0;

            this.minSpeed = Math.min(Math.min(sA,sB),sC);
            

            this.maxPath = 0.0;

        } catch (FileNotFoundException | NullPointerException e){
            this.graph = null;
            this.filename = null;
        }


        if(this.graph != null && this.graph.getValid()){


            for(int i = 0; i < graph.V(); i++) {

                DijkstraSP sp = new DijkstraSP(graph, i);

                for(int j = 0; j < graph.V(); j++) {
                    if(sp.hasPathTo(j)) {
                        if(this.maxPath < sp.distTo(j)) this.maxPath = sp.distTo(j);
                        
                    }
                }
            }
        }
    }


    public int timeRequiredforCompetition() {

        if(this.maxPath <= 0.0 || this.minSpeed <= 0 || this.filename == null || this.minSpeed < 50 ) return -1;
        if(sA>100 || sB >100 || sC>100 || sA<50 || sB<50 || sC<50) return -1;

        double time = (1000*this.maxPath)/this.minSpeed;
        return (int) Math.ceil(time);
    }
}