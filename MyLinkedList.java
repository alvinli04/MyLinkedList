public class MyLinkedList{

	private int size;
	private Node start, end;
	
	public MyLinkedList(){
		size = 0;
		start = null;
		end = null;
	}
	
	public int size(){
		return size;
	}

	public boolean add(String value){
		Node n = new Node(value);
		if(size == 0){
			start = n;
			end = n;
			++size;
			return true;
		}
		end.setNext(n);
		n.setPrev(end);
		end = n;
		++size;
		return true;
	}

	public void add(int index, String value){
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		
		Node n = new Node(value);
		
		if(index == size){
			add(value);
			return;
		}
		else if(index == 0){
			n.setNext(start);
			start.setPrev(end);
			start = n;
			++size;
			return;
		}
		Node tmp = start;
		for(int i=0; i<index; i++){
			tmp = tmp.getNext();
		}
		Node f = tmp.getPrev();
		f.setNext(n);
		n.setPrev(f);
		tmp.setPrev(n);
		n.setNext(tmp);
		++size;
	}

	public String get(int index){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node tmp = start;
		for(int i=0; i<index; i++)
			tmp = tmp.getNext();
		return tmp.getData();
	}

	public String set(int index, String element){
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node tmp = start;
		for(int i=0; i<index; i++){
			tmp = tmp.getNext();
		}
		String tmpDat = tmp.getData();
		tmp.setData(element);
		return tmpDat;
	}

	public String toString(){
		if(size == 0){
			return "[]";
		}
		String ret = "[" + start.getData();
		Node tmp = start;
		while(tmp != end){
			tmp = tmp.getNext();
			ret += ", " + tmp.getData();
		}
		return ret + "]";
	}
}
