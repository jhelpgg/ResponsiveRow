# ResponsiveRow Composable

This composable provides a responsive layout solution for arranging child elements in a row. It
adapts to the available space, placing items horizontally in a single row if possible, or
distributing them across multiple rows for a balanced visual appearance.

## Features

- **Adaptive Layout:** Automatically adjusts to the available width, creating multiple rows when
  necessary.
- **Balanced Arrangement:** Distributes elements evenly across rows to avoid drastic differences in
  row lengths.
- **Customization:**
    - `horizontalArrangement`: Control how elements are spaced horizontally within a row (e.g.,
      `Arrangement.Start`, `Arrangement.SpaceAround`, `Arrangement.Expand`).
    - `verticalAlignment`: Control how elements are aligned vertically within their rows (e.g.,
      `Alignment.Top`, `Alignment.CenterVertically`).
    - `verticalSpace`: Adjust the vertical spacing between rows.
- **Easy to Use:** Simply provide child elements within the `content` lambda.

## Usage

```kotlin
ResponsiveRow(horizontalArrangement = Arrangement.Expand,
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.fillMaxWidth()) {
    Text("Short", modifier = Modifier.background(LIGHT_ RED))
    Text("Normal text", modifier = Modifier.background(LIGHT_ GREEN))
    Text("This is a long text\nSecond line", modifier = Modifier.background(LIGHT_ BLUE))
    Text("A text again", modifier = Modifier.background(LIGHT_ GRAY))
    Text("Text, text and more", modifier = Modifier.background(YELLOW))
    Text("Last text", modifier = Modifier.background(LIGHT_ RED))
}
```

## How it Works

1. **Measurement:** The composable measures each child element to determine its size.
2. **Arrangement:** It calculates the optimal number of rows and distributes elements evenly.
3. **Positioning:** Elements are positioned based on the `horizontalArrangement`,
   `verticalAlignment`, and available space.

## Example

Different settings for horizontalArrangement :

* [horizontalArrangement = Arrangement.Expand](doc/ResponsiveRowExpand.mp4)
* [horizontalArrangement = Arrangement.Start](doc/ResponsiveRowStart.mp4)
* [horizontalArrangement = Arrangement.End](doc/ResponsiveRowEnd.mp4)
* [horizontalArrangement = Arrangement.Center](doc/ResponsiveRowCenter.mp4)
* [horizontalArrangement = Arrangement.SpaceAround](doc/ResponsiveRowSpaceAround.mp4)
* [horizontalArrangement = Arrangement.SpaceBetween](doc/ResponsiveRowSpaceBetween.mp4)
* [horizontalArrangement = Arrangement.SpaceEvenly](doc/ResponsiveRowSpaceEvenly.mp4)

## Notes

- The `Arrangement.Expand` option for `horizontalArrangement` attempts to make all elements as wide
  as possible while maintaining harmony.
- The composable considers the layout direction (LTR or RTL) for proper element placement.
