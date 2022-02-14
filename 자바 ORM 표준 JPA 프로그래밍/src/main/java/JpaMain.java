import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setName("member1");
            member.setHomeAddress(new Address("homecity", "street","10000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressesHistory().add(new AddressEntity("old1", "street","10000"));
            member.getAddressesHistory().add(new AddressEntity("old2", "street","10000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("======== START =======");
            Member findMember = em.find(Member.class, member.getId());
            AddressEntity addressEntity = em.find(AddressEntity.class, 2L);
            addressEntity.setAddress(new Address("newcity3","street","10000"));

            em.remove(findMember);
//
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressesHistory().remove(new Address("old1", "street","10000"));
//            findMember.getAddressesHistory().remove(new Address("newCity1", "street","10000"));

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
