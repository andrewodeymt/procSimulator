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
    
    int m, n = 0;
    float avgProcTime = 0;
    int size = 2;
    int minPrTime = 1;
    int maxPrTime = 500;
    int minArrTime = 1;
    int maxArrTime = 1000;
    int[] procTime = new int[size];
    int[] arrTime = new int[size];
    Random r  = new Random();
    int gid;
    int procCount;
    float totalProcTime1, totalProcTime2 = 0;
    
   private float proc1(int arrTime, int procTime, int i)
   {
       totalProcTime1 = (totalProcTime1+(procTime+arrTime));
       
       System.out.println("Proc 1 Start Time: "+arrTime+", End Time: "+procTime);
       System.out.println("Total Processing time for Processor 1 in millieconds: "+totalProcTime1);
       return totalProcTime1;
   }
   
   private float proc2(int arrTime, int procTime, int i)
   {
       totalProcTime2 = (totalProcTime2+ (procTime+arrTime));
              
       System.out.println("Proc 2 Start Time: "+arrTime+", End Time: "+procTime);
       System.out.println("Total Processing time for Processor 2 in millieconds: "+totalProcTime2);
       return totalProcTime2;
   }    
    
   //Constructor
   public ProcSimulator()
   {    
       //intro
       System.out.println("Please enter your GID: ");

       //scanner for user input
       Scanner sc  = new Scanner(System.in);
       gid = sc.nextInt();
       procCount = ((gid%3)+2);
   
       System.out.println(procCount);
   
       //creating array of random nums
       for(int i = 0; i < procTime.length; i++)
       {
           procTime[i]  = (int) (Math.random()*(maxPrTime - minPrTime)) + minPrTime;
       }
       //Arrays.sort(procTime);
       //System.out.println(Arrays.toString(procTime));
       
       for(int j = 0; j < arrTime.length; j++)
       {
           arrTime[j] = j + 1;
       }
       //System.out.println(Arrays.toString(arrTime));    
       
       for(int i = 0; i <= 10; i++)
       {
            for(int x = 0; x < arrTime.length; x++)
            {
                if(x%2 == 0)
                {
                    proc1(arrTime[x], procTime[x], x);
                }
                else{
                    proc2(arrTime[x], procTime[x], x);
                }
            }
            
            totalProcTime1 = totalProcTime1 / 100;
            totalProcTime2 = totalProcTime2 / 100;
            avgProcTime = totalProcTime1 + totalProcTime2;
        }
        System.out.println("Average processing time on 100 times: "+avgProcTime);
    }
}
