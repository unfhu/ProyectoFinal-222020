package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataBase.ConexionDB;
import model.Pedido;

public class PedidoDAOC {
	
	
	/**
	 * Obtiene todos los pedidos de la tabla <code>Pedidos</code> de la DB.
	 * 
	 * @return un {@link List} de objetos {@link Pedido}
	 * @throws SQLException 
	 */
	public List<Pedido> listarPedidos() throws SQLException {
		//conn a db
		ConexionDB conex = new ConexionDB();
		Connection conn= conex.establecerConexion();
		Statement st = conn.createStatement();
		
		//consultamos si existe un usu y pass con los datos ingresados
		String sql = new String("SELECT * FROM pedidos");
		ResultSet rs = st.executeQuery(sql);

		//mapeo relacional objeto
		List<Pedido> listPed = new ArrayList<Pedido>();
		while (rs.next()) {
			Pedido pedido = new Pedido(rs.getInt("idpedido"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("usuario"), rs.getString("mail"), rs.getString("lugarentrega"), rs.getInt("localidad"), rs.getInt("provincia"), rs.getString("codpostal"), rs.getString("formadepago"), rs.getString("tarjtitular"), rs.getInt("tarjnumero"), rs.getString("tarjvto"), rs.getInt("tarjclave"));
			
			listPed.add(pedido);
		}
		
		return listPed;
	}

}
