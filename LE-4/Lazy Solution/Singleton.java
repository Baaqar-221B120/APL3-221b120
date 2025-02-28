// Lazy Solution
public class Singleton // for single threaded programs
{
    private static Singleton uniqueIns;
    private Singleton() {}; // => ensures no other class can create an object
	public static Singleton getIns() {
		if (uniqueIns == null)
		    uniqueIns = new Singleton();
		return uniqueIns; // reference to the object (object is in heap)
	}
}
