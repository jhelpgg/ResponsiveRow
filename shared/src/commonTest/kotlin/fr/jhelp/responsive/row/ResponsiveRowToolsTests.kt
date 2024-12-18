package fr.jhelp.responsive.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import fr.jhelp.responsive.Expand
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.math.max

class ResponsiveRowToolsTests
{
    @Test
    fun adjustmentNotExpand()
    {
        // 600
        var rowInResponsiveRow = this.rowInResponsiveRow()
        var rows = adjustRowsOfResponsiveRow(rowInResponsiveRow, 600, false)
        assertEquals(2, rows.size)
        assertEquals(3, rows[0].size)
        assertEquals(2, rows[1].size)

        var row = rows[0]
        assertEquals(200 + 100 + 300, row.width)
        assertEquals(200, row.elements[0].width)
        assertEquals(100, row.elements[1].width)
        assertEquals(300, row.elements[2].width)
        assertEquals(maxOf(50, 100, 25), row.height)

        row = rows[1]
        assertEquals(150 + 250, row.width)
        assertEquals(150, row.elements[0].width)
        assertEquals(250, row.elements[1].width)
        assertEquals(maxOf(75, 125), row.height)

        // 500
        rowInResponsiveRow = this.rowInResponsiveRow()
        rows = adjustRowsOfResponsiveRow(rowInResponsiveRow, 500, false)
        assertEquals(3, rows.size)
        assertEquals(2, rows[0].size)
        assertEquals(2, rows[1].size)
        assertEquals(1, rows[2].size)

        row = rows[0]
        assertEquals(200 + 100, row.width)
        assertEquals(200, row.elements[0].width)
        assertEquals(100, row.elements[1].width)
        assertEquals(maxOf(50, 100), row.height)

        row = rows[1]
        assertEquals(300 + 150, row.width)
        assertEquals(300, row.elements[0].width)
        assertEquals(150, row.elements[1].width)
        assertEquals(maxOf(25, 75), row.height)

        row = rows[2]
        assertEquals(250, row.width)
        assertEquals(250, row.elements[0].width)
        assertEquals(125, row.height)

        // 400
        rowInResponsiveRow = this.rowInResponsiveRow()
        rows = adjustRowsOfResponsiveRow(rowInResponsiveRow, 400, false)
        assertEquals(3, rows.size)
        assertEquals(2, rows[0].size)
        assertEquals(1, rows[1].size)
        assertEquals(2, rows[2].size)

        row = rows[0]
        assertEquals(200 + 100, row.width)
        assertEquals(200, row.elements[0].width)
        assertEquals(100, row.elements[1].width)
        assertEquals(maxOf(50, 100), row.height)

        row = rows[1]
        assertEquals(300, row.width)
        assertEquals(300, row.elements[0].width)
        assertEquals(25, row.height)

        row = rows[2]
        assertEquals(150 + 250, row.width)
        assertEquals(150, row.elements[0].width)
        assertEquals(250, row.elements[1].width)
        assertEquals(maxOf(75, 125), row.height)
    }

    @Test
    fun adjustmentExpand()
    {
        // 600
        var rowInResponsiveRow = this.rowInResponsiveRow()
        var rows = adjustRowsOfResponsiveRow(rowInResponsiveRow, 600, true)
        assertEquals(2, rows.size)
        assertEquals(3, rows[0].size)
        assertEquals(2, rows[1].size)

        var row = rows[0]
        assertEquals(600, row.width)
        assertEquals(200, row.elements[0].width)
        assertEquals(100, row.elements[1].width)
        assertEquals(300, row.elements[2].width)
        assertEquals(maxOf(50, 100, 25), row.height)

        row = rows[1]
        assertEquals(600, row.width)
        assertEquals(300, row.elements[0].width)
        assertEquals(300, row.elements[1].width)
        assertEquals(maxOf(75, 125), row.height)

        // 500
        rowInResponsiveRow = this.rowInResponsiveRow()
        rows = adjustRowsOfResponsiveRow(rowInResponsiveRow, 500, true)
        assertEquals(3, rows.size, "$rows")
        assertEquals(2, rows[0].size)
        assertEquals(2, rows[1].size)
        assertEquals(1, rows[2].size)

        row = rows[0]
        assertEquals(500, row.width)
        assertEquals(250, row.elements[0].width)
        assertEquals(250, row.elements[1].width)
        assertEquals(maxOf(50, 100), row.height)

        row = rows[1]
        assertEquals(500, row.width)
        assertEquals(300, row.elements[0].width)
        assertEquals(200, row.elements[1].width)
        assertEquals(maxOf(25, 75), row.height)

        row = rows[2]
        assertEquals(500, row.width)
        assertEquals(500, row.elements[0].width)
        assertEquals(125, row.height)

        // 400
        rowInResponsiveRow = this.rowInResponsiveRow()
        rows = adjustRowsOfResponsiveRow(rowInResponsiveRow, 400, true)
        assertEquals(3, rows.size)
        assertEquals(2, rows[0].size)
        assertEquals(1, rows[1].size)
        assertEquals(2, rows[2].size)

        row = rows[0]
        assertEquals(400, row.width)
        assertEquals(200, row.elements[0].width)
        assertEquals(200, row.elements[1].width)
        assertEquals(maxOf(50, 100), row.height)

        row = rows[1]
        assertEquals(400, row.width)
        assertEquals(400, row.elements[0].width)
        assertEquals(25, row.height)

        row = rows[2]
        assertEquals(400, row.width)
        assertEquals(150, row.elements[0].width)
        assertEquals(250, row.elements[1].width)
        assertEquals(maxOf(75, 125), row.height)
    }

    @Test
    fun spaceMeasuredTest()
    {
        assertEquals(SpaceMeasured(0, 0, 50),
                     spaceMeasured(50, 3, Arrangement.Start, false),
                     "Start LTR")

        assertEquals(SpaceMeasured(50, 0, 0),
                     spaceMeasured(50, 3, Arrangement.Start, true),
                     "Start RTL")

        assertEquals(SpaceMeasured(50, 0, 0),
                     spaceMeasured(50, 3, Arrangement.End, false),
                     "End LTR")

        assertEquals(SpaceMeasured(0, 0, 50),
                     spaceMeasured(50, 3, Arrangement.End, true),
                     "End RTL")

        assertEquals(SpaceMeasured(25, 0, 25),
                     spaceMeasured(50, 3, Arrangement.Center, false),
                     "Center LTR")

        assertEquals(SpaceMeasured(25, 0, 25),
                     spaceMeasured(50, 3, Arrangement.Center, true),
                     "Center RTL")

        assertEquals(SpaceMeasured(0, 25, 0),
                     spaceMeasured(50, 3, Arrangement.SpaceBetween, false),
                     "SpaceBetween LTR")

        assertEquals(SpaceMeasured(0, 25, 0),
                     spaceMeasured(50, 3, Arrangement.SpaceBetween, true),
                     "SpaceBetween RTL")

        assertEquals(SpaceMeasured(9, 16, 9),
                     spaceMeasured(50, 3, Arrangement.SpaceAround, false),
                     "SpaceAround LTR")

        assertEquals(SpaceMeasured(9, 16, 9),
                     spaceMeasured(50, 3, Arrangement.SpaceAround, true),
                     "SpaceAround RTL")

        assertEquals(SpaceMeasured(13, 12, 13),
                     spaceMeasured(50, 3, Arrangement.SpaceEvenly, false),
                     "SpaceEvenly LTR")

        assertEquals(SpaceMeasured(13, 12, 13),
                     spaceMeasured(50, 3, Arrangement.SpaceEvenly, true),
                     "SpaceEvenly RTL")

        assertEquals(SpaceMeasured(0, 0, 0),
                     spaceMeasured(50, 3, Arrangement.Expand, false),
                     "Expand LTR")

        assertEquals(SpaceMeasured(0, 0, 0),
                     spaceMeasured(50, 3, Arrangement.Expand, true),
                     "Expand RTL")
    }

    @Test
    fun deltaYTest()
    {
        assertEquals(0, deltaY(50, 100, Alignment.Top))
        assertEquals(25, deltaY(50, 100, Alignment.CenterVertically))
        assertEquals(50, deltaY(50, 100, Alignment.Bottom))
    }

    private fun rowInResponsiveRow(): RowInResponsiveRow
    {
        val rowInResponsiveRow = RowInResponsiveRow()
        rowInResponsiveRow.add(PlaceableInfo(200, 50))
        rowInResponsiveRow.add(PlaceableInfo(100, 100))
        rowInResponsiveRow.add(PlaceableInfo(300, 25))
        rowInResponsiveRow.add(PlaceableInfo(150, 75))
        rowInResponsiveRow.add(PlaceableInfo(250, 125))
        return rowInResponsiveRow
    }

    private fun maxOf(first:Int, vararg values: Int): Int
    {
        var max = first

        for (value in values)
        {
            max = max(max, value)
        }

        return max
    }
}