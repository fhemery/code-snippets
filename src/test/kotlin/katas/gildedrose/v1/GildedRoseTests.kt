package katas.gildedrose.v1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GildedRoseTests {

    @Test
    fun foo() {
        val items = arrayOf(Item("foo", 0, 0))
        updateQualityByOneDay(items)
        assertEquals("foo", items[0].name)
    }

    @Test
    fun `by default the sellIn value decreases`() {
        val items = arrayOf(
            Item("foo", 5, 10),
            Item("Conjured Manu's mighty hammer", 5, 10),
            Item("Aged Brie", 5,10),
            Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)
        )

        updateQualityByOneDay(items)

        items.forEach{
            assertEquals(it.sellIn, 4, "${it.name}: sellIn is not right")
        }
    }

    @Test
    fun `sulfuras sellIn value does not decrease`() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 5, 10))
        updateQualityByOneDay(items)

        assertEquals(items[0].sellIn,5)
    }



    @Test
    fun `regular items should lose one quality every day when sell in date is not overdue`() {
        val items = arrayOf(Item("foo", 5, 10))

        updateQualityByOneDay(items)

        assertTrue { items[0].quality == 9 }
    }

    @Test
    fun `regular items should lose two quality points every day when sell in date is passed`() {
        val items = arrayOf(Item("soldItem", -1, 10))
        updateQualityByOneDay(items)

        assertTrue { items[0].quality == 8 }

    }

    @Test
    fun `quality should never be negative`() {
        val items = arrayOf(Item("foo", 0, 0))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 0 }
    }

    @Test
    fun `items quality should never exceed 50`() {
        val items = arrayOf(Item("foo", 0, 50))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality <= 50 }
    }

    @Test
    fun `sulfura's quality should always equal 80`() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 80 }
    }

    @Test
    fun `aged brie's quality increases with time`() {
        val items = arrayOf(Item("Aged Brie", 8, 45))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 46 }
    }

    @Test
    fun `aged brie's quality increases twice as fast when sellIn is passed`() {
        val items = arrayOf(Item("Aged Brie", -1, 45))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 47 }
    }

    @Test
    fun `aged brie's quality cannot reach over 50`() {
        val items = arrayOf(Item("Aged Brie", 0, 50))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 50 }
    }

    @Test
    fun `backstage pass quality cannot reach over 50`() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 8, 49))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 50 }
    }

    @Test
    fun `backstage pass quality increases by 2 when sellIn date is 10 or less`() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 8, 2))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 4 }
    }

    @Test
    fun `backstage pass quality increases by 3 when sellIn date is 5 or less`() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 4, 2))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 5 }
    }

    @Test
    fun `backstage pass quality drops to 0 when sellIn date becomes negative`() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", -1, 50))
        updateQualityByOneDay(items)
        assertTrue { items[0].quality == 0 }
    }
}


fun updateQualityByOneDay(items: Array<Item>) {
    val app = GildedRose(items)
    app.updateQuality()
}