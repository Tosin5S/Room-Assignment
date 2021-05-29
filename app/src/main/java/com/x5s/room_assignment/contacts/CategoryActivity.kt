package com.x5s.room_assignment.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.x5s.room_assignment.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCategoryBinding
    private var adapter = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //GridLayoutManager(this, 2, RecyclerView.VERTICAL,false).apply{
        //factListView.layoutManager = this

        //}
        setUpFact(binding)



    }

    private fun setUpFact(binding: ActivityCategoryBinding){
        adapter = CategoryAdapter()
        binding.factListView.adapter = adapter
        binding.factListView.layoutManager = GridLayoutManager(this,2)

    }


    //override fun onDestroy(){
    //super.onDestroy()
    //binding = null
    //}

}

