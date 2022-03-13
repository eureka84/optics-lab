package com.eureka

import arrow.optics.optics
import java.time.Duration


@optics data class Airport(val name: String) { companion object }
@optics data class Leg(val departure: Airport, val arrival: Airport, val duration: Duration) { companion object }
@optics data class Flight(val outbound: Leg, val inbound: Leg? = null) { companion object }
@optics data class Trip(val flights: List<Flight>) { companion object }