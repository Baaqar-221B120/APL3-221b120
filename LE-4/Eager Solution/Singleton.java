// Eager Solution
public class Singleton // for mutli threaded programs ; at a cost of stagnant memory use.
{
    private static Singleton2uniqueIns = new Singleton();
    private Singleton() {}; // => ensures no other class can create an object
	public static Singleton getIns() {
		return uniqueIns; // reference to the object (object is in heap)
	}
}
