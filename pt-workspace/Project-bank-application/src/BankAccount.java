public class BankAccount {
    private Customer holder;
    private double balance;
    private int accountNbr;
    private static int nextAccountNbr = 1000;

    /**
     * Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och id
     * ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
     * inledningsvis 0 kr.
     */
    public BankAccount(String holderName, long holderId) {
        this.holder = new Customer(holderName, holderId);
        this.balance = 0;
        accountNbr = nextAccountNbr;

        nextAccountNbr++;
    }

    /**
     * Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas ett unikt
     * kontonummer och innehåller inledningsvis 0 kr.
     */
    public BankAccount(Customer holder) {
        this.holder = holder;
        this.balance = 0;
        accountNbr = nextAccountNbr;

        nextAccountNbr++;
    }

    /** Tar reda på kontots innehavare. */
    public Customer getHolder() {
        return this.holder;
    }

    /** Tar reda på det kontonummer som identifierar detta konto. */
    public int getAccountNumber() {
        return this.accountNbr;
    }

    /** Tar reda på hur mycket pengar som finns på kontot. */
    public double getAmount() {
        return this.balance;
    }

    /** Sätter in beloppet ’amount’ på kontot. */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning blir saldot
     * negativt.
     */
    public void withdraw(double amount) {
        this.balance -= amount;
    }

    /** Returnerar en strängrepresentation av bankkontot. */
    public String toString() {
        var holder = this.getHolder();
        return "konto " + this.accountNbr + " (" + holder.getName() + ", id " + holder.getIdNr() + ", kundnr "
                + holder.getCustomerNr() + "): " + this.getAmount();
    }
}
