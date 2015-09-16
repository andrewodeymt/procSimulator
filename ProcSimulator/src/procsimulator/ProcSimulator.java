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
    
    float min,max = 0;
    float avgProcTime, avgProcTime1, avgProcTime2 = 0;
    int m, n = 0;
    int size = 1000;
    int minPrTime = 1;
    int maxPrTime = 500;
    int minArrTime = 1;
    int maxArrTime = 1000;
    int[] procTime = new int[size];
    int[] arrTime = new int[size];
    float[] tpt1 = new float[size];
    float[] tpt2 = new float[size];
    Random r  = new Random();
    int gid;
    int procCount;
    float totalProcTime1, totalProcTime2 = 0;
    float avp1, avp2 = 0;
    
   private void proc1(int arrTime, int procTime, int i)
   {
       totalProcTime1 = (procTime+arrTime);
       
       //System.out.println("Proc 1 Start Time: "+arrTime+", End Time: "+procTime);
       //System.out.println("Total Processing time for Processor 1 in millieconds: "+totalProcTime1);
       tpt1[i] = totalProcTime1;
   }
   
   private void proc2(int arrTime, int procTime, int i)
   {
       totalProcTime2 = (procTime+arrTime);
              
       //System.out.println("Proc 2 Start Time: "+arrTime+", End Time: "+procTime);
       //System.out.println("Total Processing time for Processor 2 in millieconds: "+totalProcTime2);
       tpt2[i] = totalProcTime2;
       //System.out.println(Arrays.toString(tpt2));
   }    
   
   private void buildArrays()
   {
       //creating array of random nums
       for(int i = 0; i < procTime.length; i++)
       {
           procTime[i]  = (int) (Math.random()*(maxPrTime - minPrTime)) + minPrTime;
           Arrays.sort(procTime);
           /*
           procTime[0] = 9;
           procTime[1] = 2;
           procTime[2] = 16;
           procTime[3] = 3; 
           procTime[4] = 29;
           procTime[5] = 198;
           procTime[6] = 7;
           procTime[7] = 170;
           procTime[8] = 180;   
           procTime[9] = 178;
           procTime[10] = 73;
           procTime[11] = 8;     
           */        
       }
       //Arrays.sort(procTime);
       //System.out.println(Arrays.toString(procTime));
       
       for(int j = 0; j < arrTime.length; j++)
       {
           arrTime[j] = j + 1;
           Arrays.sort(arrTime);
           /*
           arrTime[0] = 9;
           arrTime[1] = 2;
           arrTime[2] = 16;
           arrTime[3] = 3; 
           arrTime[4] = 29;
           arrTime[5] = 198;
           arrTime[6] = 7;
           arrTime[7] = 170;
           arrTime[8] = 180;   
           arrTime[9] = 178;
           arrTime[10] = 73;
           arrTime[11] = 8;
           */
       }
       //System.out.println(Arrays.toString(arrTime));    
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
          
       for(int i = 0; i <= 100; i++)
       {
            buildArrays();
            
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

            for(float l : tpt1)
            {
                avgProcTime1 += l;
            }
            
            for(float k : tpt2)
            {
                avgProcTime2 += k;
            }
            
            avp2 = avgProcTime1 / (i+1);
            avp1  = avgProcTime2 / (i+1);
            avgProcTime = ((avp1 + avp2)+i)/200000;
            
            Arrays.sort(tpt1);
            Arrays.sort(tpt2);
            
            min = tpt1[0]+tpt2[0];
            max = tpt1[tpt1.length-1]+tpt2[tpt2.length-1];
        }
        System.out.println("min value: "+min);
        System.out.println("max value: "+max);
        System.out.println("Average processing time on 100 times: "+avgProcTime);
    }
}
