import com.google.firebase.firestore.PropertyName
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.ktx.toObject
import com.optic.app_movil_tfc.domain.model.Repuesto

data class Task(
    @get:PropertyName("category")
    @set:PropertyName("category")
    var category: String = "",
    @get:PropertyName("end")
    @set:PropertyName("end")
    var end: String = "",
    @get:PropertyName("lastDate")
    @set:PropertyName("lastDate")
    var lastDate: String = "",
    @get:PropertyName("nameTarea")
    @set:PropertyName("nameTarea")
    var nameTarea: String = "",
    @get:PropertyName("selectedFrecunce")
    @set:PropertyName("selectedFrecunce")
    var selectedFrecunce: String = "",
    @get:PropertyName("start")
    @set:PropertyName("start")
    var start: String = "",
    @get:PropertyName("state")
    @set:PropertyName("state")
    var state: String = "",
    @get:PropertyName("datos")
    @set:PropertyName("datos")
    var datos: ArrayList<String> = ArrayList(),
    @get:PropertyName("repuestos")
    @set:PropertyName("repuestos")
    var repuestos: ArrayList<Repuesto> = ArrayList()
) {
    @get:Exclude
    @set:Exclude
    @Transient
    lateinit var documentReference: DocumentReference

    companion object {
        fun fromSnapshot(snapshot: DocumentSnapshot): Task {
            val task = snapshot.toObject<Task>()!!
            task.documentReference = snapshot.reference
            return task
        }
    }
}