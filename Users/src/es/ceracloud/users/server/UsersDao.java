package es.ceracloud.users.server;

import es.ceracloud.users.server.domain.User;

public interface UsersDao {

	public User findByID(Long id);
	public void save(User user);
	
}
