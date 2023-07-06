In CSS, the display property is used to define how an element should be rendered on a web page. Three common values for the display property are "inline," "inline-block," and "block." Here's a breakdown of the differences between these three display types:

01. Inline:

    Inline elements do not start on a new line. They flow within the text content and only occupy the space necessary to display their content.

    Inline elements do not have a width or height. Instead, their dimensions are determined by the content they contain.
    
    Examples of inline elements include <span>, <a>, <strong>, and <em>.

02. Inline-block:

    Inline-block elements are similar to inline elements in that they flow within the text content and do not start on a new line.
    Unlike inline elements, inline-block elements have a width and height that can be specified. They also respect top and bottom margins and padding.

    Inline-block elements can contain other block or inline elements.

    Examples of inline-block elements include <input>, <img>, and <button>.

03. Block:

    Block elements start on a new line and occupy the full available width of their parent container by default.

    Block elements have a width and height that can be specified, and they can have top and bottom margins and padding.

    Block elements create a visual block on the page, and subsequent elements are displayed on new lines below them.

    Examples of block elements include <div>, <p>, <h1> to <h6>, and <ul>.

    HTML:

    `
    <span class="inline-example">Inline</span>
    <span class="inline-block-example">Inline Block</span>
    <div class="block-example">Block</div>
    `

    CSS:

    `
    .inline-example {
  display: inline;
}

.inline-block-example {
  display: inline-block;
  width: 200px;
  height: 100px;
  background-color: lightblue;
}

.block-example {
  display: block;
  width: 200px;
  height: 100px;
  background-color: lightgreen;
}
`

In this example, the "Inline" text appears within the text content and does not create a visual block. The "Inline Block" element occupies the specified width and height, flowing within the text content. The "Block" element starts on a new line and occupies the full width of its container, creating a visual block.

Understanding the differences between inline, inline-block, and block elements is essential for controlling the layout and behavior of elements on a web page.
  