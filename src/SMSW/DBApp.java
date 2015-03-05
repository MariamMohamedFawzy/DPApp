package SMSW;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

public class DBApp {

	public void init() {

	}

	public Iterator selectFromTable(String strTable,
			Hashtable<String, String> htblColNameValue, String strOperator)
			throws DBEngineException {
		if (strTable != null && !(strTable.equals(""))) {
			if (htblColNameValue.size() > 0) {
				if (strOperator.equals("AND")) {
					
				}
				else if (strOperator.equals("OR")) {
					
				}
				else {
					
				}
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
		Enumeration<String> enumKey = htblColNameValue.keys();
		while(enumKey.hasMoreElements()) {
		    String key = enumKey.nextElement();
		    String val = htblColNameValue.get(key);
//		    if(key==0 && val.equals("0"))
//		        table.remove(key);
		}
		return null;

	}

	public Iterator selectFromOneTable(String strTable, String key, String value) {
		return null;
	}

}
