package com.kpn.set;

import java.util.Arrays;

public class MySet<D> implements Set<D> {
	
	private D[] storageArray;
	private int elementsCount;

	/**
	 * Constructor for objects of class MySet
	 */
	public MySet() {
		storageArray=(D[]) new Object[5];
		elementsCount=0;
	}

	public Set<D> add(D object) {
		for (D element:storageArray){
			if (element==null ? object==null : element.equals(object)){
				return this;
			}
		}
		if (elementsCount==storageArray.length) {
			D[] newArray=Arrays.copyOf(storageArray,storageArray.length*2);
			newArray[elementsCount]=object;
			elementsCount=elementsCount+1;
			storageArray=newArray;
		}
		else {
			storageArray[elementsCount]=object;
			elementsCount=elementsCount+1;
		}
		return this;
	}

	public Set<D> remove(D object) {
		int i = 0;
		for (D element : storageArray) {
			if (object != null && object.equals(element)) {
				System.arraycopy(storageArray, i+1, storageArray, i, elementsCount-i-1);
				storageArray[elementsCount-1] = null;
				elementsCount = elementsCount - 1;
				return this;
			}
			i++;
		}
		return this;
	}

	public int size(){
		return elementsCount;
	}

	public boolean equals(Set<D> otherSet) {
		if(otherSet!=null && otherSet.size()==elementsCount) {
			SetIterator<D> setIterator = otherSet.iterator();
			while (setIterator.hasNext()) {
				D otherSetElement = setIterator.next();
				if (!this.contains(otherSetElement)) {
					return false; 
				}
			}
			return true;
		}
		return false;
	}

	public boolean contains(D object) {
		for(D element:storageArray) {
			if (object!=null && object.equals(element)) {
				return true;
			}
		}
		return false;
	}

	public Set<D> union(Set<D> otherSet) {
		SetIterator<D> setIterator = otherSet.iterator();
		while (setIterator.hasNext()) {
			this.add(setIterator.next());
		}
		return this;
	}

	public Set<D> intersection(Set<D> otherSet) {
		int index = 0;
		while(index < elementsCount) {
			D d = storageArray[index];
			if (d != null && !(otherSet.contains(d))) {
				this.remove(d);
			} else {
				index++;
			}
		}
		return this;
	}

	@Override
	public String toString() {
		String setAsString = "";
		for(D element:storageArray) {
			if (element != null) {
				setAsString = setAsString + ", " + element;
			}
		}
		return setAsString.replaceFirst(", ", "");
	}

	public SetIterator<D> iterator() {
		MySetIterator iterator=new MySetIterator();
		return iterator;
	}

	private class MySetIterator implements SetIterator<D> {
		private int currIndex;
		private D lastElement;
		
		public MySetIterator() {
			currIndex=0;
			lastElement=null;
		}
		
		public boolean hasNext() {
			while(currIndex<=elementsCount && storageArray[currIndex]==null) {
				currIndex=currIndex+1;
			}
			if (currIndex<=elementsCount) {
				return true;
			}
			return false;
		}
		
		public D next() {
			D element=storageArray[currIndex];
			currIndex=currIndex+1;
			lastElement=element;
			return element;
		}
	}
}