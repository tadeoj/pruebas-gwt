package es.ceracloud.users.client;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

import es.ceracloud.users.server.UsersDao;
import es.ceracloud.users.server.internal.DaoLocator;

public interface UserRequestFactory extends RequestFactory {

	@Service(value = UsersDao.class, locator = DaoLocator.class)
	public interface UserRequestContext extends RequestContext {
		public Request<UserProxy> findByID(Long id);
		public Request<Void> save(UserProxy user);
	}
	
	public UserRequestContext context();
}
