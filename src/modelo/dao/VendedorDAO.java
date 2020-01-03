package modelo.dao;

import java.util.List;

import modelo.entidades.Vendedor;

public interface VendedorDao {

	void inserir(Vendedor objeto);
	void atualizar(Vendedor objeto);
	void deletarId(Integer id);
	Vendedor pesquisarId(Integer id);
	List<Vendedor> pesquisarTodos();

}
