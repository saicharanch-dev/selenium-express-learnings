1. If the returnType of abstract method in an interface is void,
when we use method reference( can be java's static method , or, existing method in codebase)
It will ignore the returnType of  method of method Reference


2. If the returnType of abstract method in an interface is not void,
    when we use method reference( can be java's static method , or, existing method in codebase)
    It will not ignore the returnType of  method of method Reference.
If both returnType not matches, it  will throw syntax error.


3. only static methods can be used as method reference
4. To use method reference, we need a functional interface
5. 