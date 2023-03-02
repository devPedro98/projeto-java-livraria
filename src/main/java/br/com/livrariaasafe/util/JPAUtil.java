package br.com.livrariaasafe.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private JPAUtil() {

	}

	private static EntityManagerFactory factory;

	public static EntityManager getEntityManager() {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("livraria");
		}
		return factory.createEntityManager();
	}
}
