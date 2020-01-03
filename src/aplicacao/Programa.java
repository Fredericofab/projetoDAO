package aplicacao;

import java.util.List;

import modelo.dao.FabricaDeDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

		/*
		Departamento depto = new Departamento(1, "livros");
		System.out.println(depto);

		Vendedor vendedor = new Vendedor(21, "fred", "fred@gmail.com", new Date(), 3000.01, depto);
		System.out.println(vendedor);
		*/		
		
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
		
	}

}
