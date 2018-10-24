package coreJava;

/**
 * Amit Dutt (SID:#29362614) 
 *COMP 352
 *Assignment #1
 *Due date: sept 28, 2018
 */

/*PURPOSE:   Testing the two versions of a recursion for a modified fibonacci("tribonacci" we named Oddonacci).
 * 			 Observing the timeframe difference between linear and binary recursion algorithms.
 *           
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Oddonacci {

    public static void main(String[] args) {

	PrintWriter outstr = null;
	PrintWriter outstr2 = null;

	File f1 = new File("out1.txt");
	File f2 = new File("out2.txt");
	File f3 = new File("observations.txt");

	try {

	    outstr = new PrintWriter(new FileOutputStream(f1)); // connect to
								// stream
	    outstr2 = new PrintWriter(new FileOutputStream(f2)); // connect to
								 // stream

	    // Run exponential Odonacci for sizes 5,10,15,20,15,.....until 100.
	    int y = 5;
	    long startTime = System.currentTimeMillis();
	    System.out.println("Start");
	    while (y <= 20) {

		System.out.println(exponentialOdonacci(y) + ", ");
		// outstr.print(exponentialOdonacci(y) + ", "); // run the
		// exponential
		// odonacci every 5
		// units of n size

		y += 5;

	    }
	    System.out.println("End");
	    long stopTime = System.currentTimeMillis();
	    outstr.println("\n the runtime for Expodonacci was: "
		    + ((stopTime - startTime) / 1000) + "sec \n"); // store
								   // measurement
								   // in output
								   // file

	    long duration1 = stopTime - startTime;

	    outstr.println();
	    outstr.println("THE DURATION WAS: " + duration1 + "ms" + "\n\n");
	    outstr.close();

	    // run a linear recursive odonacci for sizes
	    // 5,10,15,20,15,.....until 100
	    int z = 5;
	    startTime = System.currentTimeMillis();
	    while (z < 100) {
		long[] d = LinearOdonacci(z);
		outstr2.print(d[d.length - 1] + ", "); // run the exponential
						       // odonacci every 5 units
						       // of n size

		z += 5;

	    }
	    stopTime = System.currentTimeMillis();

	    long duration2 = stopTime - startTime;

	    outstr2.println();
	    outstr2.println("THE DURATION WAS: " + duration2 + "ms" + "\n\n");

	    outstr2.close();

	}

	catch (FileNotFoundException e) {
	    System.out.print("Error writing to file");
	    System.exit(0);
	}

	finally {
	    if (outstr != null)
		outstr.close();
	}

    }

    public static long exponentialOdonacci(int k) {

	try {
	    if (k < 0)
		throw new NegativeNumException(); // make sure nonnegative nb

	    if (k <= 3) // stopping case
		return 1;
	    else
		return (exponentialOdonacci(k - 1) + exponentialOdonacci(k - 2) + exponentialOdonacci(k - 3));
	}

	catch (NegativeNumException f) {

	    System.out.println(f.getMessage());
	    System.exit(0);
	}

	return -1;

    }

    public static long[] LinearOdonacci(int k) {

	long[] a = new long[3];
	long i = 0, j = 0, m = 0;

	if (k == 3) {

	    i = 1;
	    j = 1;
	    m = 1;

	    a[0] = i;
	    a[1] = j;
	    a[2] = m;

	    System.out.print(i + ", " + j + ", " + m + ", ");

	    return a;
	}

	else {

	    a = LinearOdonacci(k - 1);

	    i = a[0];
	    j = a[1];
	    m = a[2];
	    long sum = i + j + m;

	    a[0] = a[1];
	    a[1] = a[2];
	    a[2] = sum;

	    System.out.print((sum) + ", ");

	    return a;

	}

    }

}
