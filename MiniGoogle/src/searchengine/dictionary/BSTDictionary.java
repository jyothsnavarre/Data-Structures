package searchengine.dictionary;

import java.util.ArrayList;

class Node1
{
	String key;
	String value;
	Node1 left,right;

	Node1(String key,Object value2)
	{
		this.key=key;
		this.value=(String) value2;
		left=right=null;	}
	
}
 class BST
{
	 int count;
	 String st[]=new String[count];
	Node1 root;
	BST()
	{
		root=null;
		count=0;
	}
	
	int n=0;
	public void put(String Key,Object value)
	{
		count++;
		root=put(root,Key,value);
	}
	private Node1 put (Node1 x, String key, Object value)
	{
		
		if(x==null)
		{
			
			return new Node1(key,value);
		}
		if(key.compareTo(x.key)<0)
		{
			//count++;
			x.left=put(x.left,key,value);
		}
		else if(key.compareTo(x.key)>0)
		{
			//count++;
			x.right=put(x.right,key,value);
		}
		else
		
			x.value=(String) value;
		
		return x;
	}
	
	public String get( String key) {
		return get(root,key);
	}
	
	public String get(Node1 x, String key) { 
	if (x == null) {
		
		return null;}
	else
	{
	int cmp =key.compareTo(x.key) ;  
	if (cmp < 0) 
	return get(x.left, key);     
	else if (cmp > 0) 
	return get(x.right, key);   
	else return x.value; 
	}
	}

	void deleteKey(String key) 
    { 
        root = deleteRec(root, key); 
    } 
  
 
    Node1 deleteRec(Node1 root, String key) 
    { 
      // if(key.compareTo(root.key))
        if (root == null)  return root; 
  
        
        if (key.compareTo( root.key)<0) 
            root.left = deleteRec(root.left, key); 
        else if (key.compareTo( root.key) >0) 
            root.right = deleteRec(root.right, key); 
  
        else
        { 
           
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
            Node1 temp=minValue(root.right);
            root.key = temp.key; 
  
            root.right = deleteRec(temp,root.key); 
        } 
  
        return root; 
    } 
  
    Node1 minValue(Node1 root) 
    { 
        Node1 minv=root;
        while (root.left != null) 
        { 
            minv = root.left; 
            root = root.left; 
        } 
        return minv; 
    } 
    public String[] inorder()
	{
	ArrayList<String> al=new ArrayList<String>();
	inorder(root,al);
	int size=al.size();
	String [] s=new String[size];
	for(int i=0;i<size;i++)
	{
		s[i]=(String)al.get(i);
	}
	
	return s;
		
	}
	public void inorder(Node1 n,ArrayList al)
	{
		
		if(n!=null) {
		inorder(n.left,al);
		
		
		al.add(n.key);
			
		
		inorder(n.right,al);
	
		}
	
	
}
}
public class BSTDictionary implements DictionaryInterface {
	BST b=new BST();
	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		return b.inorder();
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return b.get(key);
	}

	@Override
	public void insert(String key, Object value) {
		// TODO Auto-generated method stub
		b.put(key, value);
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		b.deleteKey(key) ;
	}

}
