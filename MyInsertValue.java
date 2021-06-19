package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyInsertValue { {
    String url1 = "jdbc:mysql://localhost:3308/covid";
    String user = "root";
    String password = "";
	
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Qual o nome do paciente? ");
		String nome = scanner.nextLine();
  
		System.out.println("data de nascimento ");
		String nascimento = scanner.nextLine();
  
		System.out.println("sexo ");
  		String sx = scanner.nextLine();
  
  		System.out.println("nacionalidade ");
  		String nac = scanner.nextLine();
  
  		try {    		    	  
        Connection connection = DriverManager.getConnection(url1, user, password);
        
        String sql = "INSERT INTO pacientes (id, nome, nascimento, sexo, nacionalidade) VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement statment = connection.prepareStatement(sql);
        statment.setString(1, null);
        statment.setString(2, nome);
        statment.setString(4, sx);
        statment.setString(5, nac);
        
        int rows = statment.executeUpdate();
        if (rows > 0) {
        	System.out.println("A row has been inserted.");
        }             
        
        statment.close();
        connection.close();
        
    }  
    
    catch (SQLException ex) {
        System.out.println("An error occurred. Maybe user/password is invalid");
        ex.printStackTrace(); 
    }

  		
}
}
