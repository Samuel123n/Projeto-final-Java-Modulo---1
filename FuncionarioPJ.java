package RescisaoTrabalhista;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FuncionarioPJ extends Funcionario {
    private String cnpj;

    public FuncionarioPJ(String nome, double salario, LocalDate dataAdmissao,LocalDate dataDemissao, String cnpj) {
        super(nome, salario, dataAdmissao, dataDemissao);
        this.cnpj = cnpj;
    }
    
    public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getCnpj() {
        return cnpj;
    }

    @Override
    public double calcularRescisao() {
        long mesesTrabalhados = ChronoUnit.MONTHS.between(getDataAdmissao(), getDataDemissao());
        double valorPago = getSalario() * mesesTrabalhados;
        double multa = valorPago * 0.2;
		return multa;
        
    }
}