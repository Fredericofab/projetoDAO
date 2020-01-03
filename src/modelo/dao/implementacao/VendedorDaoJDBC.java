package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJDBC implements VendedorDao {

	private Connection conexao;
	public VendedorDaoJDBC(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	@Override
	public void inserir(Vendedor objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Vendedor objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor pesquisarId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("SELECT seller.*,department.Name as DepName "
										+ "FROM   seller, department "
										+ "WHERE  seller.DepartmentId = department.Id "
										+ "AND    seller.Id = ? ");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				// essas funcoes auxiliares foram criada apenas para deixar o codigo mais limpo aqui
				Departamento departamento = instanciaDepartamento(rs);
				Vendedor vendedor = instanciaVendedor(rs, departamento);
				return vendedor;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

	private Vendedor instanciaVendedor(ResultSet rs, Departamento departamento) throws SQLException {
		//funcao criada apenas para deixar o codigo que chamou mais "limpo"
		Vendedor vendedor = new Vendedor();
		vendedor.setId(rs.getInt("Id"));
		vendedor.setNome(rs.getString("name"));
		vendedor.setEmail(rs.getNString("email"));
		vendedor.setAniversario(rs.getDate("BirthDate"));
		vendedor.setSalarioBase(rs.getDouble("BaseSalary"));
		vendedor.setDepartamento(departamento);
		return vendedor;
	}


	private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {
		//funcao criada apenas para deixar o codigo que chamou mais "limpo"
		Departamento departamento = new Departamento();
		departamento.setId(rs.getInt("DepartmentId"));
		departamento.setNome(rs.getString("DepName"));
		return departamento;
	}


	@Override
	public List<Vendedor> pesquisarTodos() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Vendedor> pesquisarPorDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conexao.prepareStatement("SELECT seller.*,department.Name as DepName "  
										+ "FROM seller , department " 
										+ "WHERE seller.DepartmentId = department.Id "  
										+ "AND DepartmentId = ? "  
										+ "ORDER BY Name ");
			st.setInt(1, departamento.getId());
			rs = st.executeQuery();
			
			List<Vendedor> lista = new ArrayList<Vendedor>();
			Map<Integer, Departamento> map = new HashMap<>();
			while (rs.next()) {
				
				Departamento depto = map.get(rs.getInt("DepartmentId"));
				if ( depto == null ) {
					depto = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), depto);
				}
				Vendedor vendedor = instanciaVendedor(rs, depto);
				lista.add(vendedor);
			}
			return lista;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
		}
	}

}
