package es.ceracloud.users.server.internal;

import com.google.web.bindery.requestfactory.shared.Locator;

import es.ceracloud.users.server.UsersDao;
import es.ceracloud.users.server.domain.User;

public class UsersLocator extends Locator<User, Long> {

	@Override
	public User create(Class<? extends User> clazz) {
		return new User();
	}

	@Override
	public User find(Class<? extends User> clazz, Long id) {
		UsersDao dao = new UsersDaoImpl();
		return dao.findByID(id);
	}

	@Override
	public Class<User> getDomainType() {
		return User.class;
	}

	@Override
	public Long getId(User domainObject) {
		return domainObject.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(User domainObject) {
		return null;
	}

}
