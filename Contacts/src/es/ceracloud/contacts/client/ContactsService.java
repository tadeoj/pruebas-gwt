package es.ceracloud.contacts.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import es.ceracloud.contacts.shared.Contact;
import es.ceracloud.contacts.shared.ContactDetails;

@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {

	public Contact addContact(Contact contact);
	public Boolean deleteContact(String id);
	public ArrayList<ContactDetails> deleteContacts(ArrayList<String> ids);
	public ArrayList<ContactDetails> getContactDetails();
	public Contact getContact(String id);
	public Contact updateContact(Contact contact);
	
}
