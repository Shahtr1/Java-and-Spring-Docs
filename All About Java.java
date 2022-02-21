Q1 -> What are default methods?
A  -> Before Java 8, interfaces could have only abstract methods.
	The implementation of these methods has to be provided in a separate class.
	 So, if a new method is to be added in an interface, then its implementation code has to be provided in the class implementing the same interface
	 To overcome this issue, Java 8 has introduced the concept of default methods which allow the interfaces to have methods with implementation without affecting the classes that implement the interface.

Q2 -> Static methods in interfaces?
A  -> The interfaces can have static methods as well which is similar to static method of classes.

Q3 -> Difference between Abstract class and Interface
A  -> 1) Abstract class can have abstract and non-abstract methods.
		Interface can have only abstract methods. Since Java 8, it can have default and static methods also.
	2) Abstract class doesn't support multiple inheritance.
		Interface supports multiple inheritance.
	3) Abstract class can provide the implementation of interface.
		Interface can't provide the implementation of abstract class.
	4) An abstract class can be extended using keyword "extends"
		An interface can be implemented using keyword "implements".
	5) A Java abstract class can have class members like private, protected, etc.
		Members of a Java interface are public by default.

Q4 -> What are Primitive Types?
A  -> Java defines eight primitive data types:
	byte, short, int, long, float, double, boolean and char.
	All other variables in java are object reference types.
	Primitive types in Java are called literals.
	Primitive types in Java are statically-typed, which means all variables must first be declared before they can be used,

Q5 -> What are Wrapper Classes?
A  -> A wrapper class is an object that encapsulates a primitive type. Each primitive type has a corresponding wrapper:
	Each wrapper class has Object as a superclass.
	Byte, Short, Integer, Long Float and Double have Number as their direct superclass.
	This means that each wrapper class can implement the methods of the Object class such as hashCode(), equals(Object obj), clone(), and toString().
	Since wrapper objects are reference types, their default value will be null.
	This behavior is important to understand when you are choose between using a primitive type or a wrapper object.

	Wrapper Objects are Immutable:
		All primitive wrapper objects in Java are final, which means they are immutable. When a wrapper object get its value modified, the compiler must create a new object and then reassign that object to the original.

	public void addOne(Integer i) {
	  i = i + 1;
	}

	This creation and eventual garbage collection of objects will add a lot of overhead, especially when doing large computations in loops.


Q6 -> What is Autoboxing?
A  -> Autoboxing is the automatic conversion of primitive types to their corresponding object wrapper classes.

	List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
		  numbers.add(i); 
		}

Q7 -> What is Unboxing?
A  -> Unboxing is the automatic conversion of object wrapper types into their corresponding primitive types.

	Integer a = new Integer(5);
	int b = a;


Q8 -> Explaing Equals Behaviour in Autoboxing and Unboxing?
A 	-> Autoboxing and Unboxing does not always happen with the “==” operator.
	It will compare the object’s reference in memory.

	When only one of the arguments of the “==” operator is an object and the other is a primitive type, unboxing will occur.

	To avoid situations like this we can use the .equals() operator.

Q9 -> When to use Primitive types?
A 	-> When doing a large amount of calculations, primitive types are always faster — they have much less overhead.
	When you don’t want the variable to be able to be null.
	When you don’t want the default value to be null.
	If the method must return a value

Q10 -> When to use Wrapper Class?
A 	-> When you are using Collections or Generics — it is required
	If you want the MIN_SIZE or MAX_SIZE of a type.
	If sometimes the method can return a null value.

Q11 -> What are First-Class Functions?
A 	-> A Programming language is said to have first-class functions if it treats functions as first-class citizens.

Q12 -> What is a First-Class Citizen?
A 	-> A first-class citizen (sometimes called first-class objects) is an entity which supports all the operations generally available to other entities. These operations typically include being passed as an argument, returned froma  function, and assigned to a variable.

Q13 -> What are closures?
A 	-> A closure is a record storing a function together with an environment: a mapping associating each free variable of the function with the value or storage location to which the name was bound when the closure was created. A closure, allows the function to access these captured variables through the closure's reference to them, even when the function is invoked outside their scope.
	<script>
		myFunction();
		document.getElementById("demo").innerHTML = a * a;

		function myFunction() {
			a = 4;
		} 
	</script>

Q14 -> What is Lambda Expression?
A 	-> The Expression through which we can represent an Anonymous function.
	1.	Anonymous: Nameless/Unknown 
	2.	Anonymous Function: A method who dont have any name or modifier.
	<script>
		var greet = function () {
			console.log("Welcome to GeeksforGeeks!");
		};
		
		greet();
	</script>

Q15 -> Can we write Lambda Expression for every method?
A 	-> No.
	Only can be applicable for functional interface.
	The method that is present in functional interface, for that method we can only write it.

	It reduces the boiler plate code, no need to repeat shit.

Q16 -> What is Stream in Java?
A 	-> Stream API is used to process collections of objects.
	A stream is a sequence of objects that supports various methods 
	which can be pipelined to produce the desired result.

	A stream is not a data structure instead it takes input from the Collections,
	Arrays or I/O channels.

	Streams dont change the original data structure, they only provide the result
	as per the piplelined methods.

Q17 -> Explain filter and forEach methods?
A 	-> filter - for conditional check
	forEach - for iteration 

	list.stream()
		.filter(t -> t.startsWith("m")) // uses predicate
		.forEach(t -> sysout("print " + t)); // uses consumer 

	map.forEach(key, value) -> sysout("key : " + value);
			or to use pipline methods
	map.entrySet().stream()
		.filter(k -> k.getKey() % 2 ==0)
		.forEach(obj -> sysout(obj));

Q18 -> How to sort a list using lambda?
A 	-> Collections.sort(list); // ascending
	Collections.reverse(list); // descending
	sysout(list);

	list.stream()
		.sorted()
		.forEach(s -> sysout(s)); // ascending

	list.stream()
		.sorted(Comparator.reverseOrder)
		.forEach(s -> sysout(s)); // descending

	Collections.sort(employees, (o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));

	sysout(employees);

	employees.stream()
		.sorted((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()))
		.forEach(t -> sysout(""))

	// we can also directly pass the lambda reference
	employees.stream()
		.sorted(Comparator.comparing(emp -> emp.getSalary()))
		.forEach(t -> sysout(""))

	// we can also directly pass the method reference
	employees.stream()
		.sorted(Comparator.comparing(Employee::getName))
		.forEach(t -> sysout(""))	

Q19 -> How to sort a map using lambda?
A 	-> 
	public class Employee implements Comparable<Employee> {

	    private Long id;
	    private String name;

	    // constructor, getters, setters

	    // override equals and hashCode
	    @Override
	    public int compareTo(Employee employee) {
	        return (int)(this.id - employee.getId());
	    }
	}

	Map<String, Employee> map = new HashMap<>();

	Employee employee1 = new Employee(1L, "Mher");
	map.put(employee1.getName(), employee1);
	Employee employee2 = new Employee(22L, "Annie");
	map.put(employee2.getName(), employee2);
	Employee employee3 = new Employee(8L, "John");
	map.put(employee3.getName(), employee3);
	Employee employee4 = new Employee(2L, "George");
	map.put(employee4.getName(), employee4);

	1.	Using a TreeMap:
		keys in TreeMap are sorted using their natural order.

		TreeMap<String, Employee> sorted = new TreeMap<>(map);


	2.	Using ArrayList:
		List<String> employeeByKey = new ArrayList<>(map.keySet());
		Collections.sort(employeeByKey);


	3.	Sort by Value:
		List<Employee> employeeById = new ArrayList<>(map.values());
		Collections.sort(employeeById);

	4.	Using a TreeSet:
		SortedSet<String> keySet = new TreeSet<>(map.keySet());
		SortedSet<Employee> values = new TreeSet<>(map.values());

	5.	Using Lambdas and Streams:
		Since the Java 8, we can use the Stream API and lambda expressions to sort the map. All we need is to call the sorted method over the map's stream pipeline.

		map.entrySet()
		  .stream()
		  .sorted(Map.Entry.<String, Employee>comparingByKey())
		  .forEach(System.out::println);

		map.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(System.out::println);


	

Q20 -> Difference between map() and flatMap() method?
A 	-> Both these methods are intermediate methods 
	and returns another stream as part of the output.

	map() method used for transformation.
	takes Stream<T> as input and return Stream<R>
	Its mapper function produces one value for each input value.
	hence it is also called One-to-One mapping

	flatMap() used for transformation & flattening.
	takes Stream of stream as input and return Stream 
	Its mapper function produces multiple value for each input value.
	hence it is also called One-to-Many mapping

	Data transformation:
		Stream.of("a", "b", "c", "d");
				to
			[A, B, C, D]

	Flattening:
		[[1, 2], [3, 4], [5, 6], [7, 8]]
				to
		[1, 2, 3, 4, 5, 6, 7, 8]

	Examples:
		// One-to-One
		List<string> emails = customers.stream()
			.map(customer -> customer.getEmail())
			.collect(Collectors.toList()); // converting back to list

		sysout(emails);


		// One-to-Many
			// if customer has multiple phone numbers
			List<List<string>> phoneNumbers = customers.stream()
				.map(customer -> customer.getPhoneNumbers())
				.collect(Collectors.toList());

			sysout(phoneNumbers);

			// go for flatMap
			List<string> phones = customers.stream()
				.flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());

			sysout(phones);

Q21 -> Define Optional object?
A 	-> Optional is a container object used to contain not-null objects.
	Optional object is used to represent null with absent value.
	This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.

	There are three ways to create Optional object
	1. empty
	2. of
	3. ofNullable

	Customer customer = new Customer(101, john, null, Arrays.asList("23323", "323"));

	Optional<Object> emptyOptional = Optional.empty();
	sysout(emptyOptional); // we will get optional.empty()

	Optional<String> emailOptional1 = Optional.of(customer.getEmail());
	sysout(emailOptional1);
	// returns new optional with value after running Objects.requreNonNull(value)
	// if(Null) throw NullPointerException

	Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
	// value == null ? empty() : of(value);
	sysout(emailOptional2);

	// if value is present we will get
	Optional[tramboos123@gmail.com]

	// to get exact value use get
	if(emailOptional2.isPresent()){
		sysout(emailOptional2.get());
	}

	// use default value, if emailOptional2.get() is null
	sysout(emailOptional2.orElse("default@email.com"))

	// thorw customized exception
	sysout(emailOptional2
		.orElseThrow(() -> new IllegalArgumentException("email not present")));

Q22 -> What is Map-Reduce?
A 	-> Map --> Transforming data.
	Transform Stream[Object] to Stream of int


	Reduce --> Aggregating data.
	combine stream of int and produce the sum result

	T reduce(T identity, BinaryOperator<T> accumulator);
	1.	identity is initial value of type T 
	2.	accumulator is a function for cimbining two values

	Integer sumResult = Stream.of(2, 4, 6, 9, 1, 3, 7)
			.reduce(0, (a, b) -> a + b);

	Identity: 0 which is initial value
	Accumulator: (a, b) -> a + b function


Q23 -> What is Java Parallel Streams?
A  	-> Java Parallel Streams is a feature of Java 8.
	The order of execution is not under our control.

	// code starts
	long start = 0;
	long end = 0;

	start = System.currenttiomeMillis();
	IntStream.range(1, 100).forEach(System.out::println);
	end = System.currenttiomeMillis();
	sysout("Time taken: " + (end - start));

	sysout("=============================================");

	start = System.currenttiomeMillis();
	IntStream.range(1, 100).Parallel().forEach(System.out::println);
	end = System.currenttiomeMillis();
	sysout("Parallel Time taken: " + (end - start));

Q24 -> What is diamond problem?
A 	-> Suppose you have the both Animals and Animals1 implementing the same interface IAnimals:
	interface IAnimals
	{
		public string eat();
	}

	abstract class Animals implements IAnimals
	{
		public abstract void run();
		public string eat(){ return "Animals eating"; } 
	}

	abstract class Animals1 implements IAnimals
	{
		public abstract void run1();
		public string eat(){ return "Animals1 eating"; } 
	}

	If you now define your Dog class:

	class Dog extends Animals,Animals1
	{
	public void run() {System.out.println("Run method");}
	public void run1() {System.out.println("Run1 method");}
	}

	It will have the method eat() too, which is not abstract so it can use it directly. 
	What would be the return of this method for a dog? Which string will be returned, the one with Animals, or the one with Animals1?


Q27 -> What is entry interface in Java?
A 	-> Map.Entry interface in Java provides certain methods to access the entry in the Map.



Q26 -> What is entrySet And KeySet in maps?
A 	-> Let's create and initialize a HashMap whose key is of type String and value is of type Integer:
	
	Map<String, Integer> map = new HashMap<>();
	map.put("one", 1);
	map.put("two", 2);

	The keySet() Method:
	The keySet() method returns the Set of keys contained in the Map. 
		Set<String> actualValues = map.keySet();

		assertEquals(2, actualValues.size());

	The entrySet() Method:
	The entrySet() method returns the set of key-value mappings. 
	Set<Map.Entry<String, Integer>> actualValues = map.entrySet

	assertTrue(actualValues.contains(new SimpleEntry<>("one", 1)));
	assertTrue(actualValues.contains(new SimpleEntry<>("two", 2)));

	Here, we've chosen the AbstractMap.SimpleEntry implementation of the interface Map.Entry for our test.


Q27 -> What is Comparator and Comparable in Java?
A   -> They are interfaces.

	Comparable:
	public class Player implements Comparable<Player> {

	    private int ranking;
	    private String name;
	    private int age;
	    
	    // constructor, getters, setters  


	    @Override
	    public int compareTo(Player otherPlayer) {
	        return Integer.compare(getRanking(), otherPlayer.getRanking());
	    }

	}

	public static void main(String[] args) {
	    List<Player> footballTeam = new ArrayList<>();
	    Player player1 = new Player(59, "John", 20);
	    Player player2 = new Player(67, "Roger", 22);
	    Player player3 = new Player(45, "Steven", 24);
	    footballTeam.add(player1);
	    footballTeam.add(player2);
	    footballTeam.add(player3);

	    System.out.println("Before Sorting : " + footballTeam);
	    Collections.sort(footballTeam);
	    System.out.println("After Sorting : " + footballTeam);
	}


	------------------------------------------------

	Comparator:
	The Comparator interface defines a compare(arg1, arg2) method with two arguments that represent compared objects, and works similarly to the Comparable.compareTo() method.

	To create a Comparator, we have to implement the Comparator interface.

	For our first example, we'll create a Comparator to use the ranking attribute of Player to sort the players:

	public class PlayerRankingComparator implements Comparator<Player> {

	    @Override
	    public int compare(Player firstPlayer, Player secondPlayer) {
	       return Integer.compare(firstPlayer.getRanking(), secondPlayer.getRanking());
	    }

	}
	Similarly, we can create a Comparator to use the age attribute of Player to sort the players:

	public class PlayerAgeComparator implements Comparator<Player> {

	    @Override
	    public int compare(Player firstPlayer, Player secondPlayer) {
	       return Integer.compare(firstPlayer.getAge(), secondPlayer.getAge());
	    }

	}

	Using this approach, we can override the natural ordering:

	PlayerRankingComparator playerComparator = new PlayerRankingComparator();
	Collections.sort(footballTeam, playerComparator);

	If we want a different sorting order, we only need to change the Comparator we're using

	The Comparable interface is a good choice to use for defining the default ordering, or in other words, if it's the main way of comparing objects.

	Sometimes we can't modify the source code of the class whose objects we want to sort, thus making the use of Comparable impossible


	NOTE: Avoiding the Subtraction Trick
	Comparator<Player> comparator = (p1, p2) -> p1.getRanking() - p2.getRanking();
	Although it's much more concise than other solutions, it can be a victim of integer overflows in Java:

	However, due to integer overflow, the “Integer.MAX_VALUE – (-1)” will be less than zero. 


Q28 -> What is Java equals() and hashCode() Contract?
A 	-> The Object class defines both the equals() and hashCode() methods – which means that these two methods are implicitly defined in every Java class, including the ones we create:
	
	class Money {
	    int amount;
	    String currencyCode;
	}

	Money income = new Money(55, "USD");
	Money expenses = new Money(55, "USD");
	boolean balanced = income.equals(expenses)

	@Override
	public boolean equals(Object o) {
	    if (o == this)
	        return true;
	    if (!(o instanceof Money))
	        return false;
	    Money other = (Money)o;
	    boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
	      || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
	    return this.amount == other.amount && currencyCodeEquals;
	}


	equals() Contract:
	Java SE defines a contract that our implementation of the equals() method must fulfill. Most of the criteria are common sense. The equals() method must be:
		reflexive: an object must equal itself
		symmetric: x.equals(y) must return the same result as y.equals(x)
		transitive: if x.equals(y) and y.equals(z) then also x.equals(z)
		consistent: the value of equals() should change only if a property that is contained in equals() changes (no randomness allowed)

	---------------------------------------------------------------------------------------------

	hashCode():
	hashCode() returns an integer representing the current instance of the class. 
	We should calculate this value consistent with the definition of equality for the class. Thus if we override the equals() method, we also have to override hashCode().

	

	


















	




























