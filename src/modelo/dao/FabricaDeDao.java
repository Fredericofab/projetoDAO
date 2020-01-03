package modelo.dao;

import db.DB;
import modelo.dao.implementacao.VendedorDaoJDBC;

public class FabricaDeDao {
	
	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJDBC(DB.getConexao());
	}

}
