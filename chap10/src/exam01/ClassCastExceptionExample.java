package exam01;

public class ClassCastExceptionExample {
	public static void main(String[] args) {
		
		try {
			int i = 39/1;
			Dog dog = new Dog();
			changeDog(dog);
			
			Cat cat = new Cat();
			changeDog(cat);
		} catch(ClassCastException e) {
			System.out.println("Class Cast exception 발생");
		} catch(Exception e) {
			System.out.println("오류발생");
			e.getStackTrace();
		} finally {
			System.out.println("finally");
		}
	}
	
	public static void changeDog(Animal animal) {
//		if(animal instanceof Dog) {
			Dog dog = (Dog)animal;
//		}
//		else if (animal instanceof Cat) {
//			Cat cat = (Cat)animal;
//		}
		
	}
}
