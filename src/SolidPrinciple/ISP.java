package SolidPrinciple;
class Document {

}

interface Machine
{
    void print(Document d);
    void fax(Document d) throws Exception;
    void scan(Document d);
}
class MultiFunctionPrinter implements Machine
{

    @Override
    public void print(Document d) {
      
    }

    @Override
    public void fax(Document d) {
      
    }

    @Override
    public void scan(Document d) {
       
    }
    
}

class OldFasionedPrinter implements Machine{

    @Override
    public void print(Document d) {
       
    }

    @Override
    public void fax(Document d) throws Exception {
        throw new Exception();
       
    }

    @Override
    public void scan(Document d) {
       
    }

}
//Now we are going to splite the machine interface into separated interfaces for printing, scaning and faxing
interface Printer{
    void print(Document d);
}
interface Scanner 
{
    void scan(Document d);
}

class JustAPrinter implements Printer
{

    @Override
    public void print(Document d) { }
    
}
// YAGNI = You Ain't Going to Need It
class Photocopier implements Printer, Scanner
{

    @Override
    public void scan(Document d) {
       
    }

    @Override
    public void print(Document d) {
       
    }
    
}
interface MultiFunctionDevice extends Printer, Scanner {}

class MultiFunctionMachine implements MultiFunctionDevice
{
    private Printer printer;
    private Scanner scanner;

    public MultiFunctionMachine(Printer printer, Scanner scanner)
    {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
    
}
public class ISP {
    
}
