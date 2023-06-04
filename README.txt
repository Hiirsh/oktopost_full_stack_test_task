
Task 1: None Unique Values
--------------------------

	Implement a method that given an array of integers A, will return a new array B, that 
	contains only the integers that appear more then once in A. 
		
	For example for input:
	[1, 2, 3, 4, 5, 2, 4]
		
	The output must be:
	[2, 4]
		
	Notes:  
	1. The algorithm must be of the lowest complexity possible.
	2. The array can be of different size and can contain both positive, negative and 0 values.
	3. The values will always be integer numbers.
	4. The order of the output is not important. Both [2, 4] and [4, 2] are valid answers for the example above.
	5. Feel free to alter, add or remove unit tests.
	6. Implementing unit tests is optional.
	7. Do not use sorting functions like [sort] or [array_unique].
		
		
	Project Setup:
		> composer install
		
	Running tests:
		> composer test
	or
		> composer test-cover 
	for coverage tests. 



Task 2: Storage
---------------
	
	Build a storage class capable of storing a predefined number of key-value pairs.
	This storage class must have 2 functions: get(string $key) and put(string $key, string $value).
	
	The methods must do the following.
	- get method will return a value for given key, or null if the key was not found.
	- put method will insert a new key value pair into the storage (or override existing key). 
	  If the storage is at maximum capacity, the pair which was least recently accessed (by either get or put) must be replaced by the new pair.
	  Pair considered to be used if the get or put methods are called with the pair's key.
	   
	For example in the following code:
	
	// 3 is the maximum number of items this storage item should hold. 
	$s = new Storage(3);
	
	$s->put('a', '1');
	$s->put('b', '2');
	$s->put('c', '3');
	$s->get('c');
	$s->get('b');
	$s->get('a');
	
	Of the keys 'a', 'b', and 'c', 'c' is the least recently accessed. Therefore, any put operation at this
	point will replace the 'c' => '3' key-value pair with the new pair.
	See StoreTest test class for more examples. 
	
	!!! Please note that the most important aspect of this task is the algorithm you 
	!!! choose to use. Both get and put methods must be solved with complexity of O(1) - 
	!!! meaning the most efficient solution you can find.
	
	Notes:
	1. Keys are unique. Putting the sam key again will result in overriding it's current value.  
	2. Both put and get methods should reset the priority of the value. 
	3. You can assume that the keys will always contain only 'a' to 'z' characters and be at least one character long.
	4. Implementing unit tests is optional.
	
	
	Project Setup:
		> composer install
	
	Running tests:
		> composer test
	or
		> composer test-cover 
	for coverage tests. 


Good luck.
