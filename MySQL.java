package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MySQL {
    public static void main(String[] args) {
	    String url1 = "jdbc:mysql://localhost:3308/covid";
	    String user = "root";
	    String password = "";
	    
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("1 - Novo Paciente, 2 - ver database, 3 - Editar paciente, 4 - Excluir paciente");
    	int MenuInicio = scanner.nextInt();
    	scanner.nextLine();
    	
    	switch(MenuInicio) {
    		case 1:	
    			new MyInsertValue();
    			break;
    		case 2:
    			new MySelect();
    			break;
    		case 3:
    			new MyUpdateValue();
    			break;
    		case 4:
    			new MyDeleteValue();
    			break;
    	}
        scanner.close();
    }
}







