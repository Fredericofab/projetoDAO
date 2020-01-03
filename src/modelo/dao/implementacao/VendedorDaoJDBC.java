package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
			
			// na posição zero não tem dados, sempre necessário o next
			//para ir para posição um.  Caso exista. 
			if (rs.next()) {
				Departamento departamento = new Departamento();
				departamento.setId(rs.getInt("DepartmentId"));
				departamento.setNome(rs.getString("DepName"));
				
				Vendedor vendedor = new Vendedor();
				vendedor.setId(rs.getInt("Id"));
				vendedor.setNome(rs.getString("name"));
				vendedor.setEmail(rs.getNString("email"));
				vendedor.setAniversario(rs.getDate("BirthDate"));
				vendedor.setSalarioBase(rs.getDouble("BaseSalary"));
				vendedor.setDepartamento(departamento);
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

	@Override
	public List<Vendedor> pesquisarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
