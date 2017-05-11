package com.springhbn.service.stock;

import java.util.List;

import com.springhbn.model.Stock;

public interface StockService {

	public int save(Stock stock);
	public int saveOneToOne(Stock stock);
	public List<Stock> findAll();
}
