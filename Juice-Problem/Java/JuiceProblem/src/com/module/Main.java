package com.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Main {

	public static void main(String[] args)
    {
		Main mainApp = new Main();
		FileRead file = new FileRead();
		
		List<List<String>> lists = file.readFunction();
		for(List<String> list : lists) {
			int caloriIntake = Integer.parseInt(list.get(2));
			
			Map<Character, List<Integer>> outputMap =  mainApp.uniqueList(list.get(0), list.get(1));
			mainApp.finalCalculation(outputMap, caloriIntake);
		}
    }
	

	
	private void finalCalculation(Map<Character, List<Integer>> outputMap, int caloriIntake){
		int sum =0;
		String finalOutPut = "";
		for (Map.Entry<Character, List<Integer>> entry : outputMap.entrySet())
		{
			int val = entry.getValue().get(0);
			int count = entry.getValue().get(1);
			while(count>0) {
				sum = sum + val;
				finalOutPut += entry.getKey();
				count--;
			}
			if(sum == caloriIntake) {
				break;
			}
			else if (entry.getValue().get(0) < caloriIntake){
				sum = 0;
				sum += entry.getValue().get(0);
				finalOutPut += entry.getKey();
			}
		}
		if (sum == caloriIntake){
			System.out.println("Fruit Combination : " + finalOutPut);
			
		}else{
			System.out.println("SORRY, YOU JUST HAVE WATER");
		}
	}
	
	
	private Map<Character, List<Integer>> uniqueList(String uniqueCaories, String actualFruit){
		
		Map<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
		List<Character> uniqueFruitList = new ArrayList<Character>();
		
		String [] delimatedString = uniqueCaories.split(" ");

        char[] chars = actualFruit.toCharArray();
        Arrays.sort(chars);
        Set<Character> uniqKeys = new TreeSet<Character>();
        for(char eachChar : chars) {
        	uniqKeys.add(eachChar);
        }
        
        for (Character character : uniqKeys) {
			uniqueFruitList.add(character);
		}
        
        for (int i=0 ; i < uniqueFruitList.size();i++){
        	List<Integer> temp = new ArrayList<Integer>();
        	temp.add(Integer.parseInt(delimatedString[i+1]));
        	temp.add(countChar(actualFruit,uniqueFruitList.get(i)));
        	map.put(uniqueFruitList.get(i), temp);
        }
		return map;
	}
	
	private int countChar(String str, char c) {
		 int count = 0;

		    for(int i=0; i < str.length(); i++)
		    {    if(str.charAt(i) == c)
		            count++;
		    }

		    return count;
	}
	
	
}
