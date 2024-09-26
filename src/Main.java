import Model.DatabaseConnection;
import Model.EmployeeModel;

import javax.xml.crypto.Data;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(EmployeeModel.getAllEmployees().size());

    }
}