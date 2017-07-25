package numberTheory;

import java.util.Scanner;
/**
 * Number theory :Chinese remainder theorem 
 * @author Dahlia Chehata
 *
 */
public class ChineseRemainderTheorem {
	/**
	 * convert A to a1,a2,a3,....ak 
	 * @param num
	 * @param A
	 * @param k
	 * @return
	 */
	public static int []CRTMapping (int num[],int A,int k) {
		int [] res= new int [k];
		 for (int i=0;i<k;i++) {
			 res[i]=A % num[i];
		 }
		return res;	
	}
	/**
	 * convert a1,a2,a3,....ak to A
	 * @param num
	 * @param rem
	 * @param k
	 * @return
	 */
	public static int ReverseCRTMapping(int num[], int rem[], int k)
	{
	    // Compute product of all numbers
	    int prod = 1;
	    for (int i = 0; i < k; i++)
	        prod *= num[i]; //M
	 
	    // Initialize result
	    int result = 0;
	 
	    // Apply above formula
	    for (int i = 0; i < k; i++)
	    {
	        int pp = prod / num[i];
	        if (ExtendedEuclideanAlgorithm.modInverse (pp, num[i])!=-1)
	        result += rem[i] * ExtendedEuclideanAlgorithm.modInverse (pp, num[i]) * pp;
	    }
	 
	    return result % prod;
	}
	/**
	 * Drive Program
	 * @param args
	 */
	public static  void main(String[]args)
	{
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number k");
		int k=sc.nextInt();
		System.out.println("Enter m1,m2,m3....mk");
		int num[] =new int [k];
        for (int i=0;i<k;i++) {
        	num[i]=sc.nextInt();
        }
		       int A,B,M = 1;
        
        		System.out.println("Enter a1,a2,a3....ak to calculate A:");
        		int remA[] =new int[k];
        		for (int i=0;i<k;i++)
        			remA[i]=sc.nextInt();
        		System.out.println("Enter b1,b2,b3....bk to calculate B:");
        		int remB[] =new int[k];
        		for (int i=0;i<k;i++)
        			remB[i]=sc.nextInt();
        		
        		long s1=System.nanoTime();
        		
        	    A= ReverseCRTMapping(num,remA,k);
        		System.out.println("A =" + A );
        		
        		B=ReverseCRTMapping(num,remB,k);
        		System.out.println("B =" + B);
        		
        		
        		 for (int i = 0; i < k; i++)
     		        M*= num[i]; 
        		 
                System.out.println("A+B mod n =");
                
                System.out.println("first method :"+(( A+B )% M));
                long t1=System.nanoTime();
                System.out.println("Execution time :"+(t1-s1)+" nanoseconds");
                
                long s2=System.nanoTime();
                int []remSol=new int[k];
                for (int i=0;i<k;i++) {
                	remSol[i]=((remA[i]+remB[i])% num[i]);
                }
                System.out.println("Second method :"+ReverseCRTMapping(num,remSol,k));
                long t2=System.nanoTime();
                System.out.println("Execution time :"+(t2-s2)+" nanoseconds");

        
	}
}
