package aplicacao;


import java.util.Date;
import java.util.List;

import modelo.dao.FabricaDeDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

		VendedorDao vendedorDao = FabricaDeDao.criarVendedorDao();
		
		System.out.println("=== teste1: Vendedor PesquisarId ===");
		Vendedor vendedor = vendedorDao.pesquisarId(3);
		System.out.println(vendedor.toString());
		
		System.out.println();
		System.out.println("=== teste2: vendedores do Departamento ===");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vendedorDao.pesquisarPorDepartamento(departamento);
		for (Vendedor x : lista){
			System.out.println(x);
		}
	
		System.out.println();
		System.out.println("=== teste3: Todos os Vendedores   ===");
		List<Vendedor> lista3 = vendedorDao.pesquisarTodos();
		for (Vendedor x : lista3){
			System.out.println(x);
		}

		System.out.println();
		System.out.println("=== teste4: Inserindo Vendedor   ===");
		Vendedor vendedor2 = new Vendedor(null,"Ze","ze@gmail.com",new Date(),4000.00,departamento);
		vendedorDao.inserir(vendedor2);
		System.out.println("Inserido o vendedor de ID = " + vendedor2.getId());
		
	}

}
