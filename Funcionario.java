package RescisaoTrabalhista;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Funcionario {
	private String nome;
	private double salario;
	private LocalDate dataAdmissao, dataDemissao;

	

	public Funcionario(String nome, double salario, LocalDate dataAdmissao, LocalDate dataDemissao) {
		this.nome = nome;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
	}
	
	

	public void setNome(String nome) {
		this.nome = nome;
	}







	public void setSalario(double salario) {
		this.salario = salario;
	}



	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getNome() {
		return nome;
	}



	public double getSalario() {
		return salario;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public double calcularRescisao() {
		long mesesTrabalhados = ChronoUnit.MONTHS.between(dataAdmissao, dataDemissao);
		double ferias = salario / 12 * mesesTrabalhados;
		double decimoTerceiro = salario / 12 * mesesTrabalhados;
		double multa = salario * 0.4;
		return salario + ferias + decimoTerceiro + multa;
	}
}