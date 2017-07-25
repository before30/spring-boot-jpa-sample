package cc.before30.sample.domain.baz;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by before30 on 26/07/2017.
 */
@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public Order findOne(long orderId) {
        return entityManager.find(Order.class, orderId);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>)entityManager.createQuery("SELECT o FROM Order o").getResultList();
    }

    @Override
    public List<Order> findAllById() {
        return (List<Order>)entityManager.createQuery("SELECT o FROM Order o order by o.orderId").getResultList();
    }

    @Override
    public Order save(Order order) {
        if (findOne(order.getOrderId()) != null) {
            entityManager.merge(order);
        } else {
            entityManager.persist(order);
        }

        return order;
    }

    @Override
    public void delete(long orderId) {
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.orderId = ?1");
        query.setParameter(1, orderId);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void delete(Order order) {
        //????
        entityManager.remove(entityManager.contains(order) ? order : entityManager.merge(order));
    }

    @Override
    public void deleteAll() {
        for (Order order : findAll()) {
            delete(order);
        }
    }

    /*
        @Override
    public Order selectById(final long orderId) {
        return entityManager.find(Order.class, orderId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> selectAll() {
        return (List<Order>) entityManager.createQuery("SELECT o FROM Order o").getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Order> selectOrderBy() {
        return (List<Order>) entityManager.createQuery("SELECT o FROM Order o order by o.orderId").getResultList();
    }

    @Override
    public void create(final Order order) {
        entityManager.persist(order);
    }

    @Override
    public void update(final Order order) {
        Query query = entityManager.createQuery("UPDATE Order o SET o.status = ?1 WHERE o.orderId = ?2 AND o.userId = ?3");
        query.setParameter(1, order.getStatus());
        query.setParameter(2, order.getOrderId());
        query.setParameter(3, order.getUserId());
        query.executeUpdate();
    }

    @Override
    public void delete(final long orderId) {
        Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.orderId = ?1 AND o.userId = 51");
        query.setParameter(1, orderId);
        query.executeUpdate();
    }
     */
}
