package com.x5s.room_assignment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.x5s.room_assignment.data.UserAccountDatabase
import com.x5s.room_assignment.data.UserRepository

class UserViewModel(context: Context) : ViewModel() {

    private val userRepository: UserRepository

    init {

        userRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao())
    }

    internal fun createUser(username: String, password: String) {
        userRepository.insertUser(username, password)
    }

    internal fun checkValidLogin(username: String, password: String): Boolean {
        return userRepository.isValidAccount(username, password)
    }

    class Factory internal constructor(ctxt: Context) : ViewModelProvider.Factory {
        private val ctxt: Context

        init {
            this.ctxt = ctxt.applicationContext
        }

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(ctxt) as T
        }
    }
}
