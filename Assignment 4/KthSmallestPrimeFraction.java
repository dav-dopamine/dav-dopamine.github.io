package main;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestPrimeFraction 
{
	 public int[] findKthSmallestPrimeFraction(int[] primes, int k) 
	    {
	        int length = primes.length;
	        Queue<Fraction> priorityQueue = new PriorityQueue<>();

	        for (int index = 1; index < length; index++) 
	        {
	            priorityQueue.offer(new Fraction(1, primes[index], 0, index));
	        }

	        for (int index = 1; index < k; index++) 
	        {
	            Fraction fraction = priorityQueue.poll();
	            if (fraction.numeratorIndex + 1 < fraction.denominatorIndex) 
	            {
	                priorityQueue.offer(new Fraction(primes[fraction.numeratorIndex + 1], primes[fraction.denominatorIndex], 
	                                                  fraction.numeratorIndex + 1, fraction.denominatorIndex));
	            }
	        }

	        Fraction resultFraction = priorityQueue.peek();
	        return new int[] {resultFraction.numerator, resultFraction.denominator};
	    }

	    static class Fraction implements Comparable<Fraction> 
	    {
	        int numerator;
	        int denominator;
	        int numeratorIndex;
	        int denominatorIndex;

	        public Fraction(int numerator, int denominator, int numeratorIndex, int denominatorIndex) 
	        {
	            this.numerator = numerator;
	            this.denominator = denominator;
	            this.numeratorIndex = numeratorIndex;
	            this.denominatorIndex = denominatorIndex;
	        }

	        @Override
	        public int compareTo(Fraction other) 
	        {
	            return numerator * other.denominator - other.numerator * denominator;
	        }
	    }
}
