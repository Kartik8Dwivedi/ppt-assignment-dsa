The main difference between the `map()` and `forEach()` methods in JavaScript lies in their return values and their effects on the original array.

1. Return Value:
   - The `map()` method returns a new array containing the results of applying a provided function to each element of the original array. It creates a new array with the same length as the original, where each element is the result of the applied function.
   - The `forEach()` method, on the other hand, does not return anything. It simply executes a provided function once for each element in the array, without modifying the original array.

2. Modifying the Original Array:
   - The `map()` method does not modify the original array. It produces a new array with transformed values based on the applied function, leaving the original array unchanged.
   - The `forEach()` method also does not modify the original array. It iterates through each element of the array and executes the provided function, but it does not alter the original array's elements.

Example usage of `map()`:

```
const numbers = [1, 2, 3, 4];
const doubled = numbers.map((num) => num * 2);
console.log(doubled); // Output: [2, 4, 6, 8]
console.log(numbers); // Output: [1, 2, 3, 4] (original array is unchanged)
```

Example usage of `forEach()`:

```
const numbers = [1, 2, 3, 4];
numbers.forEach((num) => console.log(num * 2));
// Output:
// 2
// 4
// 6
// 8
console.log(numbers); // Output: [1, 2, 3, 4] (original array is unchanged)
```

In the `map()` example, a new array `doubled` is created, containing the doubled values of each element in the original `numbers` array. The original array remains unmodified.

In the `forEach()` example, the provided function is executed for each element of the `numbers` array, but it does not create a new array or modify the original array.

Both methods are useful in different scenarios:
- Use `map()` when you want to transform each element of an array and collect the results in a new array.
- Use `forEach()` when you simply want to iterate over the elements of an array and perform some action for each element.

It's important to note that both `map()` and `forEach()` iterate over the elements of an array, but the primary distinction is the return value and the effect on the original array.