package com.unical.unitransport.controller.persistence.shipment.state;

public interface StatePattern{
	
	public StatePattern precedente();
	public StatePattern successivo();
	public int getStato();
	

}
