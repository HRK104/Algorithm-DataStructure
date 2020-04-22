import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//
//public class CompetitionDijkstra {
//
//}
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
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra {
	String filename;
	int sA;
	int sB;
	int sC;
	Digraph graph;
	int numOfStreets;
	double maxPath =0.0;
	int minSpeed;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     * @throws IOException 
    */
    CompetitionDijkstra (String filename, int sA, int sB, int sC) throws IOException{

       //TODO
    	this.filename = filename;
    	this.sA = sA;
    	this.sB = sB;
    	this.sC = sC;
    	
    	
    	Scanner sc2 = null;
        try {
            sc2 = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();  
        }
        Scanner s2 = new Scanner(sc2.nextLine());
        String s = s2.next(); // 1stline
        graph = new Digraph(Integer.parseInt(s));
        s2 = new Scanner(sc2.nextLine());
        s = s2.next(); // 2ndline
        numOfStreets = Integer.parseInt(s);
        while (sc2.hasNextLine()) { // 3rdline onwards
                s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String word1 = s2.next();
                String word2 = s2.next();
                String word3 = s2.next();
//                System.out.println("word1:"+word1);
//                System.out.println("word2:"+word2);
//                System.out.println("word3:"+word3);
                int head = Integer.parseInt(word1);
        		int tail = Integer.parseInt(word2);
        		double cost = Double.parseDouble(word3);
        		DirectEdge costGraph = new DirectEdge(head,tail,cost);
        		//DirectEdge costGraph = new DirectEdge(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Double.parseDouble(arr[2]));
        		graph.addEdge(costGraph);
            }
        }
    	
    	
    	
    	
    	
//    	File file = new File(" file path ");
//    	BufferedReader br = new BufferedReader(new FileReader(file));
//    	String str = br.readLine(); // 1st line
//    	graph = new Digraph(Integer.parseInt(str));
//    	str = br.readLine(); //2nd line
//    	numOfStreets = Integer.parseInt(str);
//    	str = br.readLine(); //3rd line onwards
//    	while(str != null){
//    	    //System.out.println(str);
//    		String[] arr = str.split(" ");
////    		System.out.println("Integer.parseInt(arr[0]): "+arr[0]);
////    		System.out.println("Integer.parseInt(arr[0]): "+arr[1]);
////    		System.out.println("Integer.parseInt(arr[0]): "+arr[2]);
//    		int head = Integer.parseInt(arr[0]);
//    		int tail = Integer.parseInt(arr[1]);
//    		double cost = Double.parseDouble(arr[2]);
//    		DirectEdge costGraph = new DirectEdge(head,tail,cost);
//    		//DirectEdge costGraph = new DirectEdge(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Double.parseDouble(arr[2]));
//    		graph.addEdge(costGraph);
//    	    str = br.readLine();
//    	}
//    	br.close();
    	
    	minSpeed = sA;
    	if(sB<minSpeed) minSpeed = sB;
    	if(sC<minSpeed) minSpeed = sC;
    }


    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition(){

        //TO DO
    	for(int i=0; i< graph.V(); i++) {
    		DijkstraSP sp = new DijkstraSP(graph,i);
    		
    		for(int j=0; j<graph.V();j++) {
    			if(sp.hasPathTo(j)) {
    				//System.out.println("sp.distTo(j): "+sp.distTo(j));
    				if(this.maxPath < sp.distTo(j)) this.maxPath = sp.distTo(j);
    			}
    		}
    	}
    	if(maxPath==0.0) return -1;
        return (int) Math.ceil(1000 * maxPath/minSpeed);
    }

}