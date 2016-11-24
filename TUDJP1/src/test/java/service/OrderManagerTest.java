package service;

import domain.Order;
import org.junit.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class OrderManagerTest
{
    OrderManager orderManager = new OrderManager();

    @Test
    public void checkConnection()
    {
        assertNotNull(orderManager.getConnection());
    }

    @Before
    public void checkAdding()
    {
        orderManager.clearOrders();
        Order order = new Order(Date.valueOf("1999-10-10"),3.5);
        assertEquals(1,orderManager.addOrder(order));

        Order order2 = new Order(Date.valueOf("1997-07-07"),7.5);
        assertEquals(1,orderManager.addOrder(order2));
    }

    @Test
    public void checkAll()
    {
        List<Order> orders = orderManager.getAllOrders();
        assertEquals(2,orders.size());
    }

    @Test
    public void checkModifying() throws SQLException
    {
        List<Order> orders = orderManager.getAllOrders();
        Order order = orders.get(0);
        assertEquals(3.5, order.getPrice(),0);

        order.setPrice(9.5);
        orderManager.modifyPrice(order);

        order = orderManager.getOrderById(order.getId());
        assertEquals(9.5, order.getPrice(), 0);
    }

    @After
    public void checkDeleting() throws SQLException
    {
        List<Order> orders = orderManager.getAllOrders();
        Integer size = orders.size();
        Order order = orders.get(0);
        Integer id = order.getId();


        assertEquals(1, orderManager.delete(id));
        order = orderManager.getOrderById(id);
        assertEquals(null, order.getId());
        orders = orderManager.getAllOrders();
        assertEquals(size - 1, orders.size());
    }

}
