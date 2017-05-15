package com.lru.service;

public interface LRUService<V,K> {
	
	
	public K search(V id);
	
	public void reArrange();
	
	public void print();
	

}
