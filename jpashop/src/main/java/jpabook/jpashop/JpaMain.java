package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabook.jpashop.domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-basic");
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        try {
//            itemSetUp(em);
//            memberSetUp(em);
//            Member member1 = em.find(Member.class, 1L);
//            Item item1 = em.find(Item.class, 1L);
//
//            Order order = Order.builder()
//                    .member(member1)
//                    .orderDateTime(LocalDateTime.now())
//                    .status(OrderStatus.ORDER)
//                    .build();
//            em.persist(order);
//
//            OrderItem orderItem1 = OrderItem.builder()
//                    .item(item1)
//                    .order(order)
//                    .orderPrice(item1.getPrice())
//                    .count(1)
//                    .build();
//            em.persist(orderItem1);
            Order order = em.find(Order.class, 1L);
            System.out.println("order = " + order.getId());
            System.out.println("order = " + order.getMember().getName());
            System.out.println("order = " + order.getOrderDateTime());

            for (OrderItem orderItem : order.getOrderItems()) {
                System.out.println("orderItem = " + orderItem.getOrderPrice());
                System.out.println("orderItem = " + orderItem.getCount());

                System.out.println("orderItem = " + orderItem.getItem().getName());
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void itemSetUp(EntityManager em) {
        // Item 세팅
        Item item1 = Item.builder().name("Item1").price(11000).stockQuantity(30).build();
        Item item2 = Item.builder().name("Item2").price(9000).stockQuantity(30).build();
        Item item3 = Item.builder().name("Item3").price(15000).stockQuantity(30).build();
        em.persist(item1);
        em.persist(item2);
        em.persist(item3);
    }

    public static void memberSetUp(EntityManager em) {
        Member member1 = Member.builder()
                .name("member1")
                .city("seoul")
                .street("1")
                .zipcode("1111")
                .build();
        Member member2 = Member.builder()
                .name("member2")
                .city("busan")
                .street("2")
                .zipcode("2222")
                .build();
        em.persist(member1);
        em.persist(member2);
    }
}
