/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
class DogCardAdapter(private val context: Context?,private val layout: Int): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
        val dogInfo = DataSource.dogs

    class DogCardViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textName : TextView = view.findViewById(R.id.name)
        val textAge : TextView = view.findViewById(R.id.age)
        val textHobb : TextView = view.findViewById(R.id.hobbies)
        val imageView : ImageView = view.findViewById(R.id.dogImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        val layoutType = when(layout){
            Layout.HORIZONTAL -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)
            Layout.VERTICAL -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)
            Layout.GRID -> LayoutInflater.from(parent.context).inflate(R.layout.grid_list_item,parent,false)
            else -> LayoutInflater.from(parent.context).inflate(R.layout.vertical_horizontal_list_item,parent,false)
        }
        return DogCardViewHolder(layoutType)
        }


    override fun getItemCount(): Int = dogInfo.size

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {
        val itme = dogInfo[position]
        holder.imageView.setImageResource(itme.imageResourceId)
        holder.textName.text= itme.name
        holder.textAge.text="age : ${itme.age}"
        val resources = context?.resources
        holder.textHobb.text = resources?.getString(R.string.dog_hobbies, itme.hobbies)

    }
}
