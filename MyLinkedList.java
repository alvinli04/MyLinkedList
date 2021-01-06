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
		if(size == 0){
			Node n = new Node(value);
			start = n;
			end = n;
			++size;
			return true;
		}
		return true;
	}
}
