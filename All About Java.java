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

Q14 -> What is Lambda Expression?
A 	-> The Expression through which we can represent an Anonymous function.
	1.	Anonymous: Nameless/Unknown 
	2.	Anonymous Function: A method who dont have any name or modifier.

Q15 -> Can we write Lambda Expression for every method?
A 	-> No.
	Only can be applicable for functional interface.
	The method that is present in functional interface, for that method we can only write it.

	It reduces the boiler plate code, no need to repeat shit.

Q16 -> What is Stream in Java?
A 	-> Stream API is used to process collections of objects.
	A stream is a sequence of objects that supports various methods 
	which can be pipelined to produce the desired result.

	A stream is not  adata structure instead it takes input from the Collections,
	Arrays or I/O channels.

	Streams dont change the original data structure, they only provide the result
	as per teh piplelined methods.

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
	List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
	Collections.sort(entries, new Comparator)

	Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

	Using stream api now,

	map.entrySet().stream()
		.sorted(Map.Entry.comparingByKey().reverse())
		.forEach(t -> sysout(t));

	map.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.forEach(t -> sysout(t));

	// comparingByKey and comparingByValue has two overloaded methods 
	// one no args other with comparator

Q20 -> Difference between map() and flatMap() method?
A 	-> Both these methods are intermediate methods 
	and returns another stream as part of the output.

	map() method used for transformation.
	takes Stream<T> as inout and return Stream<R>
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
	sysout(emptyOptional); // we will get ptional.empty()

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
	Transform Stream[Object] to Stram of int


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











	




























