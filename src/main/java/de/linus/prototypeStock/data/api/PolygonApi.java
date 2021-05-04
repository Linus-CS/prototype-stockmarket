package de.linus.prototypeStock.data.api;

import java.util.ArrayList;
import java.util.List;

import io.polygon.kotlin.sdk.rest.PolygonRestClient;
import io.polygon.kotlin.sdk.rest.reference.SupportedTickersParametersBuilder;
import io.polygon.kotlin.sdk.rest.reference.TickerDTO;
import io.polygon.kotlin.sdk.rest.reference.TickersDTO;

public class PolygonApi {

	private static String polygonKey = "b3N7YnEScjr2GYDcnmq7zwhKjnWlrPyv";
	private static PolygonRestClient client = new PolygonRestClient(polygonKey);

	public PolygonApi() {
		
	}

	public static List<String> searchTickers() {
		TickersDTO tickers = client.getReferenceClient().getSupportedTickersBlocking(new SupportedTickersParametersBuilder().search("AA").tickersPerPage(50).build());
		List<String> tickerNames = new ArrayList<String>();
		for(TickerDTO ticker : tickers.getTickers()) {
			tickerNames.add(ticker.getName());
		}
		return tickerNames;
	}
}
