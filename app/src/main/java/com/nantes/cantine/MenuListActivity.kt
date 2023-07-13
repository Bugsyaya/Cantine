package com.nantes.cantine

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.nantes.cantine.models.Menu
import com.nantes.cantine.view.model.MenuViewModel
import androidx.activity.viewModels


class MenuListActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val model: MenuViewModel by viewModels()
        model.getMenu().observe(this, Observer<Menu>{ menu ->
            // update UI
        })

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)
    }
}
