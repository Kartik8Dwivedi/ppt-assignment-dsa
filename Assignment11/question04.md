Media queries for print media serve the purpose of applying specific styles and layout adjustments when a web page is being printed or viewed in print preview. These media queries allow you to optimize the appearance and formatting of your web content for printed output, ensuring that it is legible and visually appealing when printed on paper.

The primary purpose of using media queries for print media is to tailor the presentation of the content to the characteristics and limitations of the printing medium. Here are a few common use cases and considerations for print media queries:

   Page layout: Media queries for print media can be used to define different page layouts, such as adjusting margins, page size, and orientation (portrait or landscape) to suit the printed page dimensions. For example, you may want to remove unnecessary navigation menus, sidebars, or other elements that are not relevant or practical for printed output.

   Typography: Print media queries enable you to control the typography and font styles specific to printed pages. You can set appropriate font sizes, line heights, and adjust the spacing to ensure legibility on paper. Additionally, you may want to use different fonts or font styles that are better suited for print.

   Colors and backgrounds: When printing a web page, the color capabilities are often limited compared to screens. Media queries for print media can help you adjust colors, backgrounds, and images to grayscale or other printer-friendly color modes, ensuring that the content remains readable and doesn't waste unnecessary ink.

   Pagination and page breaks: Media queries for print media allow you to control how the content is split across multiple printed pages. You can specify where page breaks should occur, prevent elements from being split across pages, or add specific headers and footers for each printed page.

Here's an example of a media query for print media:

@media print {
  /* Styles specific to print media */
  body {
    font-family: "Times New Roman", serif;
    font-size: 12pt;
    margin: 1cm;
  }
  /* ... other print-specific styles ... */
}

In this example, the styles inside the @media print media query will be applied when the page is being printed or viewed in print preview. The font family, font size, and margins are adjusted to suit the printed output.

By utilizing media queries for print media, you can optimize the presentation of your web content when it's printed, ensuring it maintains readability, preserves important information, and offers a pleasant user experience in the physical format.