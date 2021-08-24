package com.oynix.room.sample

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * author: oynix
 * date: 2021/8/24 22:02
 * email: oynix@foxmail.com
 * description:
 */

@Database(
    entities = [
        Student::class,
        Teacher::class
    ],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    abstract fun teacherDao(): TeacherDao

}