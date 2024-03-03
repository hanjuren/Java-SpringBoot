package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
            Team team = em.find(Team.class, 1L);
            Member member10 = Member.builder()
                    .name("member10")
                    .team(team)
                    .build();
            em.persist(member10);

            for (Member member : team.getMembers()) {
                System.out.println("member = " + member.getName() + ", " + member.getId());
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
