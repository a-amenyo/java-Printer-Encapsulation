public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if(tonerLevel > -1 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        }
        else this.tonerLevel = -1;

        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount){
        if(tonerAmount > 0 && tonerAmount <= 100){
            if(tonerLevel + tonerAmount > 100){
                return -1;
            }
            else {
                tonerLevel += tonerAmount;
                return tonerLevel;
            }
        }
        else return -1;
    }

    public int printPages(int pages){
        int pagesToPrint = pages;
        if(duplex){
            pagesToPrint = (pages / 2) + (pages % 2); // The modulus helps convert ever odd number to an even number so that the pages can be printed either way.i.e the remainder of an even number
            // will always be one in this case, and therefore can be added to the (pages/2) to make it an even number
            pagesPrinted += pagesToPrint;
            System.out.println("Printing in duplex mode");
        }
        return pagesToPrint;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

}
