/**
// Existing system (Adaptee)
class OldPrinter {
    public void printText(String text) {
        System.out.println("Printing: " + text);
    }
}

// Client expects a different method
interface ModernPrinter {
    void print(String text);
}

// Client code
public class Main {
    public static void main(String[] args) {
        OldPrinter printer = new OldPrinter();

        // ❌ Error: OldPrinter doesn't match ModernPrinter
        // ModernPrinter mp = printer;  // Not possible
    }
}
 */


// Step 1: Target Interface (what client expects)
interface ModernPrinter {
    void print(String text);
}

// Step 2: Adaptee (existing class)
class OldPrinter {
    public void printText(String text) {
        System.out.println("Printing: " + text);
    }
}

// Step 3: Adapter
class PrinterAdapter implements ModernPrinter {

    private OldPrinter oldPrinter;

    public PrinterAdapter(OldPrinter oldPrinter) {
        this.oldPrinter = oldPrinter;
    }

    @Override
    public void print(String text) {
        // Convert request
        oldPrinter.printText(text);
    }
}

// Step 4: Client
public class DpAdapter {
    public static void main(String[] args) {
        OldPrinter oldPrinter = new OldPrinter();

        // Using adapter
        ModernPrinter printer = new PrinterAdapter(oldPrinter);

        printer.print("Hello Adapter Pattern!");
    }
}