package org.alg;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		//insertarRegistros("Hola, java", "Sik");
		//editarRegistros("Hola, java jav", "Sik", 4);
		eliminarRegistros(5);
		listarRegistros();	

	}
	
	static void listarRegistros() {
		try {
			Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC", "root", "generation");
			System.out.println("Conexion exitosa");
			String sql = "SELECT * FROM mensajes";
			PreparedStatement ps = conectar.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_mensaje");
				String mensaje = rs.getString("mensaje");
				String autor = rs.getString("autor");
				String fecha = rs.getString("fecha");
				System.out.printf("%d %s %s %s \n", id, mensaje, autor, fecha);
				
			}
		rs.close();
		ps.close();
		conectar.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void insertarRegistros(String mensaje, String autor) {
		try {
			Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC", "root", "generation");
			System.out.println("Conexion exitosa");
			String sql = "INSERT INTO mensajes(mensaje,autor,fecha) VALUES(?,?,current_time())";
			PreparedStatement ps = conectar.prepareStatement(sql);
			ps.setString(1, mensaje);
			ps.setString(2, autor);
			ps.executeUpdate();
			
		ps.close();
		conectar.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void editarRegistros(String mensaje, String autor, int id) {
		try {
			Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC", "root", "generation");
			//System.out.println("Conexion exitosa");
			String sql = "UPDATE mensajes SET mensaje= ?, autor= ? WHERE id_mensaje = ?;";
			PreparedStatement ps = conectar.prepareStatement(sql);
			ps.setString(1, mensaje);
			ps.setString(2, autor);
			ps.setInt(3, id);
			ps.executeUpdate();
			
		ps.close();
		conectar.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	static void eliminarRegistros(int id) {
		try {
			Connection conectar = DriverManager.getConnection("jdbc:mysql://localhost/mensajes_db?serverTimezone=UTC", "root", "generation");
			//System.out.println("Conexion exitosa");
			String sql = "DELETE FROM mensajes WHERE id_mensaje = ?;";
			PreparedStatement ps = conectar.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		ps.close();
		conectar.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


}
