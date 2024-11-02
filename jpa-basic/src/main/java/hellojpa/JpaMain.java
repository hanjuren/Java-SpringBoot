package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            Member reference = em.getReference(Member.class, 1L);
            System.out.println("reference = " + reference.getClass());

            Member findMember1 = em.find(Member.class, 1L);
            System.out.println("findMember1 = " + findMember1.getClass());

            em.clear();

            Member findMember2 = em.getReference(Member.class, 1L);
            System.out.println("findMember2 = " + findMember2.getClass());
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(findMember2));
            Hibernate.initialize(findMember2);
            System.out.println("findMember2 = " + findMember2.getClass());
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(findMember2));
//            em.clear();
//            System.out.println("findMember2 = " + findMember2.getName()); // org.hibernate.LazyInitializationException
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
