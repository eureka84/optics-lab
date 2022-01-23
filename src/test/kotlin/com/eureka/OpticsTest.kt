package com.eureka

import arrow.optics.Lens
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Test


class OpticsTest {

    @Test
    fun test() {
        val flight = Flight(outbound = Leg(departure = Airport("MXP"), arrival = Airport("AMS")))

        val outboundDepartureName: Lens<Flight, String> = Flight.outbound.departure.name

        Assert.assertThat(
            outboundDepartureName.modify(flight) { "BGY" },
            CoreMatchers.equalTo(Flight(outbound = Leg(departure = Airport("BGY"), arrival = Airport("AMS"))))
        )
    }
}