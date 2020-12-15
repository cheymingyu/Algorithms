package app;

// Java does not allow declaring a static class syntactically.
// But, we can make a class that is just like a static class in Java as follows:
public final class AppView { // Declaration of static class in Java...
	// "final" will prevent inheritance of static class "AppView"
	// because inheritance has no meaning for a static class

	private static final boolean DEBUG_MODE = true;
	
	// The constructor should be private.
	// Otherwise, this constructor could be called some other places.
	// But, such a call which cannot be prevented by Java compiler has no meaning for a static class.
	private AppView() {
		
	}
	
	// Every member method should be static.
	// Although you can declare non-static members, such members will be useless.
	public static void outputLine(String aString) {
		System.out.println(aString);
	}
	
	public static void output(String aString) {
		System.out.print(aString);
	}
	
	public static void outputDebugMessage(String aString) {
		if (DEBUG_MODE) {
			System.out.print(aString);
		}
	}
}
