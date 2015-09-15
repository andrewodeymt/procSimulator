/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package procsimulator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author andy
 */

public class ProcSimulator {
    
    int size = 1000;
    int minPrTime = 1;
    int maxPrTime = 500;
    int minArrTime = 1;
    int maxArrTime = 1000;
    int[] procTime = new int[size];
    int[] arrTime = new int[size];
    int[][] processor = new int[size][size];
    Random r  = new Random();
    int gid;
    int procCount;
    int totalProcTime = 0;
    
    //Constructor
    public ProcSimulator(){
               
        //intro
        System.out.println("Please enter your GID: ");

        //scanner for user input
        Scanner sc  = new Scanner(System.in);
        int gid = sc.nextInt();
        int procCount = ((gid%3)+2);
    
        System.out.println(procCount);
    
        //creating array of random nums
        for(int i = 0; i < procTime.length; i++)
        {
            procTime[i]  = (int) (Math.random()*(maxPrTime - minPrTime)) + minPrTime;
            totalProcTime = totalProcTime + i;
        }
        //Arrays.sort(procTime);
        //System.out.println(Arrays.toString(procTime));
        
        for(int j = 0; j < arrTime.length; j++)
        {
            arrTime[j] = j + 1;
        }
        System.out.println(Arrays.toString(arrTime));    
        
        
    }
    
}