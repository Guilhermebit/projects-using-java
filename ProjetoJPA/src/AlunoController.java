import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlunoController {
	
	EntityManagerFactory emf;
	EntityManager em;
	
	public AlunoController() {
		emf = Persistence.createEntityManagerFactory("aluno");
		em = emf.createEntityManager();
		
	}
	
	public void salvar(Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remover(Aluno aluno) {
		em.getTransaction().begin();
		Query q = em.createNativeQuery("delete aluno from aluno where matricula = "+aluno.getMatricula());
		q.executeUpdate();
		em.getTransaction().commit();
		emf.close();
	}
	
	public List<Aluno> listar() {
   	 em.getTransaction().begin();
   	 Query consulta = em.createQuery("select aluno from Aluno aluno");
   	 List<Aluno> lista = consulta.getResultList();
   	 em.getTransaction().commit();
    	 em.close();
     
         return lista;

    }


}

