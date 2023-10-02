public class ElectronicTest {
    public static void main(String[] args) {
        // Create some devices
        cellPhone cellPhone1 = new cellPhone("Apple IPhone 15");
        cellPhone cellPhone2 = new cellPhone("Motorola Razr");
        cellPhone cellPhone3 = new cellPhone("Samsung Galaxy");
        tablet tablet1 = new tablet("Apple iPad Air");
        tablet tablet2 = new tablet("Amazon Fire HD");
        tablet tablet3 = new tablet("Samsung Galaxy X9")

        // List electronics
        Electronic Electronic = new Library();

        // Add cell Phone to  Electronics
        electronic.addcellPhone(cellPhone1);
        electronic.addcellPhone(cellPhone2);
        electronic.addcellPhone(cellPhone3);
        electronic.addtablet(tablet1);
        electronic.addtablet(tablet2);
        electronic.addtablet(tablet3);

        // Test electronic functionality
        System.out.println("Cell Phones in the Electronics:");
        for (cellPhone cellPhone : electronic.getcellPhone()) {
            System.out.println(cellPhone);
        }

        // Remove a device from the electonics
        electronic.removetable(tablet1);

        System.out.println("\ntablet after removing one:");
        for (tablet tablet : electronic.gettablet()) {
            System.out.println(tablet);
        }
    }
}
