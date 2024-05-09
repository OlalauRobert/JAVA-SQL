package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaConector {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/JAVA-SQL";
		String utilizator = "root";
		String parola = "";
		try {
			Connection conexiune = DriverManager.getConnection(url,utilizator, parola);
			System.out.println("Conexiune reusita la baza de date");
		
				Statement instructiune = conexiune.createStatement();
				String sql = " SELECT * FROM produse";
				
				ResultSet rezultate = instructiune.executeQuery(sql);
				
				while(rezultate.next()) {
					String nume = rezultate.getString("nume");
				System.out.println("nume:" + nume);
		}
		
		rezultate.close();
		instructiune.close();
		conexiune.close();
		}catch(SQLException e){
			System.out.println("Eroare:" + e);
			
		}
	}
}
	
