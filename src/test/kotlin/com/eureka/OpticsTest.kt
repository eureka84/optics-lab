package com.eureka

import arrow.optics.Lens
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test


class OpticsTest {

    @Test
    fun test() {
        val flight = Flight(Leg(Airport("MXP"), Airport("AMS")))

        val outboundDepartureName: Lens<Flight, String> = Flight.outbound.departure.name

        Assert.assertThat(
            outboundDepartureName.modify(flight) { "BGY" },
            CoreMatchers.equalTo(Flight(Leg(Airport("BGY"), Airport("AMS"))))
        )
    }
}