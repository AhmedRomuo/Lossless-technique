/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lossless;


import java.util.*;

/**
 *
 * @author ahmed
 */
public class Shannon {
    
     public HashMap compress(HashMap freq) {
		
		HashMap<Character, String> result = new HashMap<Character, String>();
		List<Character> charList = new ArrayList<Character>();
		
		Iterator entries = freq.entrySet().iterator();
		while( entries.hasNext() ) {
			Map.Entry<Character, Integer> entry = (Map.Entry)entries.next();
			charList.add(entry.getKey());
		}
		
		addBit(result, charList, true);
		
		return result;
	}
	
	private void addBit(HashMap<Character, String> result, List<Character> charList, boolean up) {
		String bit = "";
		if( !result.isEmpty() ) {
			bit = (up) ? "0" : "1";
		}
		
		for( Character c : charList ) {
			String s = (result.get(c) == null) ? "" : result.get(c);
			result.put(c, s + bit);
		}
		
		if( charList.size() >= 2 ) {
			int separator = (int)Math.floor((float)charList.size()/2.0);
			
			List<Character> upList = charList.subList(0, separator);
			addBit(result, upList, true);
			List<Character> downList = charList.subList(separator, charList.size());
			addBit(result, downList, false);
		}
	}
}
