package project01.sniffPro.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project01.sniffPro.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    } //아이디로 1명 찾기

    public List<User> findByName(String name) {
        return em.createQuery("select u from User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getResultList();
    } //이름으로 찾기

    public List<User> findAll() {
        return em.createQuery("select u from Users u", User.class)
                .getResultList();
    } //전체 조회
}
