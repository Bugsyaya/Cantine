package com.nantes.cantine

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.nantes.cantine.models.Menu
import com.nantes.cantine.models.Record

class MenuListActivity: Activity() {
    val client = Client()
    val strMessage = "https://data.nantesmetropole.fr/api/records/1.0/search/?dataset=244400404_menus-cantines-scolaires-nantes&q=&sort=date&facet=type_menu&timezone=Europe%2FParis"

    fun getMenu(): Menu {
        val result: Menu = client.run(strMessage)
        println("result $result")
        return result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)
        var simpleList: ListView? = null
        val menuList = getMenu().records.map { record: Record -> record.fields.repas }
        simpleList = findViewById(R.id.list_item)
        val arrayAdapter = ArrayAdapter(this, R.layout.activity_home, R.id.textView, menuList)
        simpleList!!.adapter = arrayAdapter
    }
}