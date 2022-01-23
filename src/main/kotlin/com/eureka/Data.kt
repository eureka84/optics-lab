package com.eureka

import arrow.optics.optics


@optics data class Airport(val name: String) { companion object }
@optics data class Leg(val departure: Airport, val arrival: Airport) { companion object }
@optics data class Flight(val outbound: Leg, val inbound: Leg? = null) { companion object }