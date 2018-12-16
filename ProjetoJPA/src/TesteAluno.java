import java.util.List;

public class TesteAluno {

	public static void main(String[] args) {
	
		Aluno a1 = new Aluno();
		a1.setNome("Rafael Menezes");
		a1.setIdade(25);
		a1.setMatricula("1056075");
		
		AlunoController alCon = new AlunoController();
		alCon.salvar(a1);
		
		List<Aluno> alunos = alCon.listar();
		
		System.out.println("Informações dos Alunos do Banco de Dados:\n");
		
		for(Aluno al : alunos) {
			
			System.out.println("Nome: "+ al.getNome());
			System.out.println("Idade: "+ al.getIdade());
			System.out.println("Matrícula: "+ al.getMatricula());
			
		}
		

	}

}
