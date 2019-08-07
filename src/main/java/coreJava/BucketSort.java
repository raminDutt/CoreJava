package coreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.IntStream.Builder;
import java.util.stream.Stream;

public class BucketSort {

    public static int[] sort(int[] array) {
	int max = array[0];
	for (int v : array) {
	    if (v > max)
		max = v;
	}

	int radix = new Integer(max).toString().length();

	List<Integer>[] buckets = new ArrayList[10];
	Function<Integer, Integer> hash = input -> {

	    int divisor = (int) Math.pow(10, radix - 1);
	    int hashCode = input.intValue() / divisor;

	    return hashCode > 0 ? hashCode : 0;
	};

	for (int v : array) {
	    Integer integer = new Integer(v);
	    int index = hash.apply(integer);
	    if (buckets[index] == null)
		buckets[index] = new ArrayList<Integer>();
	    buckets[index].add(v);
	}

	System.out.println(Arrays.toString(buckets));
	for (List<Integer> bucket : buckets) {
	    if (bucket != null)
		Collections.sort(bucket);
	}

	int[] result = Stream.<List<Integer>> of(buckets)
		.filter(list -> list != null).flatMapToInt(list -> {
		    Builder builder = IntStream.builder();
		    list.forEach(integer -> builder.add(integer.intValue()));
		    return builder.build();

		}).toArray();

	int[] array2 = Stream.of(buckets).filter(list -> list != null)
		.flatMap(list -> list.stream()).mapToInt(x -> x.intValue())
		.toArray();
	//System.out.println(Arrays.toString(result));
	//System.out.println(Arrays.toString(array2));
	return result;
    }

}
