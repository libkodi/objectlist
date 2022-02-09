package io.github.libkodi.objectlist;

import java.util.Iterator;
import java.util.Map.Entry;

import io.github.libkodi.objectlist.ObjectList;

public class ObjectListTest {
	public static void main(String[] args) {
		pushTest();
		unshiftTest();
	}

	private static void unshiftTest() {
		System.out.println("--------------- unshift test ----------------\n");
		
		ObjectList<String, Integer> obj = new ObjectList<String, Integer>();
		
		obj.unshift("a", 1);
		obj.unshift("a", 2);
		obj.unshift("a", 6);
		obj.unshift("a", 7);
		obj.unshift("b", 3);
		obj.unshift("c", 4);
		obj.push("d", 5);
		
		System.out.println(obj.get("a"));
		
		Iterator<Entry<String, Integer>> iter = obj.iterator();
		
		while (iter.hasNext()) {
			Entry<String, Integer> item = iter.next();
			
			System.out.println(item.getKey() + ":" + item.getValue() + "");
		}
		
		obj.unshift("d", 100);
		
		Iterator<Entry<String, Integer>> iter_back = obj.iterator(true);
		
		while (iter_back.hasNext()) {
			Entry<String, Integer> item = iter_back.next();
			
			System.out.println("back-" +  item.getKey() + ":" + item.getValue() + "");
		}
		
		System.out.println("--------------- unshift test end ----------------\n");
	}

	private static void pushTest() {
		System.out.println("--------------- push test ----------------\n");
		
		ObjectList<String, Integer> obj = new ObjectList<String, Integer>();
		
		obj.push("a", 1);
		obj.push("a", 2);
		obj.push("b", 3);
		obj.push("c", 4);
		obj.unshift("d", 5);
		
		System.out.println(obj.get("a"));
		
		Iterator<Entry<String, Integer>> iter = obj.iterator();
		
		while (iter.hasNext()) {
			Entry<String, Integer> item = iter.next();
			
			System.out.println(item.getKey() + ":" + item.getValue() + "");
		}
		
		obj.push("d", 100);
		
		Iterator<Entry<String, Integer>> iter_back = obj.iterator(true);
		
		while (iter_back.hasNext()) {
			Entry<String, Integer> item = iter_back.next();
			
			System.out.println("back-" +  item.getKey() + ":" + item.getValue() + "");
		}
		
		System.out.println("--------------- push test end ----------------\n");
	}
}
