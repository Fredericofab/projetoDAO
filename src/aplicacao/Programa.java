package aplicacao;

import java.util.Date;

import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

		Departamento depto = new Departamento(1, "livros");
		System.out.println(depto);

		Vendedor vendedor = new Vendedor(21, "fred", "fred@gmail.com", new Date(), 3000.01, depto);
		System.out.println(vendedor);
	}

}
