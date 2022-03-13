package com.eureka

import arrow.optics.Lens
import arrow.optics.PEvery
import arrow.optics.dsl.every
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import java.time.Duration


class OpticsTest {

    private val flight = Flight(
        outbound = Leg(
            departure = Airport("MXP"),
            arrival = Airport("AMS"),
            duration = Duration.ofHours(2)
        )
    )

    @Test
    fun test() {
        val outboundDepartureName: Lens<Flight, String> = Flight.outbound.departure.name
        assertThat(
            outboundDepartureName.modify(flight) { "BGY" },
            equalTo(
                Flight(
                    outbound = Leg(
                        departure = Airport("BGY"),
                        arrival = Airport("AMS"),
                        duration = Duration.ofHours(2)
                    )
                )
            )
        )
    }

    @Test
    fun test2() {
        val trip = Trip(listOf(flight))

        val durationOvEveryOutboundFlight = Trip.flights.every(PEvery.list()).outbound.duration

        val modifiedTrip = durationOvEveryOutboundFlight.modify(trip) { originalDuration ->
            originalDuration.plus(Duration.ofMinutes(30))
        }

        assertThat(modifiedTrip.flights[0].outbound.duration, equalTo(Duration.ofMinutes(150)))
    }
}