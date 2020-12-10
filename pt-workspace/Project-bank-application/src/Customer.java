public class Customer {
    private String name;
    private long idNr;
    private int customerNr;
    private static int nextCustomerNr = 100;

    /**
     * Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
     * Kunden tilldelas också ett unikt kundnummer.
     */
    public Customer(String name, long idNr) {
        this.name = name;
        this.idNr = idNr;
        this.customerNr = nextCustomerNr;
        nextCustomerNr++;
    }

    /** Tar reda på kundens namn. */
    public String getName() {
        return this.name;
    }

    /** Tar reda på kundens personnummer. */
    public long getIdNr() {
        return this.idNr;
    }

    /** Tar reda på kundens kundnummer. */
    public int getCustomerNr() {
        return this.customerNr;
    }

    /** Returnerar en strängbeskrivning av kunden. */
    public String toString() {
        return this.name + ", id " + this.idNr + ", kundnr " + this.getCustomerNr();
    }
}
