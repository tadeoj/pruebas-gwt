package es.ceracloud.gwt.StockWatcher.client;

import java.io.Serializable;

public class DelistedException extends Exception implements Serializable {

	private static final long serialVersionUID = 4118854267908074610L;

	private String symbol;

	public DelistedException() {
	}

	public DelistedException(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}

}
