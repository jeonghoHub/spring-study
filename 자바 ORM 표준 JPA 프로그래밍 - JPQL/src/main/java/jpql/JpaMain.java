package jpql;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Team team = new Team();
            team.setName("팀A");
            em.persist(team);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member = new Member();
            member.setUsername("회원1");
            member.setTeam(team);
            em.persist(member);

            Member member1 = new Member();
            member1.setUsername("회원2");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원3");
            member2.setTeam(teamB);
            em.persist(member2);

            em.flush();
            em.clear();

            String query = "select m from Member m join fetch m.team";

            List<Member> resultList = em.createQuery(query, Member.class)
                    .getResultList();

            for (Member member3 : resultList) {
                System.out.println("member = " + member3.getUsername() + "| team = " + member3.getTeam().getName());
            }

//            for (Team team1 : resultList) {
//                System.out.println("team = " + team1.getName() + "|" + team1.getMembers().size());
//                for(Member member4 : team1.getMembers()) {
//                    System.out.println("-> member = " + member4);
//                }
//            }

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
