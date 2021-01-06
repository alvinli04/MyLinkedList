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

	public boolean add(int index, String value){
		if(size == 0){
			add(value);
			return true;
		}
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		Node n = new Node(value);
		if(index == size){
			end.setNext(n);
			n.setPrev(end);
			end = n;
			++size;
			return true;
		}
		if(index == 0){
			n.setNext(start);
			start.setPrev(end);
			start = n;
			++size;
			return true;
		}
		Node tmp = start;
		for(int i=0; i<index; i++){
			tmp = tmp.getNext();
		}
		n.setPrev(tmp.getPrev());
		n.setNext(tmp);
		tmp.getPrev().setNext(n);
		tmp.setPrev(n);
		return true;
	}
}
