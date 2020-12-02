import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    /** Skapar en ny bank utan konton. */
    public Bank() {
        this.accounts = new ArrayList<BankAccount>();
    }

    /**
     * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
     * givna uppgifterna ska inte en ny Customer skapas, utan istället den
     * befintliga användas. Det nya kontonumret returneras.
     */
    public int addAccount(String holderName, long idNr) {
        BankAccount newAccount = new BankAccount(holderName, idNr);
        this.accounts.add(newAccount);

        return newAccount.getAccountNumber();
    }

    /**
     * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
     * ingen sådan finns.
     */
    public Customer findHolder(long idNr) {
        for (int i = 0; i < this.accounts.size(); i++) {
            var holder = this.accounts.get(i).getHolder();
            if (holder.getIdNr() == idNr) {
                return holder;
            }
        }
        return null;
    }

    /**
     * Tar bort konto med nummer ’number’ från banken. Returnerar true om kontot
     * fanns (och kunde tas bort), annars false.
     */
    public boolean removeAccount(int number) {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getAccountNumber() == number) {
                this.accounts.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
     * sorterad på kontoinnehavarnas namn.
     */

    // TODO: Add the boring sorting logic
    public ArrayList<BankAccount> getAllAccounts() {
        return this.accounts;
    }

    /**
     * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
     * Returnerar null om inget sådant konto finns.
     */
    public BankAccount findByNumber(int accountNumber) {
        for (int i = 0; i < this.accounts.size(); i++) {
            var acc = this.accounts.get(i);
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    /**
     * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’. Kontona
     * returneras i en lista. Kunderna antas ha unika id-nummer.
     */
    public ArrayList<BankAccount> findAccountsForHolder(long idNr) {
        var holderAccounts = new ArrayList<BankAccount>();

        for (int i = 0; i < this.accounts.size(); i++) {
            var acc = this.accounts.get(i);
            if (acc.getHolder().getIdNr() == idNr) {
                holderAccounts.add(acc);
            }
        }

        return holderAccounts;
    }

    /**
     * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
     * vars namn innehåller strängen ’namePart’ inkluderas i resultatet, som
     * returneras som en lista. Samma person kan förekomma flera gånger i
     * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
     * på stora och små bokstäver.
     */
    public ArrayList<Customer> findByPartofName(String namePart) {
        var customers = new ArrayList<Customer>();
        var partLowercase = namePart.toLowerCase();

        for (int i = 0; i < this.accounts.size(); i++) {
            var holder = this.accounts.get(i).getHolder();

            if (holder.getName().toLowerCase().contains(partLowercase)) {
                customers.add(holder);
            }
        }
        return customers;
    }
}
