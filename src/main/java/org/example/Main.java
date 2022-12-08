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
            //신규 등록
            /*
            Member member = new Member();
            member.setId(2L);
            member.setName("전명진");
            em.persist(member);
            */

            //조회
            /*
            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());
            */

            //수정
            /*
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("김유경");
            */

            //삭제
            /*Member findMember = em.find(Member.class, 1L);
            em.remove(findMember);*/

            //JPQL ( 객체를 대상으로 검색하는 객체 지향 쿼리 )
            /*List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1) //페이지네이션
                    .setMaxResults(10)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }*/

            //영속성 컨텍스트
            /*
            //비영속
            Member member = new Member();
            member.setId(3L);
            member.setName("임연주");

            //영속
            // 1차 캐시에 저장
            em.persist(member);

            // 1차 캐시에 있는 것을 먼저 가져옴
            Member findMember1 = em.find(Member.class, 3L);*/

            // 첫번째는 디비에서 조회가 되야하고 두번쨰는 1차캐시에서 가져온다.
            // DB에서 조회해서 1차 캐시에 저장하고 반환
            /*Member findMember1 = em.find(Member.class, 3L);
            // 이미 조회해서 1차 캐시에 저장한 값이 있기 때문에 1차 캐시에서 반환
            Member findMember2 = em.find(Member.class, 3L);

            System.out.println("id : "  + findMember1.getId());
            System.out.println("name : " + findMember1.getName());

*/
            /*Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L, "B");

            // 1차 캐시와 SQL 저장소에 있음.
            em.persist(member1);
            em.persist(member2);

            System.out.println("====================");

            //커밋을 해야 실제 DB에 저장됨.
            tx.commit();*/

            //데이터 변경
            /*Member findMember = em.find(Member.class, 2L);
            findMember.setName("ZZZZZ");

            System.out.println("===========================");*/

            // 필드와 컬럼맵핑
            /*Member member = new Member();
            member.setId(300L);
            member.setUsername("임연주");
            member.setRoleType(RoleType.USER);

            em.persist(member);*/

            Member member = new Member();
            member.setId(100L);
            member.setUsername("임연주");

            em.persist(member);

            tx.commit();

        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}