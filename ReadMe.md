# Java 8 Notes

### Lambda Expression
**How can we pass behaviour in java?** 

create an interface -> pass an implementation to the interface -> the method implementing interface is the behaviour we try to pass 
(could be an anonymous block of code.)

Even for passing anonymous implementation it requires, lots of boilerplate code. 
It still does not give an ability to store/assign as reference and pass the behaviour along.
So, comes to rescue: **Lambda expression** , anonymous code block it may take argument and return some result. 
Also, it removes boilerplate code - make the code more succinct.

##### Syntax of lambda expression

`(  arguments ) -> { block of code}`


##### Some examples of Lambda Expression

- No argument, returns nothing       :   `() -> System.out.println("Hi!!")`
- Takes two argument, returns sum    :   `(x, y) -> x+y`
- Multi-line bloack, Takes two argument, returns an int :  
 `(x, y) -> { int sum = x+y;
                int squareOfSum = sum*sum ; 
                return sum 
             } ;`
             
- Empty lambda block:` {} -> {}   `
 

### Functional Interface
- Interface with, exactly one method --> a lambda expression can passed instead of interface implementation.
- Java8 provides many in-built functional interface.
   `@FunctionalInterface`

- Some built-in functional interfaces defined in `java.util.function` package.
Example:
    - Function  : apply
    - BiFunction : apply(firstArg, secondArg))
    - Consumer
    - BiConsumer
    - Supplier
    - Predicate

### Method references
 - passing a reference to an exiting methods. Example: String::length , System.out::println
(Java 8 converts method reference into lambda expression.)
- method references can be reference to:
   - instance methods
   - static methods  
   - constructor.
- **Variable Scope:** We can't change an instance inside a lambda expression. Any attempt to change it, will result in compilation error.
(So, must be effectively final.)

### Composing Lambda:
  - helper static methods to be called on each of the argument.
    ArrayList.sort( books, Comparator.comparing(book -> book.getTitle()))

##### Read more:

- Java8 functional interface
- More on newly introduced default methods in java library. (for example, Comparator interface.)
