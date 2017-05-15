package com.lru.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.lru.pojo.LRUPojo;

public class LRUServiceImpl implements LRUService<Integer, LRUPojo> {
	public static final Integer InitialLoad = 5;

	public final List<LRUPojo> values = new ArrayList<LRUPojo>();

	public LRUServiceImpl() {

		values.add(new LRUPojo(1, "hai"));
		values.add(new LRUPojo(2, "wow"));
		values.add(new LRUPojo(3, "wow1"));
		values.add(new LRUPojo(4, "wow3"));
		values.add(new LRUPojo(5, "wow4"));
		values.add(new LRUPojo(6, "wow5"));
		values.add(new LRUPojo(7, "wow6"));
	}

	LinkedHashMap<Integer, LRUPojo> cache = new LinkedHashMap<Integer, LRUPojo>(InitialLoad, 0.75f, true);

	public LRUPojo search(Integer id) {

		LRUPojo searchObject = cache.get(id);

		if (searchObject == null) {

			for (LRUPojo temp : values) {
				if (temp.getId() == id) {
					searchObject = temp;
					cache.put(temp.getId(), temp);
					reArrange();
					System.out.println("Searched and found the element added to list");
					break;
				}
			}

		}
		List<LRUPojo> l = new ArrayList<LRUPojo>(cache.values());
		System.out.println("****************************");
		System.out.println("The recent object is ::"+l.get(0).getId());
		System.out.println("The recent object is ::"+l.get(l.size()-1).getId());
		System.out.println("****************************");
		return searchObject;
	}

	public void reArrange() {
		// TODO Auto-generated method stub

		Integer lastValue = new Integer(0);

		if (cache.size() > 5) {
			List<LRUPojo> l = new ArrayList<LRUPojo>(cache.values());
			//System.out.println("The recent object is ::"+l.get(0).getId());
			cache.remove(l.get(0).getId());
			System.out.println("Rearranged the queue as its buffer is more than required.");

		}

	}

	public void print() {
		// TODO Auto-generated method stub
		
		System.out.println("***************************************");
		for (Map.Entry<Integer, LRUPojo> entry : cache.entrySet()) {
			
			System.out.println("The key is ::"+entry.getKey());
			// ArrayList<String> value = entry.getValue();
			// now work with key and value...

		}
		
		System.out.println("***************************************");

	}

}
