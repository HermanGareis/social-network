package net.datastructures;

import java.util.ArrayList;
import java.util.List;

public class TestFrecuencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String wr[] = { "while", "for", "if", "for", "static", "while", "public" };

		TreeMap<Integer, List<String>> frec = wordFrec(wr);

		for (Entry<Integer, List<String>> f : frec.entrySet())
			System.out.println("Frecuencia: " + f.getKey() + " Palabras: " + f.getValue());
	}

	public static TreeMap<Integer, List<String>> wordFrec(String[] words) {		
		TreeMap<String, Integer> count = new TreeMap<String, Integer>();
		Integer c;
		for (String s : words)
			if ((c = count.get(s)) != null)
				count.put(s, c + 1);
			else
				count.put(s, 1);

		TreeMap<Integer, List<String>> frec = new TreeMap<Integer, List<String>>();
		List<String> l;
		for (Entry<String, Integer> i : count.entrySet())
			if ((l = frec.get(i.getValue())) != null) 			
				l.add(0, i.getKey());
			else {
				l = new ArrayList<String>();
				l.add(0, i.getKey());
				frec.put(i.getValue(), l);
				
			}
		return frec;
	}

}


/*while = 2
for = 2
if  = 1
public = 1
static = 1*/