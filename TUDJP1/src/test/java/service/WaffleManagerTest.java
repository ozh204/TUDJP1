package service;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaffleManagerTest
{
    WaffleManager waffleManager = new WaffleManager();

    @Test
    public void checkConnection()
    {
        assertNotNull(waffleManager.getConnection());
    }
}
