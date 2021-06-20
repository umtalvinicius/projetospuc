package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MyUpdateValue { {
    String url1 = "jdbc:mysql://localhost:3308/covid";
    String user = "root";
    String password = "";
    
    Scanner scanner = new Scanner(System.in);
    
	System.out.println("Qual o id do paciente que deseja editar? ");
	String idAlterar = scanner.nextLine();
  
	System.out.println("Qual campo deseja editar? id(1), nome(2), nascimento(3), sexo(4), telefone(5), endereço(6), comorbidades(7), estado de saude(8)");
  	int campo = scanner.nextInt();
  	scanner.nextLine();
  	
  	System.out.println("novo valor: ");
  	String novoValor = scanner.nextLine();
  
    try {    		    	  
        Connection connection = DriverManager.getConnection(url1, user, password);
        
        String sql = "";
        
	  	switch(campo) {
	  	case 1:
	  		sql = "UPDATE pacientes SET id = ? WHERE id = ?";
	  		break;
	  	case 2:
	  		sql = "UPDATE pacientes SET nome = ? WHERE id = ?";
	  		break;
	  	case 3:
	  		sql = "UPDATE pacientes SET nascimento = ? WHERE id = ?";
	  		break;
	  	case 4:
	  		sql = "UPDATE pacientes SET sexo = ? WHERE id = ?";
	  		break;
	  	case 5:
	  		sql = "UPDATE pacientes SET telefone = ? WHERE id = ?";
	  		break;
	  	case 6:
	  		sql = "UPDATE pacientes SET endereço = ? WHERE id = ?";
	  	case 7:
	  		sql = "UPDATE quadro_Covid SET Comorbidades = ? WHERE id1 = ?";
	  		break;
	  	case 8:
	  		sql = "UPDATE quadro_Covid SET estado_saude = ? WHERE id1 = ?";	
	  		
	  	}
	      		        
	  	PreparedStatement statment1 = connection.prepareStatement(sql);
      
        statment1.setString(1, novoValor);
        statment1.setString(2, idAlterar);
        
        int rows = statment1.executeUpdate();
        if (rows > 0) {
        	System.out.println("O Valor foi Alterado.");
        }             
        
        statment1.close();
        connection.close();

    }
    catch (SQLException ex) {
        System.out.println("An error occurred. Maybe user/password is invalid");
        ex.printStackTrace();
    }
}
}
