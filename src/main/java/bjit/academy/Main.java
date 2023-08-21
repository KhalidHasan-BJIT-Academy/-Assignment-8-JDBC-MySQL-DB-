package bjit.academy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DBOperation dbObj=new DBOperation();
        dbObj.doConnectDB();
        dbObj.fetchSales();
        System.out.println("Natural Join data ");
        dbObj.fetchData();
        System.out.println("\n Maximum Grade value");
        dbObj.getMaxGradeValue();
    }
}