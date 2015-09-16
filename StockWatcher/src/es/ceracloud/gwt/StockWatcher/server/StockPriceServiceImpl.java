package es.ceracloud.gwt.StockWatcher.server;

import java.util.Random;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import es.ceracloud.gwt.StockWatcher.client.DelistedException;
import es.ceracloud.gwt.StockWatcher.client.StockPrice;
import es.ceracloud.gwt.StockWatcher.client.StockPriceService;

public class StockPriceServiceImpl extends RemoteServiceServlet implements StockPriceService {

	private static final long serialVersionUID = -7813185124632044637L;
	
	private static final double MAX_PRICE = 100.0;
	private static final double MAX_PRICE_CHANGE = 0.02;
	
	@Override
	public StockPrice[] getPrices(String[] symbols) throws DelistedException {
		Random rnd = new Random();
		
		StockPrice[] prices = new StockPrice[symbols.length];
		for (int i=0; i<symbols.length; i++) {
			
			if (symbols[i].equals("ERR")) {
	            throw new DelistedException("ERR");
	        }
			
			double price = rnd.nextDouble() * MAX_PRICE;
			double change = price * MAX_PRICE_CHANGE * (rnd.nextDouble() * 2f -1f);
			
			prices[i] = new StockPrice(symbols[i], price, change);
		}
		
		return prices;
	}
	

}
