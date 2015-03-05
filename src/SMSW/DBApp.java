package SMSW;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;

public class DBApp {

	public void init() {

	}

	public Iterator selectFromTable(String strTable,
			Hashtable<String, String> htblColNameValue, String strOperator)
			 {
		ListIterator it = null;
		if (strTable != null && !(strTable.equals(""))) {
			if (htblColNameValue.size() > 0) {
				ListIterator tempIterator;
				if (strOperator.equals("AND")) {
					Enumeration<String> enumKey = htblColNameValue.keys();
					while (enumKey.hasMoreElements()) {	
						String key = enumKey.nextElement();
						String val = htblColNameValue.get(key);
						tempIterator = selectFromOneTable(strTable, key, val);
						if (it == null) {
							it = tempIterator;
						}
						else {
							it = compareIteratorsForAnd(it, tempIterator);
						}
					}
				} else if (strOperator.equals("OR")) {
					Enumeration<String> enumKey = htblColNameValue.keys();
					while (enumKey.hasMoreElements()) {
						String key = enumKey.nextElement();
						String val = htblColNameValue.get(key);
						tempIterator = selectFromOneTable(strTable, key, val);
						it = compareIteratorsForOr(it, tempIterator);
						
					}
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
		if (it == null) {
			return null;
		}
		else {
			ArrayList ar = new ArrayList();
			while (it.hasNext()) {
				ar.add(it.next());
			}
			Iterator tempIt = ar.iterator();
			return tempIt;
		}

	}

	// not yet
	public ListIterator compareIteratorsForAnd(ListIterator it1, ListIterator it2) {
		if (it1 == null || it2 == null) {
			return null;
		} else {
			ArrayList copy_of_it1 = new ArrayList();
			ArrayList copy_of_it2 = new ArrayList();
			while (it1.hasNext()) {
				copy_of_it1.add(it1.next());
			}
			while (it2.hasNext()) {
				copy_of_it2.add(it2.next());
			}
			int n = copy_of_it1.size();
			ArrayList toRemove = new ArrayList();
			for (int i = 0; i < n; i++) {
				Object object = copy_of_it1.get(i);
				if (!copy_of_it2.contains(object)) {
					toRemove.add(object);
				}
			}
			for (int i = 0; i < toRemove.size(); i++) {
				copy_of_it1.remove(toRemove.get(i));
			}
			ListIterator itTotal = copy_of_it1.listIterator();
			return itTotal;
					}
	}

	// not yet
	public ListIterator compareIteratorsForOr(ListIterator it1, ListIterator it2) {
		if (it1 == null) {
			if (it2 == null) {
				return null;
			} else {
				return it2;
			}
		} else {
			if (it2 == null) {
				return it1;
			} else {
				ArrayList copy_of_it1 = new ArrayList();
				ArrayList copy_of_it2 = new ArrayList();
				while (it1.hasNext()) {
					copy_of_it1.add(it1.next());
				}
				while (it2.hasNext()) {
					copy_of_it2.add(it2.next());
				}
				int n = copy_of_it1.size();
				for (int i = 0; i < n; i++) {
					Object object = copy_of_it1.get(i);
					if (!copy_of_it2.contains(object)) {
						copy_of_it2.add(object);
					}
				}
				ListIterator itTotal = copy_of_it2.listIterator();
				return itTotal;
			}
		}

	}

	// not yet
	public ListIterator selectFromOneTable(String strTable, String key,
			String value) {
		return null;
	}

}
