package per.prac.androidprac.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import per.prac.androidprac.db.vo.Student
import per.prac.androidprac.db.vo.dao.StudentDao

@Database(entities = [Student::class], version = 1, exportSchema = true)
abstract class StudentDatabase : RoomDatabase() {

    abstract val studentDao: StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getInstance(c: Context): StudentDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        c,
                        StudentDatabase::class.java,
                        "Student MGMT database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}