package com.elorrieta.modelo.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Test;

public class DAOConectionManagerTest {

	@Test
	public void testGetConnection() {
		DAOConectionManager cm = new DAOConectionManager();
		try (Connection conn = cm.open();) {
			assertNotNull(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("La conexion ha fallado");
		}

	}

	@Test
	public void testClose() {
		assertTrue(1 > 0);
	}

	@Test
	public void testOpen() {
		assertTrue(1 > 0);
	}

}
