package service;

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

    @Test
    public void checkConnection()
    {
        assertNotNull(waffleManager.getConnection());
    }

    @Before
    @Test
    public void checkAdding()
    {
    	waffleManager.clearWaffles();
    	Waffle waffle = new Waffle("Suchy",3.5,"Brak","Nie","Nie","Brak");
    	assertEquals(1,waffleManager.addWaffle(waffle));
    	
    	Waffle waffle2 = new Waffle("Z cukrem pudrem",4,"Brak","Tak","Nie","Brak");
    	assertEquals(1,waffleManager.addWaffle(waffle2));
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
    public void checkJoin()
    {

    }

    @After
    @Test
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
