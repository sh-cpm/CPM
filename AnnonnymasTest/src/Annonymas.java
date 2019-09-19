/*class A{
	public void show(){
		System.out.println("A class");
	}
}*/

interface A{
	void show();
}
public class Annonymas {
	public static void main(String args[]){
		A obj = new A()
				{
					public void show(){
						System.out.println("Bc class");
					}
			
				};
		obj.show();
	}

}
