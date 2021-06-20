package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Select {
	
		String sql;
{
						
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
  	
	System.out.println("Endereço, Rua:  ");
	String end1 = scanner.nextLine();
		
	System.out.println("Endereço, Número:  ");
	String end2 = scanner.nextLine();
		
	System.out.println("Endereço, Bairro:  ");
	String end3 = scanner.nextLine();
		
	String end = "Rua " + end1 +" | "+ end2 +" | " + end3 + " | ";
	
	System.out.println("Telefone ");
	String Tel = scanner.nextLine();
  	
  	if(nascimento == "" & sx == "" & end == "") {
 	     sql = "SELECT id, nome, nascimento, sexo, endereço, telefone FROM pacientes WHERE (nome = '"+ nome +"')";
 	}
  	
  	else if(nascimento != "" & sx == "") {
  	     sql = "SELECT id, nome, nascimento, sexo, endereço, telefone FROM pacientes WHERE (nome = '"+ nome +"') AND (nascimento = '"+ nascimento +"'";
  	}
  	else if(nascimento != "" & sx != ""  & end == "") {
 	     sql = "SELECT id, nome, nascimento, sexo, endereço, telefone FROM pacientes WHERE (nome = '"+ nome +"') AND (nascimento = '"+ nascimento +"') AND (sexo = '"+ sx +"')";
  	}
  	else if(nascimento != "" & sx != "" & end != "") {
	     sql = "SELECT id, nome, nascimento, sexo, endereço, telefone FROM pacientes WHERE (nome = '"+ nome +"') AND (nascimento = '"+ nascimento +"') AND (sexo = '"+ sx +"') AND (sexo = '"+ end +"')";
 	}
  	else if(nascimento != "" & sx != "" & end != "" & Tel != "") {
	     sql = "SELECT id, nome, nascimento, sexo, endereço, telefone FROM pacientes WHERE (nome = '"+ nome +"') AND (nascimento = '"+ nascimento +"') AND (sexo = '"+ sx +"') AND (sexo = '"+ end +"') AND (Tel = '"+ Tel +"')";
	}
 
  	try {
  	     Connection connection = DriverManager.getConnection(url1, user, password);
  	        	        
  	     Statement statment = connection.createStatement();
  	     ResultSet result = statment.executeQuery(sql);
  	     	     
  	     int count = 0;
  	        		
  	     while (result.next()) {
  	      	String id1 = result.getString(1);
  	       	String nome1 = result.getString(2);
  	       	String nascimento1 = result.getString(3);
  	       	String sexo1 = result.getString(4);
  	       	String endereco = result.getString(5);
	       	String telefone = result.getString(6);
  	       	
  	       	count++;
  	       	System.out.println("Paciente ID: n°" + id1 + " | " + nome1 + " | " + nascimento1+ " | " + sexo1 + " | " + endereco + " | " + telefone + " | ");
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
	
	
	
	//'3', 'Rosely Farias Da Silva', '1969-10-02', 'F', '62999741955', 'Rua 7 | 284 | Bairro Das Flores'

	

