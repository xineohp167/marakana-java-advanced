package concurrency;

import java.math.BigInteger;
import java.util.Random;

public class Fibonacci {

	private static final Random RANDOM = new Random();

	public static BigInteger fib(int n) {
		return n < 2 ? BigInteger.ONE : fib(n - 1).add(fib(n - 2));
	}

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					int n = RANDOM.nextInt(40);
					System.out.format("fib(%d) = %s\n", n, fib(n));
				}
			});
			threads[i].start();
		}

		for (Thread thread : threads) {
			thread.join();
		}

		System.out.println("done");

	}

}
