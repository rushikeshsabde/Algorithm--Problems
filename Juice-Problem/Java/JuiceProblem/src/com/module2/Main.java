package com.module2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.module.FileRead;

public class Main {

	public static void main(String[] args) {
		Main mainApp = new Main();
		FileRead file = new FileRead();

		List<List<String>> lists = file.readFunction();
		for (List<String> list : lists) {
			int caloriIntake = Integer.parseInt(list.get(2));
			String actualFruits = list.get(1);
			Map<String, String> outputMap =  mainApp.uniqueList(list.get(0), list.get(1));
			List<Integer> sortedList = mainApp.returnSoredIntegerList(actualFruits,outputMap);
			List<List<Integer>> combinationList = mainApp.combinationSum2(sortedList,caloriIntake);
//			System.out.println(combinationList);
			if(combinationList.isEmpty()) {
				System.out.println("SORRY, YOU JUST HAVE WATER");
			}
			else {
				List<List<String>> sortedStringList = mainApp.parseBackToString(combinationList,outputMap);
				List<String> sortParsedStringList = mainApp.stringBuilderFromCharList(sortedStringList);
				System.out.println(sortParsedStringList.get(0));
			}
		}
	}

	private List<List<String>> parseBackToString(List<List<Integer>> combinationList, Map<String, String> outputMap){
		List<List<String>> StringList = new ArrayList<>();
		for(List<Integer> list : combinationList) {
			List<String> letterList = new ArrayList<>();
			for(Integer item : list) {
				for(Map.Entry entry : outputMap.entrySet()) {
					if(item.equals(Integer.parseInt((String) entry.getValue()))) {
						letterList.add((String) entry.getKey());
					}
				}
			}
			StringList.add(letterList);
		}
		return StringList;	
	}
	
	private List<String> stringBuilderFromCharList(List<List<String>> StringList) {
		List<String> sortParsedStringList = new ArrayList<>();
		for(List<String> str : StringList) {
			Collections.sort(str);
			StringBuilder sb = new StringBuilder();
			for(String ch : str) {
				sb.append(ch);
			}
			String string = sb.toString(); 
			sortParsedStringList.add(string);
		}
		sortParsedStringList.sort( Comparator.comparing( String::toString ) );
		return sortParsedStringList;
	}
	
	private List<Integer> returnSoredIntegerList(String actualFruits, Map<String, String> outputMap) {
		String[] strArr = actualFruits.split("");
		List<Integer> intList = new ArrayList<>();
		for (String str : strArr) {
			str = str.replace(str, outputMap.get(str));
			int item = Integer.parseInt(str);
			intList.add(item);
		}
		return intList;
	}

	public List<List<Integer>> combinationSum2(List<Integer> sortedList, int target) {
//        Collections.sort(sortedList);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backTrack(result, list, sortedList, target, 0); 
        return result;
    }

	 private void backTrack(List<List<Integer>> result,List<Integer> list, List<Integer> sortedList, int target,
		        int position) {
		            int sum = 0;
		            for (int x: list) {
		                    sum += x;
		            }
		            if (sum == target) {
		                    result.add(new ArrayList<Integer>(list));
		                    return;
		            }
		            if (sum < target)
		            {
		                for (int i = position; i < sortedList.size(); i++)
		                {
		                    if(position != i&& sortedList.get(i) == sortedList.get(i-1)){
		                        continue;
		                    }
		                    list.add(sortedList.get(i));
		                    backTrack(result, list, sortedList, target, i+1);
		                    list.remove(list.size() - 1);
		                }
		            }
		        }
	
	private Map<String, String> uniqueList(String uniqueCaories, String actualFruit) {

		Map<String, String> map = new HashMap<String, String>();
		List<String> uniqueFruitList = new ArrayList<String>();

		String[] delimatedString = uniqueCaories.split(" ");

		String[] chars = actualFruit.split("");
		Arrays.sort(chars);
		Set<String> uniqKeys = new TreeSet<String>();
		for (String eachChar : chars) {
			uniqKeys.add(eachChar);
		}
		for (String character : uniqKeys) {
			uniqueFruitList.add(character);
		}
		for (int i = 0; i < uniqueFruitList.size(); i++) {

			map.put(uniqueFruitList.get(i), delimatedString[i + 1]);
		}
		return map;
	}

}
