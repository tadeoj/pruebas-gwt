package es.ceracloud.contacts.client.view;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;

import es.ceracloud.contacts.client.common.ColumnDefinition;

public interface ContactsView<T> {

	public interface Presenter<T> {
		public void onAddButtonClicked();
		public void onDeleteButtonClicked();
		public void onItemClicked(T clickedItem);
		public void onItemSelected(T selectedItem);
	}

	public void setPresenter(Presenter<T> presenter);
	public void setColumnDefinitions(List<ColumnDefinition<T>> columnDefinitions);
	public void setRowData(List<T> rowData);
	public Widget asWidget();
	
}
