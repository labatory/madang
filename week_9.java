package db_project_9;
import java.sql.*;

public class week_9 {
    // 데이터베이스 연결 정보
    private static final String URL = "jdbc:mysql://192.168.149.3:4567/madang";
    private static final String USER = "mskang";
    private static final String PASSWORD = "1234";

    // 데이터 삽입 메소드
    public static void insertData(int bookid, String bookname, String publisher) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "INSERT INTO Book (bookid, bookname, publisher) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, bookid);
            pstmt.setString(2, bookname);
            pstmt.setString(3, publisher);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 데이터 삭제 메소드
    public static void deleteData(int bookid) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "DELETE FROM Book WHERE bookid=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, bookid);
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 데이터 검색 메소드
    public static void searchData(int price) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM Book WHERE price=?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, price);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
            rs.close();
            pstmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM Book");
        while (rs.next())
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
        con.close();
    }catch(Exception e) {System.out.println(e);}
}

        

    public static void main(String[] args) {
        // 샘플 데이터 삽입
        insertData(188, "Sample Book", "Sample Author");

        // 샘플 데이터 검색
        searchData(10000);

        // 샘플 데이터 삭제
        deleteData(1);

        // 삭제된 데이터 검색 (결과 없음)
        searchData(10000);
    }
}
