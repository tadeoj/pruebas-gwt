package es.ceracloud.users.server.internal;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

public class DaoLocator implements ServiceLocator {

	@Override
	public Object getInstance(Class<?> clazz) {
		return new UsersDaoImpl();
	}

}
