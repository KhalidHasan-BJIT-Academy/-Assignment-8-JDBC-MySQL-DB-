package bjit.academy;

import java.sql.*;

public class DBOperation {
    Connection conn;
    public DBOperation(){}
    public  void  doConnectDB() {
        String connectionStr = "jdbc:mysql://localhost:3306/ecommerce data";
        String userName = "root";
        String password = "";

        try {
            this.conn = DriverManager.getConnection(connectionStr, userName, password);
            System.out.println("DB Connection is successful!");
        } catch (SQLException var5) {
            throw new RuntimeException(var5);
        }
    }
    public void  fetchData(){
        try {
            Statement exe_Q = this.conn.createStatement();
            ResultSet result = exe_Q.executeQuery("SELECT* FROM customer NATURAL JOIN salesman where city ='jessore'");
            while (result.next()){
            String name = result.getString("c_name");
            String city = result.getString("city");
            int grade= result.getInt("grade");
            int sID = result.getInt("salesman_id");
            System.out.println("Customer Name: " +name+ " City: "+city+" Grade: "+grade+" SalesID: "+ sID );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void fetchSales() {
        try{
            Statement exe_Q = this.conn.createStatement();
            ResultSet rsInfo= exe_Q.executeQuery("SELECT s_id, s_name  FROM salesman where city='dhaka' ");
            while (rsInfo.next()){
                int sID= rsInfo.getInt("s_id");
                String sName=rsInfo.getString("s_name");
                System.out.println("Sales ID: "+sID+" Salesman Name: "+ sName);
            }}
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void getMaxGradeValue(){
        try{
            Statement exeQ = this.conn.createStatement();
            ResultSet rs_getMax= exeQ.executeQuery("SELECT MAX(grade) AS MAX_GRADE_VALUE FROM customer ");

            while (rs_getMax.next()){
                int maxGrade= rs_getMax.getInt("grade");8
                System.out.println("Max grade of customer: "+ maxGrade);
            }}
        catch (SQLException exe){
            throw new RuntimeException(exe);
        }
    }
}
