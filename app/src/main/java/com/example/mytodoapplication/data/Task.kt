package com.example.mytodoapplication.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity(tableName = "task_table")
@Parcelize
data class Task(
    val name:String,
    val important:Boolean= false,
    val completed:Boolean = false,
    val created:Long =System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id:Int=0
) :Parcelable{
    //parcelable enables you to transfer data between fragments easily
    val createDateFormatted:String
    get() = DateFormat.getDateTimeInstance().format(created);
}
