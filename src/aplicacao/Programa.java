package aplicacao;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import modelo.dao.FabricaDeDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

		VendedorDao vendedorDao = FabricaDeDao.criarVendedorDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== teste1: Vendedor PesquisarId ===");
		System.out.print("Informe o Id do vendedor a ser Pesquisado");
		int idInfo = sc.nextInt();
		Vendedor vendedor = vendedorDao.pesquisarId(idInfo);
		System.out.println(vendedor.toString());
		
		System.out.println();
		System.out.println("=== teste2: vendedores do Departamento ===");	
		System.out.print("Informe o Id do Departamento a ser Listado");
		int idDeptoInfo = sc.nextInt();
		Departamento departamento = new Departamento(idDeptoInfo, null);
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
		Vendedor vendedorX = new Vendedor(null,"Ze","ze@gmail.com",new Date(),4000.00,departamento);
		vendedorDao.inserir(vendedorX);
		System.out.println("Inserido o vendedor de ID = " + vendedorX.getId());
		
		System.out.println();
		System.out.println("=== teste5: Atualizando o Nome do Vendedor Informado   ===");
		System.out.print("Informe o Id do vendedor a ser Atualizado");
		idInfo = sc.nextInt();
		System.out.print("Informe o Novo email do vendedor");
		String emailInfo = sc.next();
		
		Vendedor vendedorY = vendedorDao.pesquisarId(idInfo);
		vendedorY.setEmail(emailInfo);
		vendedorDao.atualizar(vendedorY);
		System.out.println("Atualizado o email do vendedor");

		System.out.println();
		System.out.println("=== teste6: Deletando o Vendedor Informado  ===");
		System.out.print("Informe o Id do vendedor a ser deletado");
		idInfo = sc.nextInt();
		vendedorDao.deletarId(idInfo);
		System.out.println("Deletado o vendedor");

		sc.close();
		
	}

}
