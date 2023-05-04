package RescisaoTrabalhista;

import java.time.LocalDate;

public class FuncionarioCLT extends Funcionario {
    private String cpf;

    public FuncionarioCLT(String nome,  double salario, LocalDate dataAdmissao, LocalDate dataDemissao, String cpf) {
        super(nome, salario, dataAdmissao, dataDemissao);
        this.cpf = cpf;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    
}