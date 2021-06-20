package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MySQL {
    	String url1 = "jdbc:mysql://localhost:3308/covid";
    	String user = "root";
    	String password = "";
    	
    public static void main(String[] args) {
	    
    	Scanner scanner = new Scanner(System.in);
    	int count = 1;
    	while(count > 0) {
       	System.out.println("\n1 - Novo Paciente, 2 - Editar paciente, 3 - Excluir paciente 4 - Ver Banco de Dados 5 - Pesquisa por ID 0 - Sair");
    	int MenuInicio = scanner.nextInt();
    	scanner.nextLine();
    	
    		switch(MenuInicio) {
    		case 1:	
    			new MyInsertValue();
    			break;
    		case 2:
    			new MyUpdateValue();
    			break;
    		case 3:
    			new MyDeleteValue();
    			break;
    		case 4:
    			new MySelect();
    			break;
    		case 5:
    			new SelectID();
    			break;
    			}
    		
    		if(MenuInicio == 0) {
    			scanner.close();
    			System.exit(1);
    			}
    		}	
    	}
	}







