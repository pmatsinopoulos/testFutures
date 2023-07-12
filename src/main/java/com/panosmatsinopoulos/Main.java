package com.panosmatsinopoulos;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting");

        Future<Integer> future = new SquareCalculator().calculate(12);
        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            System.err.println("Future has been interrupted");
            return;
        } catch (ExecutionException e) {
            System.err.println("Future had a execution error:" + e.toString());
            return;
        }
        System.out.println("Integer returned from future: " + result.toString());
        exit(0);
    }
}
