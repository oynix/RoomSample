package com.oynix.room.sample

import androidx.room.*

/**
 * author: oynix
 * date: 2021/8/24 22:02
 * email: oynix@foxmail.com
 * description:
 */

@Entity(tableName = "student", indices = [Index(value = ["num"], unique = true)])
data class Student(
    @PrimaryKey val id: Int,
    val num: Int, // 学号
    val name: String,
    val age: Int
)

@Dao
interface StudentDao {

    @Insert
    fun insert(student: Student): Long

    @Delete
    fun delete(student: Student): Int

    @Update
    fun update(student: Student): Int

    @Query("SELECT * FROM student WHERE num = :num")
    fun query(num: Int): Student?
}

@Entity(tableName = "teacher", indices = [Index(value = ["num"], unique = true)])
data class Teacher(
    @PrimaryKey val id: Int,
    val num: Int, // 教师编号
    val name: String,
    val course: String
)

@Dao
interface TeacherDao {
    @Insert
    fun insert(teacher: Teacher): Long

    @Delete
    fun delete(teacher: Teacher): Int

    @Update
    fun update(teacher: Teacher): Int

    @Query("SELECT * FROM teacher WHERE num = :num")
    fun query(num: Int): Teacher?
}