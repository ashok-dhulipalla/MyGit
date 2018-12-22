package com.ashok.BirtPojo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class PojoDataSet {

	private Iterator<PojoDataSource> itr;
	private List<PojoDataSource> getNames()
	{
		List<PojoDataSource> names= new ArrayList<PojoDataSource>();
		PojoDataSource src= new PojoDataSource();
		src.setFirstName("Ashok12");
		src.setMiddleName("Kumar12");
		src.setLastName("Dhulipalla12");
		names.add(src);

		PojoDataSource src1= new PojoDataSource();
		src1.setFirstName("Ashok1");
		src1.setMiddleName("Kumar1");
		src1.setLastName("Dhulipalla1");
		names.add(src1);

		PojoDataSource src2= new PojoDataSource();
		src2.setFirstName("Ashok2");
		src2.setMiddleName("Kumar2");
		src2.setLastName("Dhulipalla2");
		names.add(src2);
		return names;
	}
	public void open(Object appContext, Map<String,Object> map) {   

	}
	public void close() { }
	public Object next()
	{
		if (itr == null)
		{
			itr= getNames().iterator();
		}
		if(itr.hasNext())
			return itr.next();
		return null;
	}
}
