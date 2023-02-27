package com.example.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Item;
import com.example.resource.RequestItem;
import com.example.service.ItemService;

@RestController
@RequestMapping(value = "/item", produces = "application/json;chaset=UTF-8")
public class ItemController {

	private final ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("/list")
	public List<Item> list() {
		return this.itemService.findAll();
	}

	@PostMapping("/create")
	public Item create(@RequestBody RequestItem requestItem) {
		return this.itemService.insert(requestItem);
	}
}
