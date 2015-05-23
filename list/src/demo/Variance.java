package demo;

public class Variance {

	public static class Box<E> {
		private E element;

		public Box(E element) {
			this.element = element;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}
	}

	public static class A {

		@Override
		public String toString() {
			return "This is A";
		}
		
	};

	public static class B extends A {
		
		@Override
		public String toString() {
			return "This is B";
		}
	};

	public static class C extends B {
		
		@Override
		public String toString() {
			return "This is C";
		}
	};
	
public static class D extends C {
		
		@Override
		public String toString() {
			return "This is D";
		}
	};

	public static B getBFromABox(Box<? extends B> box) {
		return box.getElement();
	}

	public static void putBInABox(Box<? super B> box) {
		box.setElement(new B());
	}

	public static void covarianceDemo() {
		Box<C> cbox = new Box<C>(new C());
		if(getBFromABox(cbox) instanceof C){
			C c = (C) getBFromABox(cbox);
		};
	}

	public static void contravarianceDemo() {
		Box<A> abox = new Box<A>(new A());
		putBInABox(abox);
	}

	public static void invarianceDemo() {
		Box<B> box = new Box<B>(new B());
		putBInABox(box);
		B b = getBFromABox(box);
	}
	
	public static void main(String[] args) {
		
		Box<D> cbox = new Box<D>(new D());
		if(getBFromABox(cbox) instanceof C){
			C c2 =  (C) getBFromABox(cbox);
			System.out.println(c2.getClass());
		};
		
	}

}
