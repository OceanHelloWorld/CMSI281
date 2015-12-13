import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class WordFrequencies {
/*	public WordFrequencies () {
		java.util.HashSet set = new java.util.HashSet();
	}
*/	
	public static void main ( String[] args) throws Exception {
		if (args.length == 0) {
			WordFrequencies.runCap();
		}
		else if (args[0].equals("-s")) {
			WordFrequencies.runNormal();
		}
		else if (args[0].equals("-c")) {
			WordFrequencies.runClean();
		} else if (args[0].equals("-sc")) {
			WordFrequencies.runNormalClean();
		}
		else {
			throw new IllegalAccessException();
			//?
		}
		
		
	}
	
	public static void runCap () throws Exception {
		HashMap<String,Integer> hashmap = new HashMap<String, Integer>();
		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader (System.in));
		String s = stdIn.readLine();
//		string str = "";
//		java.util.HashMap hashmap = new java.util.HashMap();
		while ( s!= null) {
			String[] keys = s.split("[^a-zA-Z0-9']");
			//splits into keys
			for (String str:keys) {
				str = str.toUpperCase().replaceAll("'","");
				int value = 1;
				if (hashmap.containsKey(str)) {
					hashmap.put(str, hashmap.get(str)+1); 
				} 
				else {
					hashmap.put(str, 1);
				}
			}
			s = stdIn.readLine(); //take next line
			ArrayList<String> arrayList = new ArrayList<String> (hashmap.keySet());
			Collections.sort(arrayList);
			for (String str:arrayList) {
//				Object obj = hashmap.get(s);
				System.out.println(str.toString() + " " + hashmap.get(str));
			}
		}
		
// need to add exceptions
	}
	
	public static void runNormal () throws Exception {
		HashMap<String,Integer> hashmap = new HashMap<String, Integer>();
		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader (System.in));
		String s = stdIn.readLine();
//		string str = "";
//		java.util.HashMap hashmap = new java.util.HashMap();
		while ( s!= null) {
			String[] keys = s.split("[^a-zA-Z0-9']");
			//splits into keys
			for (String str:keys) {
				str = str.replaceAll("'","");
//				int value = 0;
				if (hashmap.containsKey(str)) {
					hashmap.put(str, hashmap.get(str)+1); 
				} 
				else {
					hashmap.put(str, 1);
				}
			}
			s = stdIn.readLine(); //take next line
			ArrayList<String> arrayList = new ArrayList<String> (hashmap.keySet());
			Collections.sort(arrayList);
			for (String str:arrayList) {
//				Object obj = hashmap.get(s);
				System.out.println(str.toString() + " " + hashmap.get(str));

			}
		}
// need to add exceptions
	}
	
	public static void runClean () throws Exception {
		HashMap<String,Integer> hashmap = new HashMap<String, Integer>();
		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader (System.in));
		String s = stdIn.readLine();
//		String str="";
//		java.util.HashMap hashmap = new java.util.HashMap();
		while ( s!= null) {
			String[] keys = s.split("[^a-zA-Z0-9']");
			//splits into keys
			for (String str:keys) {
				str = str.toUpperCase().replaceAll("'","");
//				int value = 0;
				if (hashmap.containsKey(str)) {
//					hashmap.put(str, value++); 
				} 
				else {
					hashmap.put(str,0);
				}
			}
			s = stdIn.readLine(); //take next line
			ArrayList<String> arrayList = new ArrayList<String> (hashmap.keySet());
			Collections.sort(arrayList);
			for (String str:arrayList) {
//				Object obj = hashmap.get(s);
				System.out.println(str.toString());

			}
		}
// need to add exceptions
	}
	
		public static void runNormalClean () throws Exception {
		HashMap<String,Integer> hashmap = new HashMap<String,Integer>();
		java.io.BufferedReader stdIn = new java.io.BufferedReader(new java.io.InputStreamReader (System.in));
		String s = stdIn.readLine();
//		String str="";
//		java.util.HashMap hashmap = new java.util.HashMap();
		while ( s!= null) {
			String[] keys = s.split("[^a-zA-Z0-9]");
			//splits into keys
			for (String str:keys) {
				str = str.replaceAll("'","");
//				int value = 0;
				if (hashmap.containsKey(str)) {
//					hashmap.put(str, value++); 
				} 
				else {
					hashmap.put(str,0);
				}
			}
			s = stdIn.readLine(); //take next line
			ArrayList<String> arrayList = new ArrayList<String> (hashmap.keySet());
			Collections.sort(arrayList);
			for (String str:arrayList) {
//				Object obj = hashmap.get(s);
				System.out.println(str.toString());

			}
		}
// need to add exceptions
	}
		
}
