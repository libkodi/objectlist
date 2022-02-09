package io.github.libkodi.objectlist;

import java.util.Iterator;
import java.util.Map.Entry;

import io.github.libkodi.objectlist.withexpires.PeriodMap;

public class PeriodMapTest {
	public static void main(String[] args) throws InterruptedException {
		PeriodMap<String> map = new PeriodMap<String>();
		long start = System.currentTimeMillis();
		long now;
		
		map.put("a", "a", 30, 60);
		map.put("b", "b", 60, 40);
		map.put("c", "c", 0, 120);
		map.put("d", "d", 30, 300);
		map.put("e", "e");
		
		while (true) {
			Thread.sleep(1000);
			
			map.update();
			now = System.currentTimeMillis();
			
			System.out.println("---------- 时间经过(" + ((now - start) / 1000) + "s) ----------");
			Iterator<Entry<String, String>> iter = map.iterator();
			
			while (iter.hasNext()) {
				Entry<String, String> item = iter.next();
				String key = item.getKey();
				System.out.println(String.format("%s    online!", key));
				
				if (key.equals("d")) { // 更新 d
					map.get(key);
				}
			}
			
			System.out.println("\n\n\n\n\n");
		}
	}
}
