package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MyInsertValue { 
		String id1;
		String def = "DEFAULT";
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
  		
  		System.out.println("O paciente possui comorbidades? (1) SIM (2) NAO");
  		String comorb = scanner.nextLine();
  		
  		if(comorb == "1") {
  	 	     comorb = "SIM";
  	 	}
  	  	
  	  	else {
  	  	comorb = "NAO";
  	  	}
  		
  		System.out.println("Estade de Saude atual do paciente? (1) Infectado (2) Curado (3) Internado (4)Obito");
  		String saude = scanner.nextLine();

		switch(saude) {
		case "1":	
			saude = "Infectado";
			break;
		case "2":
			saude = "Curado";
			break;
		case "3":
			saude = "Internado";
			break;
		case "4":
			saude = "Obito";
			break;
			}

  		try {    		    	  
        Connection connection = DriverManager.getConnection(url1, user, password);
        
        String sql = "INSERT INTO pacientes (id, nome, nascimento, sexo, Endereço, Telefone) VALUES (?, ?, ?, ?, ?, ?)";
                
        PreparedStatement statment = connection.prepareStatement(sql);
        statment.setString(1, null);
        statment.setString(2, nome);
        statment.setString(3, nascimento);
        statment.setString(4, sx);
        statment.setString(5, end);
        statment.setString(6, Tel);
        
        String sql1 = "SELECT id FROM pacientes";
        
        Statement statment1 = connection.createStatement();
        ResultSet result = statment1.executeQuery(sql1);
	    while (result.next()) {
	 	      this.id1 = result.getString(1);
	    }
	    
	    int idint = Integer.parseInt(id1);
	    idint++;
      
        String sql2 = "INSERT INTO quadro_Covid (id1, comorbidades, estado_saude) VALUES (?, ?, ?)";
        
        PreparedStatement statment2 = connection.prepareStatement(sql2);          
        statment2.setLong(1, idint);
        statment2.setString(2, comorb);
        statment2.setString(3, saude);
        
       

        int rows = statment.executeUpdate();
        int rows2 = statment2.executeUpdate();
        if (rows > 0) {
        	System.out.println("O Paciente foi inserido ID: " + idint);  	
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

