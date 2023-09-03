import java.sql.*;
public class DemoJDBC {
    public static void main(String args[]) {

        String dburl = "jdbc:mysql://localhost:3306/coursedb";
        String username = "root";
        String passwd = "DbAk@18";
        try {

            //register the driver -1
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection -2
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursedb", username , passwd);

        
            //create statement - 3
            Statement stmt = con.createStatement();

            // DatabaseMetaData d = con.getMetaData();

            //execute the query - 4
            ResultSet rs = stmt.executeQuery("select studentName , enrolledCourse, studentAddress, courseFee from students");

            while (rs.next()){
                System.out.println(rs.getString(1) + " : "+ rs.getString(2)+ " : "+ rs.getString(3) + ": "+ rs.getFloat(4));
            }

            //close - 5
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}