package exam14;

class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
public class PersonTest01 {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println("기본 생성자로 객체를 생성할 수 있다.");
		System.out.println("이름: "+p.getName());
		System.out.println("나이: "+p.getAge());
	}
}
