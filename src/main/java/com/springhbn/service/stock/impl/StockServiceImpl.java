package com.springhbn.service.stock.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.springhbn.dao.stock.StockDao;
import com.springhbn.model.Category;
import com.springhbn.model.Stock;
import com.springhbn.model.StockDetail;
import com.springhbn.service.stock.StockService;

public class StockServiceImpl implements StockService{

	@Autowired
	StockDao stockDao;
	
	@Override
	@Transactional
	public int save(Stock stock) {
		Category cat1 = new Category("VN", "Viet Name");
		Category cat2 = new Category("US", "United American");
		Set<Category> cats = new HashSet<Category>();
		cats.add(cat1);
		cats.add(cat2);
		stock.setCategories(cats);
		return (int) stockDao.save(stock);
	}

	@Override
	@Transactional
	public List<Stock> findAll() {
		return stockDao.findAll();
	}

	@Override
	@Transactional
	public int saveOneToOne(Stock stock) {
		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);
		return (int) stockDao.save(stock);
	}

}
