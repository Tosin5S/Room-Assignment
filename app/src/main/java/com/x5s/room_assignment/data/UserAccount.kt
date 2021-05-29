package com.x5s.room_assignment.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "useraccounts")
data class UserAccount
    (@PrimaryKey
     var userId: String,
     var password: String)
