package vocabulary;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
	public static void main(String[] args) throws Exception {
		File f1 = new File("1.txt");
		File f2 = new File("2.txt");
		
		BufferedReader br1 = new BufferedReader(new FileReader(f1));
		BufferedReader br2 = new BufferedReader(new FileReader(f2));
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		String line;
		int count1 = 0,count2 = 0;
		while((line= br1.readLine()) != null) {
			String str[] = line.split("\\W+");
			for (String s : str) {
				if(!map.containsKey(s)) {
					map.put(s, 1);
				}
				count1 ++;
			}
			
		}
		while((line= br2.readLine()) != null) {
			String str[] = line.split("\\W+");
			for(String s :str) {
				if(!map.containsKey(s)) {
					map.put(s, 1);
				}else {
					map.put(s, 2);
				}
				count2++;
			}
			
		}
		System.out.print("�����ļ��ܹ��Ĵʻ���У�");
		for(String key : map.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println();
		System.out.print("ͬʱ�����������ļ��еĽ������ʴʻ���У�");
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();  
		while (it.hasNext()) {  
		    Map.Entry<String, Integer> entry = it.next(); 
		    if(entry.getValue() == 2) {
		    	System.out.print(entry.getKey() + " ");  
		    }
		}  
		System.out.println();
		System.out.print("�����ļ��ʻ���и��԰������������ֱ�Ϊ��" + count1 + "," + count2);
		System.out.println();
		
	}
}
