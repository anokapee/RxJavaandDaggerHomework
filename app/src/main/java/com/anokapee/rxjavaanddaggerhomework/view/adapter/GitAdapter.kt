package com.anokapee.rxjavaanddaggerhomework.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anokapee.rxjavaanddaggerhomework.databinding.GitItemLayoutBinding
import com.anokapee.rxjavaanddaggerhomework.model.data.GitResponseItem

class GitAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface GitDelegate{
        fun selectRepo(gitResponseItem: GitResponseItem)
    }

    inner class ListViewHolder(val binding: GitItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    var listGitResponseItem = listOf<GitResponseItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return ListViewHolder(
            GitItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val gitResponseItem = listGitResponseItem[position]
        
        holder.binding.repo.text = gitResponseItem.name

    }

    override fun getItemCount(): Int {
        return listGitResponseItem.size
    }
}