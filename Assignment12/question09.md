In ECMAScript 6 (ES6), you can define default parameter values for function parameters. Default parameter values allow you to assign a default value to a parameter in case no value or `undefined` is passed when calling the function. This provides a convenient way to handle missing or undefined values.

To define default parameter values, you can simply assign a value to the parameter in the function declaration. If a value is not provided when calling the function, the default value will be used instead.

Here's an example:

```
function greet(name = 'Anonymous') {
  console.log(`Hello, ${name}!`);
}

greet(); // Output: Hello, Anonymous!
greet('John'); // Output: Hello, John!
```

In the `greet()` function above, the `name` parameter has a default value of `'Anonymous'`. If no value is provided for `name` when calling the function, the default value is used. If a value is provided, it overrides the default value.

You can also use expressions or function calls as default parameter values. The expression or function call will be evaluated when the default value is needed.

```
function multiply(a, b = 2 * a) {
  return a * b;
}

console.log(multiply(5)); // Output: 50 (a = 5, b = 2 * 5 = 10)
console.log(multiply(5, 3)); // Output: 15 (a = 5, b = 3)
```

In the `multiply()` function above, the `b` parameter has a default value of `2 * a`. If `b` is not provided when calling the function, the default value will be evaluated as `2 * a`, where `a` takes the value passed as the first argument.

It's important to note that default parameter values are only used when the corresponding argument is `undefined` or not provided. Other falsy values like `null`, `false`, `0`, or an empty string will not trigger the default value and will be treated as valid argument values.

Default parameter values provide a convenient way to handle optional or missing values in function parameters, reducing the need for explicit checks or conditional assignments within the function body.