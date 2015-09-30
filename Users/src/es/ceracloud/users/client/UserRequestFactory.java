package es.ceracloud.users.client;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface UserRequestFactory extends RequestFactory {

	public UserRequestContext context();
}
