package designpatterns

enum class WeirdUnits { Mile, Foot, Inch }

class MetricAdapter {
    fun getDistanceInMeters(nb: Double, unit: WeirdUnits): Double {
        return when (unit) {
            WeirdUnits.Mile -> nb * 1.852
            WeirdUnits.Foot -> nb * 0.3048
            WeirdUnits.Inch -> nb * 2.54
        }
    }
}