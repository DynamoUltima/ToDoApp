package com.example.mytodoapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mytodoapplication.data.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class],version = 1)
 abstract class TaskDatabase :RoomDatabase() {

     abstract fun taskDao():TaskDao

     class Callback @Inject constructor(
         private  val database:Provider<TaskDatabase>,
         @ApplicationScope private  val applicationScope: CoroutineScope
     ):RoomDatabase.Callback(){
         // this method will be executed only the first time we execute the database
         override fun onCreate(db: SupportSQLiteDatabase) {
             super.onCreate(db)

           val dao=database.get().taskDao()

             applicationScope.launch {
                 dao.insert(Task(name = "Wash the dishes"))
                 dao.insert(Task(name = "Do the Laundry",important = true))
                 dao.insert(Task(name = "Call Elon Musk",completed = true))
             }
         }
     }
}