package es.ceracloud.gwt.StockWatcher.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("stockPrices")
public interface StockPriceService extends RemoteService {

	public StockPrice[] getPrices(String[] symbols) throws DelistedException;
	
}
