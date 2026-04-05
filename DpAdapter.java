/**
 * // Existing system (Adaptee)
 * class OldPrinter {
 * public void printText(String text) {
 * System.out.println("Printing: " + text);
 * }
 * }
 * 
 * // Client expects a different method
 * interface ModernPrinter {
 * void print(String text);
 * }
 * 
 * // Client code
 * public class Main {
 * public static void main(String[] args) {
 * OldPrinter printer = new OldPrinter();
 * 
 * // Error: OldPrinter doesn't match ModernPrinter
 * // ModernPrinter mp = printer; // Not possible
 * }
 * }
 */

// Step 1: Target Interface (what client expects)
interface ModernPrinter {
    void print(String text); // new method that expected by client
}

// Step 2: Adaptee (existing class)
class OldPrinter {
    public void printText(String text) { // existing method
        System.out.println("Printing: " + text);
    }
}

// Step 3: Adapter
class PrinterAdapter implements ModernPrinter {

    private OldPrinter oldPrinter; // composition: Adapter has an instance of Adaptee

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        // Convert request to the format expected by OldPrinter
        oldPrinter.printText(text);
    }
}

// Step 4: Client
public class DpAdapter {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter(); // Existing printer

        // Using adapter
        ModernPrinter printer = new PrinterAdapter(oldPrinter);

        printer.print("Hello Adapter Pattern!");
    }
}