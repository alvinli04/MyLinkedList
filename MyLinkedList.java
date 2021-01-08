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
		end = n;
		++size;
		return true;
	}

	public void add(int index, String value){
		if(size == 0){
			add(value);
			return;
		}
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		Node n = new Node(value);
		if(index == size){
			end.setNext(n);
			n.setPrev(end);
			end = n;
			++size;
			return;
		}
		if(index == 0){
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
		n.setPrev(tmp.getPrev());
		n.setNext(tmp);
		tmp.getPrev().setNext(n);
		tmp.setPrev(n);
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
