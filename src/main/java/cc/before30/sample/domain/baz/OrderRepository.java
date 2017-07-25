package cc.before30.sample.domain.baz;

import java.util.List;

/**
 * Created by before30 on 26/07/2017.
 */
public interface OrderRepository {
    Order findOne(long orderId);

    List<Order> findAll();

    List<Order> findAllById();

    Order save(Order order);

    void delete(long orderId);

    void delete(Order order);

    void deleteAll();

}
