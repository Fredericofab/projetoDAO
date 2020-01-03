package aplicacao;

import java.util.Date;

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
		
		Vendedor vendedor = vendedorDao.pesquisarId(3);
		System.out.println(vendedor.toString());
		
	}

}
