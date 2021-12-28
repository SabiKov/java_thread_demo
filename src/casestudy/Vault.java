package casestudy;

public class Vault {

    private int password;
    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword(int guess) {
        try{
            Thread.sleep(5);
        } catch (InterruptedException ie) {

        }
        return this.password == guess;
    }
}
