package aplicacao;

/**
 * IFPB - TSI - PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
import jakarta.persistence.EntityManager;
import modelo.Jogo;
import modelo.Time;

public class Cadastrar {
	private EntityManager manager;

	public Cadastrar() {
		try {
			manager = Util.conectarBanco();
			System.out.println("Cadastrando");

			Time t1;
			manager.getTransaction().begin();
			t1 = new Time ("Brasil", "br");
			manager.persist(t1);
			manager.getTransaction().commit();
			
			Time t2;
			manager.getTransaction().begin();
			t2 = new Time("Argentina", "ar");
			manager.persist(t2);
			manager.getTransaction().commit();
			
			Time t3;
			manager.getTransaction().begin();
			t3 = new Time ("França", "fr");
			manager.persist(t3);
			manager.getTransaction().commit();
			
			Time t4;
			manager.getTransaction().begin();
			t4 = new Time ("Espanha", "es");
			manager.persist(t4);
			manager.getTransaction().commit();
			
			Jogo j1;
			manager.getTransaction().begin();
			j1 = new Jogo ("11/04/2023", "Inglaterra", 10000, 20.0);
			j1.setTime1(t1);
			j1.setTime2(t2);
			t1.adicionar(j1);
			t2.adicionar(j1);
			manager.persist(j1);
			manager.merge(t1);
			manager.merge(t2);
			manager.getTransaction().commit();
			
			Jogo j2;
			manager.getTransaction().begin();
			j2 = new Jogo ("11/04/2023", "Espanha", 10000, 20.0);
			j2.setTime1(t1);
			j2.setTime2(t3);
			t1.adicionar(j2);
			t3.adicionar(j2);
			manager.persist(j2);
			manager.merge(t1);
			manager.merge(t3);
			manager.getTransaction().commit();
			
			Jogo j3;
			manager.getTransaction().begin();
			j3 = new Jogo ("11/04/2023", "Espanha", 10000, 20.0);
			j3.setTime1(t2);
			j3.setTime2(t3);
			t2.adicionar(j3);
			t3.adicionar(j3);
			manager.persist(j3);
			manager.merge(t2);
			manager.merge(t3);
			manager.getTransaction().commit();
			
			Jogo j4;
			manager.getTransaction().begin();
			j4 = new Jogo ("11/04/2023", "Brasil", 10000, 20.0);
			j4.setTime1(t4);
			j4.setTime2(t3);
			t2.adicionar(j4);
			t3.adicionar(j4);
			manager.persist(j4);
			manager.merge(t4);
			manager.merge(t3);
			manager.getTransaction().commit();
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			Util.fecharBanco();
		}
		
		System.out.println("fim do programa");
	}

	// =================================================
	public static void main(String[] args) {
		new Cadastrar();
	}

}
