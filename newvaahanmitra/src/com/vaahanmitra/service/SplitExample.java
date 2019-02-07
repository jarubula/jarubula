package com.vaahanmitra.service;

public class SplitExample {
	/*public static void main(String args[]) {
		StringBuffer sb = new StringBuffer();
		String s1 = "415252 MINS string split method by javatpoint";
		String mainStr = "";
		String[] words = s1.split("\\s");// splits the string based on string
		// using java foreach loop to print elements of string array
		for (String w : words) {
			if (w.startsWith("M")){
				sb.r
				mainStr = mainStr + s1;
			}
				
		}
		System.out.println(mainStr);
	}*/
	


	/*
	 * This basic java example source code
	 * shows how to delete all occurrences of a character on a String
	 */


		public static void main(String[] args) {
			// Declare a string object
			String strValue = "451278MINS";
			// call a method to delete all occurrences
			String newString = deleteAll(strValue, "MINS");
			// print the new string value
			System.out.println("New String:" + newString);

		}

		private static String deleteAll(String strValue, String charToRemove) {
			return strValue.replaceAll(charToRemove, "");

		}

}