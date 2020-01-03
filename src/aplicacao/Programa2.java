package aplicacao;

import java.util.List;
import java.util.Scanner;

import modelo.dao.DepartamentoDao;
import modelo.dao.FabricaDeDao;
import modelo.entidades.Departamento;

public class Programa2 {

	public static void main(String[] args) {

		DepartamentoDao departamentoDao = FabricaDeDao.criarDepartamentoDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== teste 01 - incluir departamento ====");
		System.out.print("Qual o nome do novo departamento ");
		String deptoInfo = sc.next();
		Departamento departamento = new Departamento(null, deptoInfo);
		departamentoDao.inserir(departamento);
		System.out.println("Inserido o departamento " + departamento.getId() );

		System.out.println("==== teste 02 - alterar departamento ====");
		System.out.print("Qual Id do departamento a ser alterado ");
		int idInfo = sc.nextInt();
		System.out.print("Qual o novo nome do departamento ");
		deptoInfo = sc.next();
		departamento = new Departamento(idInfo, deptoInfo);
		departamentoDao.atualizar(departamento);
		System.out.println("Atualizado o departamento " + departamento.getId() );

		System.out.println("==== teste 03 - deletar departamento ====");
		System.out.print("Qual Id do departamento a ser deletado ");
		idInfo = sc.nextInt();
		departamentoDao.deletarId(idInfo);
		System.out.println("Excluido o departamento ");

		System.out.println("==== teste 04 - pesquisar departamento ====");
		System.out.print("Qual Id do departamento a ser pesquisado ");
		idInfo = sc.nextInt();
		departamento = departamentoDao.pesquisarId(idInfo);
		System.out.println(departamento.toString());
		
		System.out.println("==== teste 05 - listar todos departamento ====");
		List<Departamento> lista = departamentoDao.pesquisarTodos();
		for (Departamento x : lista) {
			System.out.println(x);
		}
		
		sc.close();
	}

}
