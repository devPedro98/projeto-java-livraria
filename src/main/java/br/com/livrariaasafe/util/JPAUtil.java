package br.com.livrariaasafe.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private JPAUtil() {
		
	}
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("livraria");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
}
