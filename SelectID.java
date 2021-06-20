package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectID {
	
String sql;
{
					
String url1 = "jdbc:mysql://localhost:3308/covid";
String user = "root";
String password = "";

Scanner scanner = new Scanner(System.in);

System.out.println("Qual o ID do paciente? ");
String id = scanner.nextLine();
	
sql = "SELECT id, nome, nascimento, sexo, telefone, endereço, id1, comorbidades, estado_saude FROM pacientes inner join quadro_covid on pacientes.id = quadro_covid.id1 WHERE (id = '"+ id +"')";

	try {
	     Connection connection = DriverManager.getConnection(url1, user, password);
	        	        
	     Statement statment = connection.createStatement();
	     ResultSet result = statment.executeQuery(sql);
	     	     
	    
	        		
	     while (result.next()) {
	      	String id1 = result.getString(1);
	       	String nome1 = result.getString(2);
	       	String nascimento1 = result.getString(3);
	       	String sexo1 = result.getString(4);
	       	String endereco = result.getString(5);
	       	String telefone = result.getString(6);
	       	String comorb = result.getString(8);
        	String saude = result.getString(9);
	       	
	     
	       	System.out.println("Paciente ID: n°" + id1 + " | " + nome1 + " | " + nascimento1+ " | " + sexo1 + " | " + endereco + " | " + telefone + " | " + comorb + " | " + saude + " | ");
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


