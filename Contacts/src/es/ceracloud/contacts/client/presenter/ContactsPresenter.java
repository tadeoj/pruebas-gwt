package es.ceracloud.contacts.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

import es.ceracloud.contacts.client.ContactsServiceAsync;
import es.ceracloud.contacts.client.common.ColumnDefinition;
import es.ceracloud.contacts.client.common.SelectionModel;
import es.ceracloud.contacts.client.event.AddContactEvent;
import es.ceracloud.contacts.client.event.EditContactEvent;
import es.ceracloud.contacts.client.view.ContactsView;
import es.ceracloud.contacts.shared.ContactDetails;

public class ContactsPresenter implements Presenter, ContactsView.Presenter<ContactDetails> {

	private List<ContactDetails> contactDetails;
	private final ContactsServiceAsync rpcService;
	private final HandlerManager eventBus;
	private final ContactsView<ContactDetails> view;
	private final SelectionModel<ContactDetails> selectionModel;

	public ContactsPresenter(ContactsServiceAsync rpcService, HandlerManager eventBus, ContactsView<ContactDetails> view, List<ColumnDefinition<ContactDetails>> columnDefinitions) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.view = view;
		this.selectionModel = new SelectionModel<ContactDetails>();
		this.view.setPresenter(this);
		this.view.setColumnDefinitions(columnDefinitions);
	}

	public void onAddButtonClicked() {
		eventBus.fireEvent(new AddContactEvent());
	}

	public void onDeleteButtonClicked() {
		deleteSelectedContacts();
	}

	public void onItemClicked(ContactDetails contactDetails) {
		eventBus.fireEvent(new EditContactEvent(contactDetails.getId()));
	}

	public void onItemSelected(ContactDetails contactDetails) {
		if (selectionModel.isSelected(contactDetails)) {
			selectionModel.removeSelection(contactDetails);
		} else {
			selectionModel.addSelection(contactDetails);
		}
	}

	public void go(final HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
		fetchContactDetails();
	}

	public void sortContactDetails() {
		for (int i = 0; i < contactDetails.size(); ++i) {
			for (int j = 0; j < contactDetails.size() - 1; ++j) {
				if (contactDetails.get(j).getDisplayName()
						.compareToIgnoreCase(contactDetails.get(j + 1).getDisplayName()) >= 0) {
					ContactDetails tmp = contactDetails.get(j);
					contactDetails.set(j, contactDetails.get(j + 1));
					contactDetails.set(j + 1, tmp);
				}
			}
		}
	}

	public void setContactDetails(List<ContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public List<ContactDetails> getContactDetails() {
		return contactDetails;
	}

	public ContactDetails getContactDetail(int index) {
		return contactDetails.get(index);
	}

	private void fetchContactDetails() {
		rpcService.getContactDetails(new AsyncCallback<ArrayList<ContactDetails>>() {
			public void onSuccess(ArrayList<ContactDetails> result) {
				contactDetails = result;
				sortContactDetails();
				view.setRowData(contactDetails);
			}

			public void onFailure(Throwable caught) {
				Window.alert("Error fetching contact details");
			}
		});
	}

	private void deleteSelectedContacts() {
		List<ContactDetails> selectedContacts = selectionModel.getSelectedItems();
		ArrayList<String> ids = new ArrayList<String>();

		for (int i = 0; i < selectedContacts.size(); ++i) {
			ids.add(selectedContacts.get(i).getId());
		}

		rpcService.deleteContacts(ids, new AsyncCallback<ArrayList<ContactDetails>>() {
			public void onSuccess(ArrayList<ContactDetails> result) {
				contactDetails = result;
				sortContactDetails();
				view.setRowData(contactDetails);
			}

			public void onFailure(Throwable caught) {
				System.out.println("Error deleting selected contacts");
			}
		});
	}
}
