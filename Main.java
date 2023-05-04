package RescisaoTrabalhista;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import RescisaoTrabalhista.util.Cores;

public class Main {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Inicial();
		keyPress();
		leia.nextLine();

		System.out.println("Digite o nome do funcionário: ");
		String nome = leia.nextLine();

		System.out.println("Digite o salário do funcionário: ");
		double salario = leia.nextDouble();

		leia.nextLine();

		System.out.println("O funcionário é CLT ou PJ?('CLT/PJ'): ");
		String tipoContrato = leia.nextLine();

		if (tipoContrato.equalsIgnoreCase("CLT")) {
			System.out.println("Digite o CPF do funcionário: ");
			String cpf = leia.nextLine();

			System.out.println("Digite o cargo do funcionário: ");
			String cargo = leia.nextLine();

			System.out.println("Digite a data de admissão do funcionário (no formato dd/MM/yyyy): ");
			LocalDate dataAdmissao = LocalDate.parse(leia.nextLine(), formatter);

			System.out.println("Digite a data de demissão do funcionário (no formato dd/MM/yyyy): ");
			LocalDate dataDemissao = LocalDate.parse(leia.nextLine(), formatter);

			FuncionarioCLT funcionario = new FuncionarioCLT(nome, salario, dataAdmissao, dataDemissao, cpf);
			double rescisao = funcionario.calcularRescisao();

			MenuCLT(funcionario.getNome(), funcionario.getCpf(), cargo, rescisao);

		} else if (tipoContrato.equalsIgnoreCase("PJ")) {
			System.out.println("Digite o nome da empresa contratante: ");
			String nomeEmpresa = leia.nextLine();

			System.out.println("Digite o seu CNPJ: ");
			String cnpj = leia.nextLine();

			System.out.println("Digite o cargo do funcionário: ");
			String cargo = leia.nextLine();

			System.out.println("Digite o valor total recebido pelo funcionário: ");
			double valorTotal = leia.nextDouble();

			leia.nextLine();

			System.out.println("Digite a data de início do contrato (no formato dd/MM/yyyy): ");
			LocalDate dataInicioContrato = LocalDate.parse(leia.nextLine(), formatter);

			System.out.println("Digite a data de fim do contrato (no formato dd/MM/yyyy): ");
			LocalDate dataFimContrato = LocalDate.parse(leia.nextLine(), formatter);

			FuncionarioPJ funcionariopj = new FuncionarioPJ(nome, valorTotal, dataInicioContrato, dataFimContrato,
					nomeEmpresa);
			double rescisao = funcionariopj.calcularRescisao();

			MenuPJ(funcionariopj.getNome(), cargo, cnpj, nomeEmpresa, rescisao);

		} else {
			System.out.println("Tipo de contrato inválido!");
		}
	}

	private static void keyPress() {

		try {
			System.out.println("\n\n         Para prosseguir tecle ENTER");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}

	}

	private static void Inicial() {

		System.out.printf(Cores.TEXT_YELLOW_BOLD, Cores.ANSI_WHITE_BACKGROUND, "");
		System.out.printf("\n ----------------------------------------------  ");
		System.out.printf("\n |            CALCULO TRABALHISTA             |  ");
		System.out.printf("\n |       BEM VINDOS A CALCULADORA TRABALHISTA | ");
		System.out.printf("\n |                                            | ");
		System.out.printf("\n |      VENHA JÁ REALIZAR SEU CALCULO         |  ");
		System.out.printf("\n |      BASTA ENTRAR COM SEUS DADOS           |  ");
		System.out.printf("\n |                                            |  ");
		System.out.printf("\n ---------------------------------------------- ");

	}

	private static void MenuPJ(String nome, String cargo, String cnpj, String nomeEmpresa, double rescisao) {

		System.out.printf("\n   ---------------------------------------------  ");
		System.out.printf("\n   |            Calculo Trabalhista            |  ");
		System.out.printf("\n   ---------------------------------------------  ");
		System.out.printf("\n   | Dados do Colaborador                      | ");
		System.out.printf("\n   | Nome: %s                                  |   ", nome);
		System.out.printf("\n   | Cargo:%s                                  |   ", cargo);
		System.out.printf("\n   | CNPJ: %s                                  |   ", cnpj);
		System.out.printf("\n   | Nome da Empresa Contratante: %s           |   ", nomeEmpresa);
		System.out.printf("\n   | O Valor em R$ da sua Recisão é de: %.2f   |   ", rescisao);
		System.out.printf("\n   --------------------------------------------- ");

	}

	private static void MenuCLT(String nome, String cpf, String cargo, double rescisao) {

		System.out.printf("\n  ---------------------------------------------  ");
		System.out.printf("\n             Calculo Trabalhista                 ");
		System.out.printf("\n  Dados do Colaborador                          ");
		System.out.printf("\n  Nome: %s                                       ", nome);
		System.out.printf("\n  CPF: %s                                   ", cpf);
		System.out.printf("\n  Cargo: %s                             ", cargo);
		System.out.printf("\n  O Valor em R$ da sua Recisão é de: %.2f ", rescisao);
		System.out.printf("\n  ---------------------------------------------  ");

	}
}
