package es.ceracloud.users.client;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

import es.ceracloud.users.server.domain.User;
import es.ceracloud.users.server.internal.UsersLocator;

@ProxyFor(value = User.class, locator = UsersLocator.class)
public interface UserProxy extends EntityProxy {

	public Long getId();

	public String getName();

	public void setName(String name);

	public String getEmail();

	public void setEmail(String email);

}
