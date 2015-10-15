package es.ceracloud.users.server.internal;

import es.ceracloud.users.server.UsersDao;
import es.ceracloud.users.server.domain.User;

public class UsersDaoImpl implements UsersDao {

	@Override
	public User findByID(Long id) {
		User user = new User();
		if (id == 1) {
			user.setId((long) 1);
			user.setName("Tadeo");
			user.setEmail("tadeo.julian@gmail.com");
		}
		return user;
	}

	@Override
	public void save(User user) {

	}

}
