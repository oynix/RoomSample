package com.oynix.room.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.commonsware.cwac.saferoom.SafeHelperFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(this, AppDatabase::class.java, "app.db")
            .allowMainThreadQueries()
            .openHelperFactory(SafeHelperFactory("05ATQ7LDT7yseeE51DBZ7RHR".toCharArray()))
            .addMigrations(object : Migration(1, 2){
                override fun migrate(database: SupportSQLiteDatabase) {
                    database.execSQL("CREATE TABLE IF NOT EXISTS `teacher` (`id` INTEGER NOT NULL, `num` INTEGER NOT NULL, `name` TEXT NOT NULL, `course` TEXT NOT NULL, PRIMARY KEY(`id`))")
                    database.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_teacher_num` ON `teacher` (`num`)")
                }
            })
            .build()
//        val dao = db.studentDao()
//        dao.insert(Student(1, 1, "John", 14))

//        val teacherDao = db.teacherDao()
//        teacherDao.insert(Teacher(1, 1001, "Miss Zhang", "Math"))
    }
}