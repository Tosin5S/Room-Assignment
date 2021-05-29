package com.x5s.room_assignment.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserAccountDao {

    @Insert
    fun insert(account: UserAccount)

    @Query("SELECT * FROM useraccounts WHERE useraccounts.userId LIKE :username")
    fun getAccount(username: String): UserAccount
}
