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
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
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
        // TODO: Get the data at the current position
        val itme = dogInfo[position]
        // TODO: Set the image resource for the current dog
        holder.imageView.setImageResource(itme.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.textName.text= itme.name
        // TODO: Set the text for the current dog's age
        holder.textAge.text="age : ${itme.age}"
        val resources = context?.resources
        holder.textHobb.text = resources?.getString(R.string.dog_hobbies, itme.hobbies)
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)

    }
}
