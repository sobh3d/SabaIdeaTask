package com.sobhan.sabaideatask.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sobhan.sabaideatask.databinding.MovieRowItemBinding
import com.sobhan.sabaideatask.model.Datum

class MovieAdapter() : ListAdapter<Datum, RecyclerView.ViewHolder>(MovieDiffCallback()) {
    private var data = ArrayList<Datum?>()

    fun setResults(data: List<Datum?>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = MovieRowItemBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = data[position]
        val viewHolder = holder as MovieViewHolder
        if (data != null) {
            viewHolder.bind(data)
        }
    }


    class MovieViewHolder(
        private val binding: MovieRowItemBinding,
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(obj: Datum) {
            binding.movie = obj
            binding.executePendingBindings()
        }


    }
}

private class MovieDiffCallback : DiffUtil.ItemCallback<Datum>() {
    override fun areItemsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return newItem == oldItem
    }
}