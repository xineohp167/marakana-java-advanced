package list;

public final class ImmutableList<E> {

	public final E head;
	public final ImmutableList<E> tail;

	public ImmutableList() {
		this.head = null;
		this.tail = null;
	}

	private ImmutableList(E head, ImmutableList<E> tail) {
		this.head = head;
		this.tail = tail;
	}

	public ImmutableList<E> prepend(E element) {
		return new ImmutableList<E>(element, this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result + ((tail == null) ? 0 : tail.hashCode());
		return result;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ImmutableList))
			return false;
		ImmutableList other = (ImmutableList) obj;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (tail == null) {
			if (other.tail != null)
				return false;
		} else if (!tail.equals(other.tail))
			return false;
		return true;
	}
	
	public static void main(String args[]){
		ImmutableList<Integer> list = new ImmutableList<Integer>();
		ImmutableList<Integer> listPrepend = new ImmutableList<Integer>();
		System.out.println(list.head);
		System.out.println(list.tail);
		System.out.println(listPrepend.head);
		System.out.println(listPrepend.tail);
		listPrepend = list.prepend(1);
		System.out.println(list.head);
		System.out.println(list.tail);
		System.out.println(listPrepend.head);
		System.out.println(listPrepend.tail);
		listPrepend = list.prepend(2);
		System.out.println(list.head);
		System.out.println(list.tail);
		System.out.println(listPrepend.head);
		System.out.println(listPrepend.tail);
		listPrepend = list.prepend(3);
		System.out.println(list.head);
		System.out.println(list.tail);
		System.out.println(listPrepend.head);
		System.out.println(listPrepend.tail);
	}
}