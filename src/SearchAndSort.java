import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SearchAndSort {
	
	/**
	 * Program execution starts here.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		SearchAndSort s = new SearchAndSort();
		Scanner in = new Scanner(System.in);
		
		//ALGORITHM
		String algorithm = "";
		do {
			System.out.println("Which algorithm would you like to execute? \nOptions: bubble, selection, insertion, merge, linear, binary, quit");
			algorithm = in.nextLine();
			algorithm = algorithm.toLowerCase();
		} while (!(algorithm.matches("bubble") || algorithm.matches("selection") || algorithm.matches("insertion") || algorithm.matches("merge") || algorithm.matches("linear") || algorithm.matches("binary") || algorithm.matches("quit")));
		
		if (!algorithm.matches("quit")) {
			//DATATYPE
			String datatype = "";
			do {
				System.out.println("Which type of data would you like to use? \nOptions: integers, strings");
				datatype = in.nextLine();
				datatype = datatype.toLowerCase();
			} while (!(datatype.matches("integers") || datatype.matches("strings")));
			
			//STORAGE
			String storage = "";
			do {
				System.out.println("How will it be stored? \nOptions: array, list");
				storage = in.nextLine();
				storage = storage.toLowerCase();
			} while (!(storage.matches("array") || storage.matches("list")));
			
			//DATA
			ArrayList<?> data;
			if (datatype.matches("strings")) {
				System.out.println("Enter your data (Ex. cat,dog,bear,mouse): ");
				String values = in.nextLine();
				ArrayList<String> stringData = new ArrayList<String>(Arrays.asList(values.split(",")));
				data = stringData;
			} else {
				ArrayList<Integer> intData;
				boolean valid = true;
				do {
					intData = new ArrayList<Integer>();
					System.out.println("Enter your data (Ex. 1,2,3,4,5) (Note: For binary, the list should be sorted): ");
					String values = in.nextLine();
					String[] temp = values.split(",");
					for (int i = 0; i < temp.length; i++) {
						try {intData.add(Integer.parseInt(temp[i]));} 
						catch(Exception e) {
							valid = false;
							System.out.println("Invalid Data");
							break;
						}
					}
				} while (!valid);
				data = intData;
			}
			
			//TARGET
			String target = "";
			if (algorithm.matches("linear") || algorithm.matches("binary")) {
				System.out.println("Enter your target: ");
				target = in.nextLine();
			} 
			
			s.Sort(data, algorithm, storage, datatype, target);
			
		} else {
			System.out.println("Thank you!");
		}
		in.close();
	}
	
	private void Sort(ArrayList<?> data, String algo, String sto, String type, String targ) {
		String[] sArray = null;
		Integer[] iArray = null;
		
		if (type.equals("integers")) {
			iArray = new Integer[data.size()];
			iArray = data.toArray(iArray);
		}
		if (type.equals("strings")) {
			sArray = new String[data.size()];
			sArray = (String[]) data.toArray(sArray);
		}
		
		switch(algo) {
		case "bubble":
			if(sto.equals("list")) {
				System.out.println("Bubble " + Arrays.toString(bubble(data).toArray()));
			} else if (type.equals("strings")) {
				System.out.println("Bubble: " + Arrays.toString(bubble(sArray)));
			} else {
				System.out.println("Bubble: " + Arrays.toString(bubble(iArray)));
			}
			break;
		case "selection":
			if(sto.equals("list")) {
				System.out.println("Selection: " + Arrays.toString(selection(data).toArray()));
			} else if (type.equals("strings")) {
				System.out.println("Selection: " + Arrays.toString(selection(sArray)));
			} else {
				System.out.println("Selection: " + Arrays.toString(selection(iArray)));
			}
			break;
		case "insertion":
			if(sto.equals("list")) {
				System.out.println("Insertion: " + Arrays.toString(insertion(data).toArray()));
			} else if (type.equals("strings")) {
				System.out.println("Insertion: " + Arrays.toString(insertion(sArray)));
			} else {
				System.out.println("Insertion: " + Arrays.toString(insertion(iArray)));
			}
			break;
		case "merge":
			if(sto.equals("list")) {
				System.out.println("Merge: " + Arrays.toString(merge(data).toArray()));
			} else if (type.equals("strings")) {
				System.out.println("Merge: " + Arrays.toString(merge(sArray)));
			} else {
				System.out.println("Merge: " + Arrays.toString(merge(iArray)));
			}
			break;
		case "linear":
			if(sto.equals("list")) {
				System.out.println("Linear: " + String.valueOf(linear(data,targ)));
			} else if (type.equals("strings")) {
				System.out.println("Linear: " + String.valueOf(linear(sArray,targ)));
			} else {
				System.out.println("Linear: " + String.valueOf(linear(iArray,targ)));
			}
			break;
		case "binary":
			if(sto.equals("list")) {
				System.out.println("Binary: " + String.valueOf(linear(data,targ)));
			} else if (type.equals("strings")) {
				System.out.println("Linear: " + String.valueOf(linear(sArray,targ)));
			} else {
				System.out.println("Linear: " + String.valueOf(linear(iArray,targ)));
			}
			break;
		}
	}
		
	//BUBBLE
	private String[] bubble(String[] data) {
		Collator c = Collator.getInstance();
		int l = data.length;
		for (int k = 0; k < l-1; k++) {
			for (int m = 0; m < l-k-1; m++) {
				if (c.compare(data[m], data[m+1]) > 0) {
					String temp = data[m];
					data[m] = data[m+1];
					data[m+1] = temp;
				}
			}
		}
		return data;
	}
	
	private Integer[] bubble(Integer[] data) {
		int l = data.length;
		for (int k = 0; k < l-1; k++) {
			for (int m = 0; m < l-k-1; m++) {
				if (data[m] > data[m+1]) {
					int temp = data[m];
					data[m] = data[m+1];
					data[m+1] = temp;
				}
			}
		}
		return data;
	}
	
	private ArrayList<?> bubble(ArrayList<?> data) {
		Collator c = Collator.getInstance();
		int l = data.size();
		if (data.get(0) instanceof Integer) {
			for (int k = 0; k < l-1; k++) {
				for (int m = 0; m < l-k-1; m++) {
					if ((int) data.get(m) > (int) data.get(m+1)) {
						Collections.swap(data,m,m+1);
					}
				}
			}
		} else {
			for (int k = 0; k < l-1; k++) {
				for (int m = 0; m < l-k-1; m++) {
					if (c.compare(data.get(m), data.get(m+1)) > 0) {
						Collections.swap(data,m,m+1);
					}
				}
			}
		}
		return data;
	}
	
	//SELECTION
	private String[] selection(String[] data) {
		Collator c = Collator.getInstance();
		for (int k = 0; k < data.length; k++) {
			int min = k;
			for (int m = k; m < data.length; m++) {
				if (c.compare(data[m], data[min]) < 0) {
					min = m;
				}
			}
			String temp = data[min];
			data[min] = data[k];
			data[k] = temp;
		}
		return data;
	}
	
	private Integer[] selection(Integer[] data) {
		for (int k = 0; k < data.length; k++) {
			int min = k;
			for (int m = k; m < data.length; m++) {
				if (data[m] < data[min]) {
					min = m;
				}
			}
			int temp = data[min];
			data[min] = data[k];
			data[k] = temp;
		}
		return data;
	}
	
	private ArrayList<?> selection(ArrayList<?> data) {
		Collator c = Collator.getInstance();
		for (int m = 0; m < data.size(); m++) {
			int min = m;
			for (int k = m; k < data.size(); k++) {
				if (data.get(0) instanceof Integer) {
					if ((int) data.get(k) < (int) data.get(min)) {
						min = k;
					}
				} else {
					if (c.compare(data.get(k), data.get(min)) < 0) {
						min = k;
					}
				}
			}
			Collections.swap(data, min, m);
		}
		return data;
	}
	
	//INSERTION
	private String[] insertion(String[] data) {
		Collator c = Collator.getInstance();
		int k, m;
		String key;
		for (k = 1; k < data.length; k++) {
			key = data[k];
			m = k - 1;
			while (m >= 0 && c.compare(data[m], key) > 0) {
				data[m+1] = data[m];
				m = m - 1;
			}
			data[m+1] = key;
		}
		return data;
	}
	
	private Integer[] insertion(Integer[] data) {
		int k, m, key;
		for (k = 1; k < data.length; k++) {
			key = data[k];
			m = k - 1;
			while (m >= 0 && data[m] > key) {
				data[m+1] = data[m];
				m = m - 1;
			}
			data[m+1] = key;
		}
		return data;
	}
	
	private ArrayList insertion(ArrayList data) {
		if (data.get(0) instanceof Integer) {
			int k, m, key;
			for (k = 1; k < data.size(); k++) {
				key = (int) data.get(k);
				m = k-1;
				while (m >= 0 && (int) data.get(m) > key) {
					data.set(m+1, data.get(m));
					m = m - 1;
				}
				data.set(m+1, key);
			}
		} else {
			Collator c = Collator.getInstance();
			int k, m;
			String key;
			for (k = 1; k < data.size(); k++) { 
				key = (String) data.get(k); 
				m = k-1; 
				while (m >= 0 && c.compare(data.get(m), key) > 0) { 
					data.set(m + 1, data.get(m)); 
					m = m-1; 
				} 
					data.set(m + 1, key); 
			}
		}
		return data;
	}
	
	//MERGE
	private String[] merge(String[] data) {
		Collator c = Collator.getInstance();
		if (data.length == 1) {
			return data;
		}
		//split in half
		String[] L = Arrays.copyOfRange(data, 0, data.length/2);
		String[] R = Arrays.copyOfRange(data, data.length/2, data.length);
		//sort left and right
		L = merge(L);
		R = merge(R);
		//merge the two
		int k = 0, m = 0, z = 0; 
        while (k < L.length && m < R.length) { 
            if (c.compare(L[k], R[m]) < 0) { 
                data[z] = L[k]; 
                k++; 
            } else { 
                data[z] = R[m]; 
                m++; 
            } 
            z++; 
        } 
        while (k < L.length) { 
            data[z] = L[k]; 
            k++; z++; 
        } 
        while (m < R.length) { 
            data[z] = R[m]; 
            m++; z++; 
        }
		return data;
	}
	
	
	private Integer[] merge(Integer[] data) {
		if (data.length == 1) {
			return data;
		}
		//split in half
		Integer[] L = Arrays.copyOfRange(data, 0, data.length/2);
		Integer[] R = Arrays.copyOfRange(data, data.length/2, data.length);
		//sort left and right
		L = merge(L);
		R = merge(R);
		//merge the two
		int k = 0, m = 0, z = 0; 
        while (k < L.length && m < R.length) { 
            if (L[k] <= R[m]) { 
                data[z] = L[k]; 
                k++; 
            } else { 
                data[z] = R[m]; 
                m++; 
            } 
            z++; 
        } 
        while (k < L.length) { 
            data[z] = L[k]; 
            k++; z++; 
        } 
        while (m < R.length) { 
            data[z] = R[m]; 
            m++; z++; 
        } 

		return data;
	}
	
	private ArrayList<?> merge(ArrayList data) {
		Collator c = Collator.getInstance();
		if (data.size() == 1) {
			return data;
		}
		//split in half
		ArrayList<?> L = new ArrayList(data.subList(0, data.size()/2));
		ArrayList<?> R = new ArrayList(data.subList(data.size()/2, data.size()));
		//sort left and right
		L = merge(L);
		R = merge(R);
		if(data.get(0) instanceof Integer) {
			int k = 0, m = 0, z = 0; 
	        while (k < L.size() && m < R.size()) { 
	            if ( (int) L.get(k) <= (int) R.get(m)) { 
	            	data.set(z, L.get(k)); 
	                k++; 
	            } else { 
	            	data.set(z, R.get(m)); 
	                m++; 
	            } 
	            z++; 
	        } 
	        while (k < L.size()) { 
	        	data.set(z, L.get(k)); 
	            k++; z++; 
	        } 
	        while (m < R.size()) { 
            	data.set(z, R.get(m)); 
	            m++; z++; 
	        } 
		} else {
			int k = 0, m = 0, z = 0; 
	        while (k < L.size() && m < R.size()) { 
	            if (c.compare(L.get(k), R.get(m)) < 0) { 
	            	data.set(z, L.get(k)); 
	                k++; 
	            } else { 
	            	data.set(z, R.get(m)); 
	                m++; 
	            } 
	            z++; 
	        } 
	        while (k < L.size()) { 
	        	data.set(z, L.get(k)); 
	            k++; z++; 
	        } 
	        while (m < R.size()) { 
            	data.set(z, R.get(m)); 
	            m++; z++; 
	        } 		}
		return data;
	}
	
	//LINEAR
	private int linear(String[] data, String target) {
		for (int k = 0; k < data.length; k++) {
			if ((data[k]).equals(target) ) {
				return k;
			}
		}
		return -1;
	}
	
	private int linear(Integer[] data, String target) {
		int targ = Integer.parseInt(target);
		for (int k = 0; k < data.length; k++) {
			if ((data[k]).equals(targ) ) {
				return k;
			}
		}
		return -1;
	}
	
	private int linear(ArrayList<?> data, String target) {
		for (int k = 0; k < data.size(); k++) {
			Object z = (Object)target;
			if (data.get(k) instanceof Integer) {
				z =  (Object)Integer.parseInt(z.toString());
			}
			if (((Object)data.get(k)).equals(z) ) {
				return k;
			}
		}
		return -1;
	}

	//BINARY
	private int binary(String[] data, String target) {
		Collator c = Collator.getInstance();
		String[] sorted = merge(data);
		int b = 0;
		int e = data.length - 1;
		while(b <= e) {
			int index = b + (e -  b) / 2;
			if (c.compare(sorted[index], target) == 0) {
				return index;
			} else if (c.compare(sorted[index], target) > 0) {
				e = index - 1;
			} else {
				b = index + 1;
			}
		}	
		return -1;
	}
	
	private int binary(Integer[] data, String target) {
		Integer[] sorted = merge(data);
		int targ = Integer.parseInt(target);
		int b = 0;
		int e = data.length - 1;
		while(b <= e) {
			int index = b + (e -  b) / 2;
			if (sorted[index] == targ) {
				return index;
			} else if (sorted[index] > targ) {
				e = index - 1;
			} else {
				b = index + 1;
			}
		}	
		return -1;
	}
	
	private int binary(ArrayList<?> data, String target) {
		Collator c = Collator.getInstance();
		ArrayList<?> sorted = merge(data);
		Object targ = (Object)target;
		if (data.get(0) instanceof Integer) {
			targ =  (Object)Integer.parseInt(targ.toString());
		}
		int b = 0;
		int e = data.size() - 1;
		while (b <= e) {
			int index = b + (e -  b) / 2;
			if (data.get(0) instanceof Integer) {
				if ( (Integer) sorted.get(index) == (Integer) targ) {
					return index;
				} else if ((Integer) sorted.get(index) > (Integer) targ) {
					e = index - 1;
				} else {
					b = index + 1;
				}
			} else {
				if (c.compare(sorted.get(index).toString(),(String) targ) == 0) {
					return index;
				} else if (c.compare(sorted.get(index).toString(),(String) targ) > 0) {
					e = index - 1;
				} else {
					b = index + 1;
				}
			}
		}	
		return -1;
	}
}