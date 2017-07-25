package numberTheory;

import java.math.BigInteger;
import java.util.Scanner;
 /**
  * calculate pow (a,b) mod n 
  * @author select
  *
  */
public class AexpBmodN {
     /**
      * first method 
      * @param a
      * @param b
      * @param n
      * @return
      */
	static BigInteger modulo1(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger sol=BigInteger.ONE;
		for (BigInteger i=BigInteger.ONE;i.compareTo(b)<=0
				; i = i.add(BigInteger.ONE)) {
			sol=sol.multiply(a);
		}
		sol=sol.mod(n);
		return sol;

	}
    /**
     * second method
     * @param a
     * @param b
     * @param n
     * @return
     */
	static BigInteger modulo2(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger sol=BigInteger.ONE;
		for (BigInteger i=BigInteger.ONE;i.compareTo(b)<=0
				; i = i.add(BigInteger.ONE)) {
			sol=sol.multiply(a);
			sol=sol.mod(n);
		}
		return sol;

	}
	static BigInteger mulmod (BigInteger a, BigInteger b, BigInteger n)
	{
		BigInteger x=BigInteger.ZERO;
		BigInteger y=a.mod(n);
	    while(b.compareTo(BigInteger.ZERO) > 0){
	        if(b.mod(BigInteger.valueOf(2)) .equals(BigInteger.ONE) ) 
	        	x = (x.add(y)).mod(n);
	        y = (y.multiply(BigInteger.valueOf(2))).mod(n);
	        b =b.divide(BigInteger.valueOf(2));
	    }
	    return x.mod(n);
	}
	/**
	 * third method
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	static BigInteger modulo3(BigInteger a, BigInteger b, BigInteger n) {
		BigInteger x=BigInteger.ONE,y=a;

		    while(b.compareTo(BigInteger.ZERO) > 0)
		    {
		        if (b.mod(BigInteger.valueOf(2)) .equals(BigInteger.ONE)) 
		        	x=mulmod(x,y,n);
		        y=mulmod(y,y,n);
		        b =b.divide(BigInteger.valueOf(2));		    }
		    return x.mod(n);		

	}

	public static void main(String[] args) {
		while (true)  {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a,b,n respectively to calculate (a exponential b) mod n");
		BigInteger a = sc.nextBigInteger();
		BigInteger b = sc.nextBigInteger();
		BigInteger n = sc.nextBigInteger();
		/**
		 * 
		 */
		long startTime1 = System.nanoTime();
		System.out.println( "The answer is :"+modulo1(a, b, n));
		long stopTime1 = System.nanoTime();
		System.out.println("Execution time for first method 1 in nanoseconds is : " +
		(stopTime1 - startTime1));
		/**
		 * 
		 */
		long startTime2 = System.nanoTime();
		System.out.println("The answer is :"+modulo2(a, b, n));
		long stopTime2 = System.nanoTime();
		System.out.println("Execution time for first method 2 in nanoseconds is : " +
				(stopTime2 - startTime2));
		/**
		 * 
		 */
		long startTime3 = System.nanoTime();
		System.out.println("The answer is :"+modulo3(a, b, n));
		long stopTime3 = System.nanoTime();
		System.out.println("Execution time for first method 3 in nanoseconds is : " +
				(stopTime3 - startTime3));
		System.out.println();
	}
	}
}
