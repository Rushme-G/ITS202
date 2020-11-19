public class STsequentialTest{
	
	public static void main(String[] args) {

		STsequentialsearch<Integer, String> obj = new STsequentialsearch<Integer, String>();

		System.out.println(obj.isEmpty());
        System.out.println("Size : "+obj.size());
		
		obj.put(1,"B");
		obj.put(2,"S");
		obj.put(3,"T");
		obj.put(4,"A");
		obj.put(5,"M");
		obj.put(6,"M");
		obj.put(7,"Y");

		System.out.println("All the keys : "+obj.keys());

		System.out.println("Value of the given key : "+obj.get(1));
		System.out.println("Value of the given key : "+obj.get(2));
		System.out.println("Value of the given key : "+obj.get(3));

		obj.delete(2);
		obj.delete(3);
		obj.delete(5);

        System.out.println(obj.isEmpty());
        System.out.println("Size : "+obj.size());
        System.out.println("All the keys : "+obj.keys());

        obj.put(2,"T");
        obj.put(3,"S");
        obj.put(5,"R");

        System.out.println("Value of the given key : "+obj.get(1));
		System.out.println("Value of the given key : "+obj.get(2));
		System.out.println("Value of the given key : "+obj.get(3));
		System.out.println("Value of the given key : "+obj.get(4));
		System.out.println("Value of the given key : "+obj.get(5));
		System.out.println("Value of the given key : "+obj.get(6));
		System.out.println("Value of the given key : "+obj.get(7));

        assert(obj.isEmpty() == false);
		assert(obj.size() == 3);
		System.out.println("All the functions are working.");
	}
}