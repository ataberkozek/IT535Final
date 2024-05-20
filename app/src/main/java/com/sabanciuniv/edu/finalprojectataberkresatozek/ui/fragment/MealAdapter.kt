package com.sabanciuniv.edu.finalprojectataberkresatozek.ui.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sabanciuniv.edu.finalprojectataberkresatozek.R
import com.sabanciuniv.edu.finalprojectataberkresatozek.data.entity.Meal

class MealAdapter(private val meals: List<Meal>) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    inner class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mealName: TextView = itemView.findViewById(R.id.textViewYemekAd)
        private val mealPrice: TextView = itemView.findViewById(R.id.textViewYemekFiyat)
        private val mealImage: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(meal: Meal) {
            mealName.text = meal.yemek_adi
            mealPrice.text = "${meal.yemek_fiyat} ₺"
            val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${meal.yemek_resim_adi}"
            Glide.with(itemView.context).load(imageUrl).into(mealImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_tasarim, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    override fun getItemCount(): Int = meals.size
}
