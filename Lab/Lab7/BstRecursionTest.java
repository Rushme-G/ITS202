public class BstRecursionTest{
	
	public static void main(String[] args) {

		BstRecursion<Integer, String> obj = new BstRecursion<Integer, String>();

		System.out.println(obj.isEmpty());
        System.out.println("Size : "+obj.size());
		
		obj.put(1,"B");
		obj.put(2,"T");
		obj.put(3,"S");
		obj.put(4,"A");
		obj.put(5,"R");
		obj.put(6,"M");
		obj.put(7,"Y");

		System.out.println("The keys : "+obj.keys(1,7));

		System.out.println("Value of the given key : "+obj.get(1));
		System.out.println("Value of the given key : "+obj.get(2));
		System.out.println("Value of the given key : "+obj.get(3));

        System.out.println(obj.isEmpty());
        System.out.println("Size : "+obj.size());


        assert(obj.isEmpty() == false);
		assert(obj.size() == 3);
		System.out.println("All the functions are working.");
	}
}