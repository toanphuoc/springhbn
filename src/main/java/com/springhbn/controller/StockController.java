package com.springhbn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springhbn.model.Stock;
import com.springhbn.service.stock.StockService;

@Controller
public class StockController {

	@Autowired
	StockService stockService;
	
	@RequestMapping(value = "/addStockManyToMany", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Stock addStockManyToMany(@RequestBody Stock stock) {	
		int id = stockService.save(stock);
		stock.setId(id);
		return stock;
	}
	
	@RequestMapping(value = "/addStockOneToOne", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Stock addStockOneToOne(@RequestBody Stock stock) {	
		int id = stockService.saveOneToOne(stock);
		stock.setId(id);
		return stock;
	}
	
	@RequestMapping(value = "/getAllStock", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Stock> getAll() {
		return stockService.findAll();
	}
}
