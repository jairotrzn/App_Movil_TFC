import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ktx.toObject
import com.google.gson.Gson
import com.optic.app_movil_tfc.domain.model.Repuesto

data class Task(
    var id: String = "",
    var category: String = "",
    var color: String = "",
    var datos: ArrayList<String> = ArrayList(),
    var end: String = "",
    var lastDate: String = "",
    var name: String = "",
    var repuestos: ArrayList<Repuesto> = ArrayList(),
    var selectedFrencunce: String = "",
    var start: String = "",
    var state: String = "",


    ) {
    fun toJson(): String = Gson().toJson(
        Task(
            id,
            category,
            color, datos,
            end,
            lastDate,
            name,
            repuestos,
            selectedFrencunce,
            start,
            state,


            )
    )

    companion object {
        fun fromJson(data: String): Task = Gson().fromJson(data, Task::class.java)
    }
}