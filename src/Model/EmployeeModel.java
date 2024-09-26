package Model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    public static List<Employee> getAllEmployees(){
        List<Employee> listado = new ArrayList<>();

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        Connection connection = databaseConnection.getConnection();

        try {
            CallableStatement cstmt = connection.prepareCall("call sp_Select_Employee()");
            ResultSet rs = cstmt.executeQuery();

            while(rs.next()){
                Employee employee = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                listado.add(employee);
            }
            rs.close();
            cstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
        }

        return listado;
    }
}
