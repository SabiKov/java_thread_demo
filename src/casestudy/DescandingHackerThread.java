package casestudy;

public class DescandingHackerThread extends HackerThread {

    public DescandingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for(int guess = CaseStudy.MAX_PASSWORD; guess >= 0; guess--) {
            if(vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
