package test;

import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		Set<Integer> result = new HashSet<Integer>();
		Set<Integer> set1 = new HashSet<Integer>(){{
			add(1);
			add(3);
			add(5);
		}};
		
		Set<Integer> set2 = new HashSet<Integer>(){{
			add(1);
			add(2);
			add(3);
		}};
		
		result.clear();
		result.addAll(set1);
		result.retainAll(set2);
		System.out.println("交集："+result);
		
		result.clear();
		result.addAll(set1);
		result.removeAll(set2);
		System.out.println("差集："+result);
		
		result.clear();
		result.addAll(set1);
		result.addAll(set2);
		System.out.println("并集："+result);
		
	}

}
14:25:32

package vocabulary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class FileUtil {
	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader1 = new BufferedReader(new FileReader("freya.txt"));
			BufferedReader bufferedReader2 = new BufferedReader(new FileReader("lifenying.txt"));
			int fileNum1=0,fileNum2=0,Num3=0;
			Set<String> set = new HashSet<String>();
			Set<String> set1 = new HashSet<String>();
			Set<String> set2 = new HashSet<String>();
			set1 = fileToSet(bufferedReader1);
			set2 = fileToSet(bufferedReader2);
			
			set.clear();
			set.addAll(set1);
			set.retainAll(set2);
			System.out.print("交集：" + set);
			System.out.println();
			for(int i = 0; i < set.size(); i ++) {
				Num3++;
			}
			set.clear();
			set.addAll(set1);
			set.addAll(set2);
			System.out.print("并集：" + set);
			System.out.println();
			
			for(int i = 0; i < set1.size(); i ++) {
				fileNum1++;
			}
			for(int i = 0; i < set2.size(); i ++) {
				fileNum2++;
			}
			System.out.print("两个文件词汇表中各自包含单词总数分别为：" +(float)Num3/fileNum1 + "," + (float)Num3/fileNum2);
			System.out.println();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Set<String> fileToSet(BufferedReader bufferedReader) {
		Set<String> result = new HashSet<String>();
		String line;
		try {
			while((line= bufferedReader.readLine()) != null) {
				String str[] = line.split("\\W+");
				for (String s : str) {
					if(!result.contains(s)) {
						result.add(s);
					}
				}		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
	
}
