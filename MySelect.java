package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySelect { {
    String url1 = "jdbc:mysql://localhost:3308/covid";
    String user = "root";
    String password = "";

	try {
        Connection connection = DriverManager.getConnection(url1, user, password);
        
        String sql = "SELECT * FROM pacientes inner join quadro_covid on pacientes.id = quadro_covid.id;";
        
        Statement statment = connection.createStatement();
        ResultSet result = statment.executeQuery(sql);
        
        int count = 0;
        		
        while (result.next()) {
        	String id = result.getString(1);
        	String nome = result.getString(2);
        	String nascimento = result.getString(3);
        	String sexo = result.getString(4);
        	String end = result.getString(5);
        	String tel = result.getString(6);
        	String comorb = result.getString(8);
        	String saude = result.getString(9);
        	count++;
        	System.out.println("Paciente n°" + id + ": " + nome + " | " + nascimento + " | " + sexo + " | " + end + " | " + tel + " | " + comorb + " | " + saude + " | ");
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