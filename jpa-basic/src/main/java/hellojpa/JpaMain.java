package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
            for (Member member : members) {
                System.out.println("member = " + member.getName());
            }

            System.out.println("=====================================");

            em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList()
                    .forEach(m -> {
                        System.out.println("member = " + m.getName() + ", team = " + m.getTeam().getName());
                    });

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
