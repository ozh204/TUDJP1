package service;

import org.junit.Test;
import static org.junit.Assert.*;

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
}
