package vocabulary;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
	public static void main(String[] args) throws Exception {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		File file1 = new File("sun.txt");
		File file2 = new File("cong.txt");
		BufferedReader bufr1 = new BufferedReader(new FileReader(file1));
		BufferedReader bufr2 = new BufferedReader(new FileReader(file2));		
		int count1 = 0,count2 = 0,count3=0;
		float perc1,perc2;
		String line;
		while((line= bufr1.readLine()) != null) {
			String str[] = line.split("\\W+");
			for (String string : str) {
				if(!map.containsKey(string)) {
					map.put(string, 1);
				}
				count1 ++;
			}
			
		}
		while((line= bufr2.readLine()) != null) {
			String str[] = line.split("\\W+");
			for(String string :str) {
				if(!map.containsKey(string)) {
					map.put(string, 1);
				}else {
					map.put(string, map.get(string) + 1);
				}
				count2++;
			}
			
		}
		System.out.print("两个文件中总共的词汇表有：");
		for(String key : map.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println();
		System.out.print("两个文件中都出现的单词词汇表有：");
		Iterator<Entry<String, Integer>> it = map.entrySet().iterator();  
		while (it.hasNext()) {  
		    Map.Entry<String, Integer> entry = it.next(); 
		    if(entry.getValue() != 1) {
		    	System.out.print(entry.getKey() + " "); 
		    	count3++;
		    }
		}  
		
		System.out.println();
		perc1 = ComputePercent(count3,count1);
		perc2 = ComputePercent(count3,count2);
		System.out.print("两个文件词汇表的交集词汇占各文件单词总数分别为：" + perc1 * 100 + "%" + "," + perc2 * 100 + "%");
		System.out.println();
		
	}
	public static float ComputePercent(int a ,int b) {
		float result = (float)a/b;
		return result;
	}
}
