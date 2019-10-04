package com.module;


import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FileRead {

		public List<List<String>> readFunction(){
			
			List<String> list = new ArrayList<String>();
			List<List<String>> PrimeList = new ArrayList<List<String>>();
			try (BufferedReader br = new BufferedReader(new FileReader("sampleinput.txt"))) {
			    String line;
				while ((line = br.readLine()) != null) {
				    	list.add(line);
				}
			} catch (FileNotFoundException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			int from = 1;
			int to = 4;
			for(int i=0;i<(list.size()-1)/3;i++) {
				List<String> temp = list.subList(from, to);
				from = to;
				to = to + 3;
				PrimeList.add(temp);
			}	
			return  PrimeList;
		}		
}