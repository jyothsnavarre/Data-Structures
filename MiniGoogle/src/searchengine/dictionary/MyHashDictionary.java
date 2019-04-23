package searchengine.dictionary;

import java.util.ArrayList;

class Value
{
	String value;
	int Count;
	Value(String value)
	{
		this.value=value;
		Count=1;
	}
	public String toString()
	{
		return value+"-->"+Count;
	}
}
class Hashcode
{
	String key;
	ArrayList<Value> al;
	Hashcode(String key,String value)
	{
		this.key=key;
		al=new ArrayList<Value>();
		Value value1=new Value(value);
		al.add(value1);
	}
}
public class MyHashDictionary implements DictionaryInterface {
	Hashcode[] map=new Hashcode[200];
	int Count=0;
	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		String [] s=new String[Count];
		
		int j=0;
		for(int i=0;i<200;i++)
		{
			if(map[i]!=null) {
				System.out.println(map[i].key);
				s[j]=(String)map[i].key;
				
				j++;
			}
			
		}
		return s;
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		int hashindex=hashcode(key);
		return map[hashindex].al;
	}

	@Override
	public void insert(String key, Object value)
	{
		// TODO Auto-generated method stub
		  
		Hashcode hash=new Hashcode(key,(String)value);
		int hashindex=hashcode(key);
		if(map[hashindex]==null)
		{
			map[hashindex]=hash;
			Count++;
		}
		else
		
 		{
			int f=0;
			for(int i=0;i<map[hashindex].al.size();i++)
			{
			if(map[hashindex].al.get(i).value.equals((String)value))
			{
				map[hashindex].al.get(i).Count++;
				f=1;
                break;
			}
			}
			if(f==0)
				map[hashindex].al.add(new Value((String)value))	;			
			}
 				
	   

	
	
}	
 		
            			
 		
	

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		int hashindex=hashcode(key);
		for(int i=0;i<map.length;i++)
		{
			if(i==hashindex)
			{
				map[i]=null;
				Count--;
			}
		}
	}
	public int  hashcode(String key)
	{
		int sum=0;
		String s=(String)key;
		
		for(int i=0;i<s.length();i++)
		{
			sum=sum+s.charAt(i)*(i+1);
		}
		return sum%200;
	}

}
