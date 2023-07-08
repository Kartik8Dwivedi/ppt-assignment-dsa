Destructuring assignment is a feature introduced in ECMAScript 6 (ES6) that allows you to extract values from arrays and properties from objects into separate variables. It provides a concise and convenient way to unpack values.

1. Destructuring Arrays:
   To destructure an array, you use square brackets `[]` on the left side of the assignment, matching the pattern of the array's elements:

   ```
   const numbers = [1, 2, 3, 4];
   const [a, b, c, d] = numbers;
   console.log(a, b, c, d); // Output: 1 2 3 4
   ```

   You can also skip elements using commas if you are interested in only certain values:

   ```
   const [a, , c] = numbers;
   console.log(a, c); // Output: 1 3
   ```

2. Destructuring Objects:
   To destructure an object, you use curly braces `{}` on the left side of the assignment, matching the property names:

   ```
   const person = {
     name: 'John',
     age: 25,
     city: 'New York',
   };
   const { name, age, city } = person;
   console.log(name, age, city); // Output: John 25 New York
   ```

   You can also assign the extracted properties to new variable names:

   ```
   const { name: personName, age: personAge } = person;
   console.log(personName, personAge); // Output: John 25
   ```

   If you want to provide default values for properties that may not exist, you can use the assignment operator (`=`):

   ```
   const { name, age, city = 'Unknown' } = person;
   console.log(name, age, city); // Output: John 25 Unknown
   ```

3. Destructuring Parameters:
   Destructuring can also be used directly in function parameters. This allows you to extract specific values from objects or arrays passed as arguments to a function:

   ```
   function greet({ name, age }) {
     console.log(`Hello, ${name}! You are ${age} years old.`);
   }

   const person = {
     name: 'John',
     age: 25,
   };

   greet(person); // Output: Hello, John! You are 25 years old.
   ```

   In the example above, the `greet` function uses destructuring in the parameter to directly access the `name` and `age` properties of the passed object.

Destructuring can be used for both arrays and objects, providing a concise way to extract values and properties. It simplifies code and improves readability, especially when working with complex data structures.