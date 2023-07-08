Template literals, introduced in ECMAScript 6 (ES6), are an enhanced way to work with strings in JavaScript. They allow for easy concatenation of strings and the embedding of expressions within backticks (`) instead of single or double quotes.

To use template literals, you enclose your string within backticks instead of quotes:

```
const name = 'John';
const greeting = `Hello, ${name}!`;
console.log(greeting); // Output: Hello, John!
```

In the example above, the variable `name` is embedded within the template literal using the `${}` syntax. The expression inside `${}` is evaluated and the resulting value is included in the final string. This is called string interpolation.

Template literals provide several advantages:

01. String Interpolation: As shown above, you can directly embed variables, expressions, or function calls within a template literal, making it easier to include dynamic values in your strings without the need for concatenation or string manipulation.

02. Multi-line Strings: Template literals support multi-line strings without the need for explicit line breaks or escape characters. You can simply include line breaks within the template literal, and the resulting string will retain the formatting.

```
const message = `
  This is a multi-line
  string using
  template literals.
`;
console.log(message);
// Output:
//   This is a multi-line
//   string using
//   template literals.
```

03. Expression Evaluation: Template literals allow for the evaluation of expressions within `${}`. You can include any valid JavaScript expression, such as mathematical calculations or function calls, and the resulting value will be included in the string.

```
const a = 5;
const b = 10;
const sum = `The sum of ${a} and ${b} is ${a + b}.`;
console.log(sum); // Output: The sum of 5 and 10 is 15.
```

04. Tagged Templates: Template literals can be "tagged" with a function, allowing you to perform custom processing on the template. The tag function is invoked with an array of string literals and the evaluated expressions, allowing you to manipulate the final string output.

```
function highlight(strings, ...values) {
  let result = '';
  strings.forEach((string, index) => {
    result += string;
    if (index < values.length) {
      result += `<strong>${values[index]}</strong>`;
    }
  });
  return result;
}

const name = 'John';
const age = 25;
const message = highlight`Hello, ${name}! You are ${age} years old.`;
console.log(message);
// Output: Hello, <strong>John</strong>! You are <strong>25</strong> years old.
```

In the example above, the `highlight` function is used as a tag function to add `<strong>` tags around the interpolated values.

Template literals provide a more concise and expressive way to work with strings in JavaScript, improving code readability and reducing the need for string concatenation and manipulation.