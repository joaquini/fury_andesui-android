package com.mercadolibre.android.andesui.message.hierarchy

import com.mercadolibre.android.andesui.message.AndesMessage

/**
 * Utility class that does two things: Defines the possible styles an [AndesMessage] can take because it's an enum, as you can see.
 * But as a bonus it gives you the proper implementation so you don't have to make any mapping.
 *
 * You ask me with, let's say 'QUIET', and then I'll give you a proper implementation of that style.
 *
 * @property hierarchy Possible styles that an [AndesMessage] may take.
 */
enum class AndesMessageHierarchy {
    QUIET,
    LOUD;

    internal val hierarchy get() = getAndesMessageHierarchy()

    private fun getAndesMessageHierarchy(): AndesMessageHierarchyInterface {
        return when (this) {
            QUIET -> AndesQuietMessageHierarchy
            LOUD -> AndesLoudMessageHierarchy
        }
    }
}