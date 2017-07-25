package numberTheory;

import java.util.Scanner;
/**
 * Extended Euclidean Algorithm to calculate modular multiplicative inverse 
 * @author select
 *
 */
public class ExtendedEuclideanAlgorithm {
	
	/**
	 * Function to find modulo inverse of a
	 * @param a
	 * @param m
	 * @return
	 */
	public static int modInverse(int a, int m)
	{
	    int []sol= ExtendedEuclid(a,m);
	    int g =sol[0];
	    if (g == 1) {
	        // m is added to handle negative x
	         return (sol[2]%m + m) % m;
	    }
		return -1;
	}
	 /**
	  * This function will perform the Extended Euclidean algorithm
        to find the GCD of a and b.  We assume here that a and b
        are non-negative (and not both zero).  This function also
        will return numbers j and k such that 
               d = j*a + k*b
        where d is the GCD of a and b.
	  * @param a
	  * @param b
	  * @return
	  */
	public static int[] ExtendedEuclid(int a, int b)
    { 
        int[] ans = new int[3];

        if (a == 0)  {  /*  If a = 0, then we're done...  */
            ans[0] = b; //b
            ans[1] = 1; //y
            ans[2] = 0; //x
        }
        else
            {     /*  Otherwise, make a recursive function call  */ 
               ans = ExtendedEuclid (b%a, a);
               int temp = ans[1] - ans[2]*(b/a);
               ans[1] = ans[2];
               ans[2] = temp;
            }

        return ans;
    }
	 
	/**
	 * Driver Program
	 * @param args
	 */
	public static  void main(String[]args)
	{
	    while (true) {
		int a ,m;
	    @SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
	    System.out.println(" Enter a and m respectively to calculate the modular "
	    		+ "multiplicative inverse of a mod m" );
	    a=sc.nextInt();
	    m=sc.nextInt();
	    if (modInverse(a, m)==-1)
        System.out.println("Inverse doesn't exist"); 
	    else 
	    	System.out.println( "Modular multiplicative inverse is " + modInverse(a, m));
	    System.out.println();
	}
	}
}
