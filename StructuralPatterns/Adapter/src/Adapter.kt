import java.util.stream.Stream
import kotlin.streams.toList

//1
interface UsbTypeC
interface UsbMini
interface EUPlug
interface USPlug

fun powerOutlet() : USPlug {
    return object : USPlug {}
}

fun cellPhone(chargeCable: UsbTypeC) {
}

fun charger(plug: EUPlug) : UsbMini {
    return object : UsbMini {}
}
//extensions
fun USPlug.toEUPlug(): EUPlug {
    return object : EUPlug {}
}
fun UsbMini.toUSBTypeC(): UsbTypeC {
    return object : UsbTypeC {}
}

fun main() {
    //1
    cellPhone(charger(powerOutlet().toEUPlug()).toUSBTypeC())


    //2
    val list = listOf("a", "b", "c")
    streamProcessing(list.stream())


}

//2

fun <T> streamProcessing(stream: Stream<T>) {
    // Do something with stream
}
