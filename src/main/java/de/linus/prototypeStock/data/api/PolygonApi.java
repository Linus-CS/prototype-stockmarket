package de.linus.prototypeStock.data.api;

import io.polygon.kotlin.sdk.rest.PolygonRestClient;
import io.polygon.kotlin.sdk.rest.reference.SupportedTickersParametersBuilder;
import io.polygon.kotlin.sdk.rest.reference.TickersDTO;

public class PolygonApi {

	public static String polygonKey = "b3N7YnEScjr2GYDcnmq7zwhKjnWlrPyv";

	public PolygonApi() {
		PolygonRestClient client = new PolygonRestClient(polygonKey);
		TickersDTO tickers = client.getReferenceClient().getSupportedTickersBlocking(new SupportedTickersParametersBuilder().search("AA").tickersPerPage(50).build());
		System.out.println(tickers);
	}

	public void connect() {

	}
}
