import java.util.Random;
import java.util.Scanner;

public class BankApplication {
    Bank bank;
    Scanner scan;
    Random rand;

    public static void main(String[] args) {
        // Start the entire program
        var app = new BankApplication();
        app.initalize();
    }

    private void initalize() {
        this.bank = new Bank();
        this.scan = new Scanner(System.in);
        this.rand = new Random();

        // TODO: Remove this when done
        this.seedAccounts();

        this.run();

        this.scan.close();
    }

    private void run() {
        int selection = this.handleMenu();

        switch (selection) {
            case 1: // Find account from id
                this.findAccountForHolder();
                break;
            case 2: // Find account from id
                this.findAccountByPartOfName();
                break;
            case 3: // Deposit
                this.deposit();
                break;
            case 6: // Create new account
                this.createAccount();
                break;
            case 8: // Print all accounts
                this.printAccounts();
                break;
            case 9: // Close
                this._print("Hejdå! :(");
                return;
        }

        // Recursivley restart untill 9 is pressed
        this.run();

    }

    // * Helper to seed some mock data into bank
    private void seedAccounts() {
        var firstnames = new String[] { "Lucas", "Liam", "William", "Elias", "Noah", "Hugo", "Oliver", "Oscar", "Adam",
                "Matteo", };
        var lastnames = new String[] { "Andersson", "Johansson", "Karlsson", "Nilsson", "Eriksson", "Larsson", "Olsson",
                "Persson", "Svensson", };

        for (int i = 0; i < 12; i++) {
            this.bank.addAccount(
                    firstnames[rand.nextInt(firstnames.length)] + " " + lastnames[rand.nextInt(lastnames.length)],
                    rand.nextInt(100));
        }
    }

    private int handleMenu() {
        var menuItems = new String[] { "Hitta konto utifrån innehavare", "Sök kontoinnehavare utifrån (del av) namn",
                "Sätt in", "Ta ut", "Överföring", "Skapa konto", "Ta bort konto", "Skriv ut konton", "Avsluta" };

        this.printSeparator();

        for (int i = 0; i < menuItems.length; i++) {
            this._print((i + 1) + ": " + menuItems[i]);
        }

        int selection = this._waitForInputI("val");

        // Reprint menu if selection is out of range
        if (selection > menuItems.length + 1 || selection < 1) {
            return this.handleMenu();
        }

        return selection;
    }

    private void printSeparator() {
        System.out.print("\n");
        for (int i = 0; i < 24; i++) {
            System.out.print(" - ");
        }
        System.out.print("\n");
    }

    private void createAccount() {
        var name = this._waitForInput("namn");

        long id;
        try {
            id = this._waitForInputL("id");

        } catch (Exception e) {
            // Assign random value
            id = this.rand.nextInt(Integer.MAX_VALUE);
            this._print("Kontonummer är ej korrekt, ett slumpmässigt har genererats: " + id);
        }

        this.bank.addAccount(name, id);
        this._print("Bankkonto " + id + " skapat för " + name);

    }

    private void printAccounts() {
        var accs = bank.getAllAccounts();

        if (accs.size() < 1) {
            this._print("Det finns inga konton");
            return;
        }

        // Lambda-function instead of regular for-loop
        accs.forEach(acc -> this._print(acc));
    }

    private void findAccountForHolder() {
        var id = this._waitForInputL("Sök kund");

        var found = this.bank.findAccountsForHolder(id);
        var length = found.size();

        if (length > 0) {
            for (int i = 0; i < length; i++) {
                var acc = found.get(i);
                this._print("konto " + acc.getAccountNumber() + "");
            }
        } else {
            this._print("No results found.");
        }
    }

    private void findAccountByPartOfName() {
        String searchTerm = this._waitForInput("Sök: ");

        var searchResults = bank.findByPartofName(searchTerm);

        searchResults.forEach(s -> this._print(s));

    }

    private void deposit() {
        int accountNbr = this._waitForInputI("konto");
        var account = this.bank.findByNumber(accountNbr);

        if (account == null) {
            this._print("Account not found");
            return;
        }

        var amount = this._waitForInputL("Hur mycket vill du sätta in? ");
        account.deposit(amount);

        this._print(account);
    }

    private void _print(Object s) {
        System.out.println(s);
    }

    private String _waitForInput(String label) {
        if (label != "") {
            System.out.print(label + ": ");
        }

        return scan.next();
    }

    private int _waitForInputI(String label) {
        if (label != "") {
            System.out.print(label + ": ");
        }

        return scan.nextInt();
    }

    private long _waitForInputL(String label) {
        if (label != "") {
            System.out.print(label + ": ");
        }

        return scan.nextLong();
    }

}
