package service;

import domain.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import domain.Waffle;

public class WaffleManagerTest
{
    WaffleManager waffleManager = new WaffleManager();

    @Before
    public void checkAdding()
    {
        waffleManager.clearWaffles();
        Waffle waffle = new Waffle("Suchy",2,3.5,"Brak","Nie","Nie","Brak");
        assertEquals(1,waffleManager.addWaffle(waffle));

        Waffle waffle2 = new Waffle("Z cukrem pudrem",3,4,"Brak","Tak","Nie","Brak");
        assertEquals(1,waffleManager.addWaffle(waffle2));
    }

    @Test
    public void checkConnection()
    {
        assertNotNull(waffleManager.getConnection());
    }

	@Test
    public void checkAll()
    {
    	List<Waffle> waffles = waffleManager.getAllWaffles();
    	assertEquals(2,waffles.size());
    }

    @Test
    public void checkModifying() throws SQLException
    {
        List<Waffle> waffles = waffleManager.getAllWaffles();
        Waffle waffle = waffles.get(0);
        assertEquals("Suchy", waffle.getType());

        waffle.setType("Bez niczego");
        waffleManager.modifyType(waffle);

        waffle = waffleManager.getWaffleById(waffle.getId());
        assertEquals("Bez niczego", waffle.getType());
    }

    @Test
    public void checkJoin() throws SQLException
    {
        OrderManager orderManager = new OrderManager();
        List<Order> orders = orderManager.getAllOrders();
        Order order = orders.get(0);
        Integer id = order.getId();

        waffleManager.clearWaffles();
        Waffle waffle = new Waffle("Test",id,3.5,"Brak","Nie","Nie","Brak");
        assertEquals(1,waffleManager.addWaffle(waffle));
        waffle = new Waffle("Test2",id,3.5,"Brak","Nie","Nie","Brak");
        assertEquals(1,waffleManager.addWaffle(waffle));

        List<Waffle> waffles = waffleManager.getWafflesFromOrder(id);
        int size = waffles.size();
        assertEquals(2,size);
        waffle = waffles.get(0);
        assertEquals(1, waffleManager.delete(waffle.getId()));

        waffles = waffleManager.getWafflesFromOrder(id);
        size = waffles.size();
        assertEquals(1,size);






        waffleManager.clearWaffles();
        waffle = new Waffle("Test",id,3.5,"Brak","Nie","Nie","Brak");
        waffleManager.addWaffle(waffle);
        waffle = new Waffle("Test2",id,3.5,"Brak","Nie","Nie","Brak");
        waffleManager.addWaffle(waffle);
        waffles = waffleManager.getWafflesFromOrder(id);
        size = waffles.size();
        assertEquals(2,size);
        waffle = waffles.get(0);

        waffleManager.deleteWaffleFromOrder(id,waffle.getId());
        waffles = waffleManager.getWafflesFromOrder(id);
        size = waffles.size();
        assertEquals(1,size);
    }

    @After
    public void checkDeleting() throws SQLException
    {
        List<Waffle> waffles = waffleManager.getAllWaffles();
        Integer size = waffles.size();
        Waffle waffle = waffles.get(0);
        Integer id = waffle.getId();

        assertEquals(1, waffleManager.delete(id));
        waffle = waffleManager.getWaffleById(id);
        assertEquals(null, waffle.getId());
        waffles = waffleManager.getAllWaffles();
        assertEquals(size - 1, waffles.size());
    }
}
