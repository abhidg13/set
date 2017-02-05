package com.kpn.set;

import org.junit.Assert;
import org.junit.Test;


public class ArraySetTest {
	
    @Test
    public void testGenerics() {
    	Set<String> testSet = new MySet<String>();
    	testSet.add("Element_1"); testSet.add("Element_2"); testSet.add("Element_3"); testSet.add("Element_X");
    	
    	Assert.assertNotNull(testSet);
    	//Check the counts.
    	Assert.assertTrue(testSet.size()==4);
    	
    	//Iterate the set and check if each elements actually exists.
    	SetIterator<String> setIterator = testSet.iterator();
		while (setIterator.hasNext()) {
			String element = setIterator.next();
			Assert.assertTrue(testSet.toString().contains(element));
		}
    }

    @Test
    public void testAdd() {
    	Set<String> testSet = new MySet<String>();
    	testSet.add("Element_1");
    	testSet.add("Element_2");
    	testSet.add("Element_3");
    	testSet.add("Element_2"); //A duplicate
    	testSet.add("Element_4");
    	testSet.add("Element_3"); //Another duplicate
    	testSet.add("Element_5");
    	testSet.add("Element_X");
    	
    	Assert.assertNotNull(testSet);
    	//Check the counts.
    	Assert.assertTrue(testSet.size()==6);
    	//Check content.
    	Assert.assertEquals("Element_1, Element_2, Element_3, Element_4, Element_5, Element_X", testSet.toString());
    }

    @Test
    public void testEquals() {
    	Set<String> testSet123 = new MySet<String>();
    	testSet123.add("Element_1"); testSet123.add("Element_2"); testSet123.add("Element_3");
    	
    	Set<String> testSet213 = new MySet<String>();
    	testSet213.add("Element_2"); testSet213.add("Element_1"); testSet213.add("Element_3");
    	
    	Set<String> testSet321 = new MySet<String>();
    	testSet321.add("Element_3"); testSet321.add("Element_2"); testSet321.add("Element_1");
    	
    	Set<String> testSet123X = new MySet<String>();
    	testSet123X.add("Element_1"); testSet123X.add("Element_2"); testSet123X.add("Element_3"); testSet123X.add("Element_X");
    	
    	Assert.assertTrue(testSet123.equals(testSet213)); 	//Same elements, same sequence.
    	Assert.assertTrue(testSet123.equals(testSet213)); 	//Same elements, different sequence.
    	Assert.assertTrue(testSet123.equals(testSet321)); 	//Same elements, different sequence.
    	Assert.assertFalse(testSet123.equals(testSet123X)); //Different elements.
    	Assert.assertFalse(testSet123.equals(null)); 		//Null compatibility.
    }

    @Test
    public void testRemove() {
    	Set<String> testSet = new MySet<String>();
    	testSet.add("Element_1");
    	testSet.add("Element_2");
    	testSet.add("Element_X");
    	testSet.add("Element_3");
    	
    	testSet.remove("Element_X");
    	
    	//Check the counts.
    	Assert.assertTrue(testSet.size()==3);
    	//Check content.
    	Assert.assertEquals("Element_1, Element_2, Element_3", testSet.toString());
    }

    @Test
    public void testUnion() {
    	Set<String> testSet123 = new MySet<String>();
    	testSet123.add("Element_1"); testSet123.add("Element_2"); testSet123.add("Element_3");
    	
    	Set<String> testSet2345 = new MySet<String>();
    	testSet2345.add("Element_2"); testSet2345.add("Element_3"); testSet2345.add("Element_4"); testSet2345.add("Element_5");
    	
    	Set<String> testSet678 = new MySet<String>();
    	testSet678.add("Element_6"); testSet678.add("Element_7"); testSet678.add("Element_8");
    	
    	Set<String> testSet12345 = testSet123.union(testSet2345); //2 common elements
    	//Check the counts.
    	Assert.assertTrue(testSet12345.size()==5);
    	//Check content.
    	Assert.assertEquals("Element_1, Element_2, Element_3, Element_4, Element_5", testSet12345.toString());
    	
    	Set<String> testSet12345678 = testSet12345.union(testSet678); //No common elements
    	//Check the counts.
    	Assert.assertTrue(testSet12345678.size()==8);
    	//Check content.
    	Assert.assertEquals("Element_1, Element_2, Element_3, Element_4, Element_5, Element_6, Element_7, Element_8", testSet12345678.toString());
    }

    @Test
    public void testIntersection() {
    	Set<String> testSet123 = new MySet<String>();
    	testSet123.add("Element_1"); testSet123.add("Element_2"); testSet123.add("Element_3");
    	
    	Set<String> testSet2345 = new MySet<String>();
    	testSet2345.add("Element_2"); testSet2345.add("Element_3"); testSet2345.add("Element_4"); testSet2345.add("Element_5");
    	
    	Set<String> testSet678 = new MySet<String>();
    	testSet678.add("Element_6"); testSet678.add("Element_7"); testSet678.add("Element_8");
    	
    	Set<String> testSet23 = testSet123.intersection(testSet2345); //2 common elements
    	//Check the counts.
    	Assert.assertTrue(testSet23.size()==2);
    	//Check content.
    	Assert.assertEquals("Element_2, Element_3", testSet23.toString());
    	
    	Set<String> testSet = testSet23.intersection(testSet678); //No common elements
    	//Check the counts.
    	Assert.assertTrue(testSet.size()==0);
    }
}
