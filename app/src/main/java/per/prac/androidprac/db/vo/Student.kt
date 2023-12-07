package per.prac.androidprac.db.vo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_STUDENT_MGMT")
data class Student(
    @PrimaryKey(autoGenerate = true)
    var no: Long,
    var name: String,
    var score: Int
)
