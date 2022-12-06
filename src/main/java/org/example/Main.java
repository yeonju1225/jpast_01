package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //엔티티 메니저 : 웹서버가 올라오는 시점에 DB당 하나만 생성.
        //쓰레드간에 공유 절대 금지 ( 사용하고 버려야 함 )
        //모든 데이터 변경은 트랜잭션 안에서 실행.
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");

        EntityManager em =  emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*
            //신규 등록
            Member member = new Member();
            member.setId(2L);
            member.setName("전명진");
            em.persist(member);
            */

            /*
            //조회
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            */

            /*
            //수정
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("김유경");
            */

            //삭제
            /*Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);*/

            //JPQL ( 객체를 대상으로 검색하는 객체 지향 쿼리 )
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) //페이지네이션
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}