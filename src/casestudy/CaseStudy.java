package casestudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaseStudy {

    public static final int MAX_PASSWORD = 9999;

    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(CaseStudy.MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();

        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescandingHackerThread(vault));
        threads.add(new PoliceThread());

        for(Thread t : threads) {
            t.start();
        }
    }
}
