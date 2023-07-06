In CSS, the 'z-index' property controls the stacking order of positioned elements on a web page along the z-axis (the depth axis). It determines which elements appear in front of or behind other elements when they overlap in the layout.

Here's how 'z-index' functions:

01. Stacking Context: Each positioned element with a 'z-index' value other than auto creates a stacking context. A stacking context is a hierarchical structure that defines the stacking order within a specific element and its descendants.

02. Numeric Values: The 'z-index' property accepts integer or numeric values, such as positive or negative integers or zero. The value determines the element's stacking order relative to other elements in the same stacking context. Higher 'z-index' values bring elements closer to the viewer, appearing in front of elements with lower 'z-index' values.

03. Stacking Order: Elements with a higher 'z-index' value will be placed in front of elements with lower 'z-index' values within the same stacking context. Elements with the same 'z-index' value are stacked based on their order in the HTML structure, with the last defined element appearing on top.

04. Stacking Context Hierarchy: If an element with a higher 'z-index' value is contained within another element with a lower 'z-index' value, the stacking order is determined by the stacking context hierarchy. Elements in a higher stacking context will appear in front of elements in a lower stacking context, regardless of their 'z-index' values.

05. Positioning Requirements: To use the 'z-index' property, an element needs to have a positioning value other than static. Elements with position: relative, position: absolute, or position: fixed can be assigned a 'z-index' value.

'
.element-one {
  position: relative;
  z-index: 2;
}

.element-two {
  position: relative;
  z-index: 1;
}

.element-three {
  position: relative;
  z-index: 3;
}
'

In this example, element-three would be displayed in front of both element-one and element-two since it has the highest 'z-index' value. element-one would be displayed above element-two since it has a higher 'z-index' value.

Understanding and properly using the 'z-index' property is important when dealing with overlapping elements or complex layouts. It allows you to control the layering of elements and ensures the desired visual hierarchy is maintained on your web page.