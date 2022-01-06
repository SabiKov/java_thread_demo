package deamon;


import java.math.BigInteger;

public class DeamonThread {

    public static void main(String[] args) {

        Thread thread = new Thread(
                new LongComputationTaskDeamon(
                        new BigInteger("20000000"),
                        new BigInteger("100000000")));

        thread.setDaemon(true); // thread runs in background
        thread.start();
        thread.interrupt();

    }

    private static class LongComputationTaskDeamon
            implements Runnable {

        private BigInteger base;
        private BigInteger power;


        public LongComputationTaskDeamon(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
