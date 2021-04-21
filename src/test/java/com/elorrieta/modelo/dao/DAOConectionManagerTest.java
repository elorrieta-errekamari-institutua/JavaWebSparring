package com.elorrieta.modelo.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Test;

public class DAOConectionManagerTest {

	@Test
	public void testGetConnection() {

		DAOConectionManager cm = DAOConectionManager.getInstance();
		try (Connection conn = cm.open(); Connection connGet = cm.getConnection();) {
			assertTrue("Conexion recuperada", connGet.isValid(0));

		} catch (Exception e) {
			e.printStackTrace();
			fail("La conexion ha fallado");
		}

	}

	@Test
	public void testClose() {

		DAOConectionManager cm = DAOConectionManager.getInstance();
		try (Connection conn = cm.open();) {
			assertNotNull(conn);
			conn.close();
			assertTrue("Conexion cerrada", cm.getConnection().isClosed());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("La conexion ha fallado");
		}
	}

	@Test
	public void testOpen() {
		DAOConectionManager cm = DAOConectionManager.getInstance();
		try (Connection conn = cm.open();) {
			assertTrue("Conexion abierta", conn.isValid(0));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("La conexion ha fallado");
		}
	}

}
