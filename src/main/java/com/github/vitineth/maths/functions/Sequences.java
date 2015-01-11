package com.github.vitineth.maths.functions;

import com.github.vitineth.maths.functions.errors.BinomialCoefficientParameterException;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by ryan on 10/01/15.
 */
public class Sequences {

    /**
     * This will generate the given amount of numbers in the Fibonacci Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A000045">http://oeis.org/A000045</a>
     *
     * @param amount The amount of numbers to generate
     * @return BigInteger[] - The array of numbers
     */
    public static BigInteger[] generateFibonacciSequence(int amount){
        BigInteger[] sequence = new BigInteger[amount];

        BigInteger now = new BigInteger("1");
        BigInteger last = new BigInteger("0");
        for (int i = 0; i < amount; i++) {
            BigInteger x = now.add(last);
            sequence[i] = x;
            last = now;
            now = x;
        }

        return sequence;
    }

    /**
     * This will generate the given amount of numbers in the Catalan Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A000108">http://oeis.org/A000108</a>
     *
     * @param amount The amount of numbers to generate
     * @return long[] - The array of numbers
     */
    public static double[] executeLinearEquation(String linearEquation, int amount){
        double[] results = new double[amount];
        Expression e = new ExpressionBuilder(linearEquation)
                .variable("x")
                .build();
        for (int i = 0; i < amount; i++) {
            e.setVariable("x", i);
            results[i] = e.evaluate();
        }
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Recamán Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A005132">http://oeis.org/A005132</a>
     *
     * @param amount The amount of numbers to generate
     * @return BigInteger[] - The array of numbers
     */
    public static BigInteger[] generateRecamánSequence(int amount) {
        //Create a list of BigIntegers so we can use contains functions.
        List<BigInteger> bigInts = new ArrayList<BigInteger>();

        //For every value from 0 to the given amount
        for (int i = 0; i < amount; i++) {
            //Add a 0 value
            bigInts.add(new BigInteger("0"));
        }
        //From 1 to the amount of values.
        for (int i = 1; i < amount; i++) {
            //Create the value x for testing - it is a(n - 1) - n
            //Where:
            //  a = bigInts
            //  n = i
            BigInteger x = bigInts.get(i - 1).subtract(new BigInteger("" + i));
            //If the signum of x is one (it is greater than 0 and the array does not contain the value
            if(x.signum() == 1 && !bigInts.contains(x)){
                //Then set i to the value of x
                bigInts.set(i, x);
                //Otherwise if it is less than 0 or is already in the array
            }else{
                //Set i to the value of a(n - 1) + n
                //Where:
                //  a = bigInts
                //  n = i
                bigInts.set(i, bigInts.get(i - 1).add(new BigInteger("" + i)));
            }
        }

        //Convert the list into an array.
        BigInteger[] results = new BigInteger[bigInts.size()];
        results = bigInts.toArray(results);
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Triangular Number Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A000217">http://oeis.org/A000217</a>
     *
     * @param amount The amount of numbers to generate
     * @return long[] - The array of numbers
     */
    public static long[] generateTriangleNumbers(int amount){
        long[] results = new long[amount];
        for (int i = 1; i < amount; i++) {
            results[i] = results[i - 1] + (i);
        }
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Pentagonal Number Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A000326">http://oeis.org/A000326</a>
     *
     * @param amount The amount of numbers to generate
     * @return long[] - The array of numbers
     */
    public static long[] generatePentagonalNumbers(int amount){
        long[] results = new long[amount];
        int last = 0;
        int lastAdded = 1;
        for (int i = 0; i < amount; i++) {
            int x = last + lastAdded;
            results[i] = x;
            lastAdded += 3;
            last = x;
        }
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Hexagonal Numbers Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A000384">http://oeis.org/A000384</a>
     *
     * @param amount The amount of numbers to generate
     * @return long[] - The array of numbers
     */
    public static long[] generateHexagonalNumbers(int amount){
        long[] results = new long[amount];
        int last = 0;
        int lastAdded = 1;
        for (int i = 0; i < amount; i++) {
            int x = last + lastAdded;
            results[i] = x;
            lastAdded += 4;
            last = x;
        }
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Lazy Caterers Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A000124">http://oeis.org/A000124</a>
     *
     * @param amount The amount of numbers to generate
     * @return long[] - The array of numbers
     */
    public static long[] generateLazyCaterersNumbers(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            results[i] = (int) (Math.pow(i, 2) + i + 2) / 2;
        }
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Magin Number Square Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A006003">http://oeis.org/A006003</a>
     *
     * @param amount The amount of numbers to generate
     * @return long[] - The array of numbers
     */
    public static long[] generateMagicSquareNumbers(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            results[i] = (int) (i * (Math.pow(i, 2) + 1) / 2);
        }
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Catalan Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A000108">http://oeis.org/A000108</a>
     *
     * @param amount The amount of numbers to generate
     * @return long[] - The array of numbers
     */
    public static long[] generateCatalanNumbers(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            try {
                double first = (double) 1 / (i + 1);
                BigInteger second = MathUtils.solveBinomialCoefficients(2 * i, i);
                results[i] = (long) (first * second.doubleValue());
            } catch (BinomialCoefficientParameterException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

    /**
     * This will generate the given amount of numbers in the Catalan Sequence
     * <br>
     * <br>
     * OEIS Index: <a href="http://oeis.org/A005150">http://oeis.org/A005150</a>
     *
     * @param amount The amount of numbers to generate
     * @return BigInteger[] - The array of numbers
     */
    public static BigInteger[] generateLookAndSayNumbers(int amount) {
        BigInteger[] results = new BigInteger[amount];
        String currentNumber = "1";
        String newNumber = "";
        char current;
        int count;
        for (int i = 0; i < amount; i++) {
            results[i] = new BigInteger(currentNumber);
            current = currentNumber.charAt(0);
            count = 0;
            for (int j = 0; j < currentNumber.length(); j++) {
                if(currentNumber.charAt(j) != current || j == currentNumber.length() - 1){
                    if(currentNumber.charAt(j) == current)count++;
                    newNumber += count + "";
                    newNumber += current + "";
                    current = currentNumber.charAt(j);
                    count = 1;
                }else{
                    count++;
                }
            }
            if(currentNumber.length() > 1 && currentNumber.charAt(currentNumber.length() - 1) != currentNumber.charAt(currentNumber.length() - 2)){
                newNumber += count + "";
                newNumber += current + "";
            }
            currentNumber = newNumber;
            newNumber = "";
        }
        return results;
    }

    public static long[] generateSquareNumbers(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            results[i] = (long) Math.pow(i, 2);
        }
        return results;
    }

    public static long[] generateCubeNumbers(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            results[i] = (long) Math.pow(i, 3);
        }
        return results;
    }

    public static long[] generateNPowX(int amount, int x){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            results[i] = (long) Math.pow(i, x);
        }
        return results;
    }

    public static long[] generateSigma1N(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            List<Integer> divisors = new ArrayList<Integer>();
            for (int j = 1; j < (i / 2) + 1; j++) {
                if(i % j == 0)divisors.add(j);
            }
            long count = 0;
            for (int j = 0; j < divisors.size(); j++) {
                count += divisors.get(j);
            }
            count+=i;
            results[i] = count;
        }
        return results;
    }

    public static long[] generateSigma0N(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {
            List<Integer> divisors = new ArrayList<Integer>();
            for (int j = 1; j < (i / 2) + 1; j++) {
                if(i % j == 0)divisors.add(j);
            }
            results[i] = divisors.size()+1;
        }
        return results;
    }

    public static long[] generateEulerTotientNumbers(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {//For the given amount of numbers
            List<Integer> iFactors = MathUtils.generateFactorsOfN(i);//Get their factors
            int count = 0;//And create a variable called count at 0
            for (int j = 0; j < i; j++) {//While the value of j is less than the value of i
                List<Integer> jFactors = MathUtils.generateFactorsOfN(j);//Get j's factors
                boolean coprime = true;//Create a variable called coprime and set it to true as a default
                if (jFactors.size() == 0) coprime = false;//If j has no factors it cannot be coprime
                for (Integer integer : jFactors) {//For every factor of j
                    if (integer != 1 && iFactors.contains(integer)) {//If it is not 1 and is also a factor of i
                        coprime = false;//Then set coprime to false
                        break;//And break
                    }
                }
                if (coprime) count++;//If the number was coprime then add 1 to count
            }
            results[i] = count;
        }
        return results;
    }

    public static long[] generatePrimesUpToN(int amount){
        long potentialPrime = 2;
        boolean add;
        List<Long> primeSet = new ArrayList<Long>();
        primeSet.add(potentialPrime);
        while(potentialPrime < amount){
            potentialPrime++;
            add = true;
            for (Long aPrimeSet : primeSet) {
                if (potentialPrime % aPrimeSet == 0) {
                    add = false;
                    break;
                }
            }
            if(!primeSet.contains(new Long(potentialPrime)) && add){
                primeSet.add(potentialPrime);
            }
        }
        long[] results = new long[primeSet.size()];
        Object[] longs = primeSet.toArray();
        for (int i = 0; i < longs.length; i++) results[i] = (Long) longs[i];

        return results;
    }

    public static long[] generateNPrimes(int amount){
        long[] results = new long[amount];
        long potentialPrime = 2;
        boolean add;
        List<Long> primeSet = new ArrayList<Long>();
        primeSet.add(potentialPrime);
        while(primeSet.size() < amount){
            potentialPrime++;
            add = true;
            for (Long aPrimeSet : primeSet) {
                if (potentialPrime % aPrimeSet == 0) {
                    add = false;
                    break;
                }
            }
            if(!primeSet.contains(new Long(potentialPrime)) && add){
                primeSet.add(potentialPrime);
            }
        }
        Object[] longs = primeSet.toArray();
        for (int i = 0; i < longs.length; i++) results[i] = (Long) longs[i];

        return results;
    }

    /**
     * pp = 2
     ps = [pp]
     lim = raw_input("\nGenerate prime numbers up to what number? : ")
     while pp < int(lim):
     pp += 1
     for a in ps:
     if pp%a==0:
     break
     else:
     if pp not in ps:
     ps.append(pp)
     print ps
     * @param amount
     * @return
     */

    public static long[] base(int amount){
        long[] results = new long[amount];
        for (int i = 0; i < amount; i++) {

        }
        return results;
    }

}
