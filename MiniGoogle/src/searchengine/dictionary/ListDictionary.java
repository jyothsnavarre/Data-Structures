package searchengine.dictionary;

import java.util.ArrayList;

class URLValue
{
	@Override
	public String toString() {
		return "value="+ url + " count=" + count ;
	}
	String url;
	int count=0;
	public URLValue(String value, int count) {
		super();
		this.url = value;
		this.count = count;
	}
	
}
class ListNode{
	String key;
	ArrayList<URLValue> val;
	ListNode next;
	ListNode()
	{
	
		val=new ArrayList<URLValue>();
	}
	ListNode(String k,Object value)
	{
	   key=k;
		val=new ArrayList<URLValue>();
		val.add(new URLValue((String)value,1));
	}
	
}
class link
{
	ListNode Head;
	int size=0;
	public void addLast(String key,Object val)
	{
		
		
		if(Head==null)
		{ ListNode n=new ListNode(key,val);
			Head=n;
			size++;
		}
	
		else
		{
			if(value(key)==null)
			{
				ListNode n=new ListNode(key,val);
			n.next=Head;
			Head=n;
			size++;
			}
			else
			{
				ListNode temp=Head;
				while(temp!=null)
				{int chk=0;
					if(temp.key.equals(key))
					{   
						for(int i=0;i<temp.val.size();i++)
							{if(temp.val.get(i).url.equals(val))
								{temp.val.get(i).count++;
							 chk=1;}
							}
						if(chk==0)
							temp.val.add(new URLValue((String)val,1));
					
					}
					temp=temp.next;
				}
			}
		}
	}
	public String[] keys()
	{
		ListNode temp=Head;
		String k[]=new String[size];
		int i=0;
		if(temp==null)
			return k;
		
		else
		{			
			while(temp!=null)
			{
				k[i]=(String) temp.key;
				//System.out.println(temp.key+"as");				
				temp=temp.next;
				i++;
			}
			return k;
		}
	}
	public Object value(String k)
	{
		ListNode temp=Head;
		if(Head==null)
		{
			System.out.println("No keys present");
			return null;
		}
	else
		{
			while(temp!=null)
			{
				if(temp.key.equals(k))
				{
					return temp.val;
				}
				temp=temp.next;
			}
			return null;
		}
	}
	@Override
	public String toString() {
		return "link [Head=" + Head + ", size=" + size + "]";
	}
	public ListNode remove(String key)
	{
		if(Head==null)
		{
			System.out.println("Nothing to remove");
			return  null;
		}
		else if(Head.key.equals(key))
		{
			Head=Head.next;
			size--;
			return null;
		}
		else
		{
			ListNode temp=Head;
			ListNode temp1=Head;
			while(temp!=null)
			{
				if(temp.key.equals(key))
				{
					ListNode a=temp;
					temp1.next=temp.next;
					size--;
					return a;
				}
				temp1=temp;
				temp=temp.next;
			}
			System.out.println("No such key");
			return null;
		}
	}
}
public class ListDictionary implements DictionaryInterface {

	link n=new link();
	@Override
	
	public String[] getKeys()
	{
		// TODO Auto-generated method stub
		return (String[]) n.keys();
	}

	@Override
	public Object getValue(String str) {
		// TODO Auto-generated method stub
		return n.value(str);
	}

	@Override
	public void insert(String key, Object value) {
		// TODO Auto-generated method stub
		n.addLast(key, value);
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		n.remove(key);
		
	}

}