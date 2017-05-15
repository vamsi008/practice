package com.lru;

import com.lru.pojo.LRUPojo;
import com.lru.service.LRUService;
import com.lru.service.LRUServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		LRUService<Integer,LRUPojo> lruCache=new LRUServiceImpl();
		
		lruCache.search(1);
		lruCache.search(2);
		lruCache.search(3);
		lruCache.search(4);
		lruCache.search(5);
		lruCache.search(6);
		lruCache.search(2);
		lruCache.search(7);
		lruCache.search(1);
		lruCache.search(3);
		
		
		
		
		lruCache.print();
		
		
		
	}
}
