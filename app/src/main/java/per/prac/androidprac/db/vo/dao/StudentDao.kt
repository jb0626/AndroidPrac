package per.prac.androidprac.db.vo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import per.prac.androidprac.db.vo.Student

@Dao
interface StudentDao {

    @Insert
    fun insertStudent(student: Student)

    @Query("DELETE FROM TB_STUDENT_MGMT")
    fun clear()

    @Query("SELECT * FROM TB_STUDENT_MGMT")
    fun getAll(): List<Student>

}