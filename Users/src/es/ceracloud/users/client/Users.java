package es.ceracloud.users.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class Users implements EntryPoint {

	private UserRequestFactory requestFactory;

	@Override
	public void onModuleLoad() {

		final Label label = new Label("");

		VerticalPanel panel = new VerticalPanel();
		panel.add(label);

		RootPanel.get().add(panel);

		final EventBus eventBus = new SimpleEventBus();
		requestFactory = GWT.create(UserRequestFactory.class);
		requestFactory.initialize(eventBus);

		UserRequestContext request = requestFactory.context();
		UserProxy user = request.create(UserProxy.class);
		user.setName("Tadeo");
		user.setEmail("tadeo.julian@gmail.com");

		Request<UserProxy> createRequest = request.findByID((long) 1);

		createRequest.fire(new Receiver<UserProxy>() {

			@Override
			public void onSuccess(UserProxy response) {
				label.setText(response.getName());
			}

		});

	}

}
