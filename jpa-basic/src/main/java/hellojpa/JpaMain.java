package hellojpa;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Member member = new Member();
        member.setId(1L);
        member.setName("HelloA");

        em.persist(member);

        transaction.commit();

        em.close();
        emf.close();
    }
}
