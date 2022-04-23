package com.tristate.gasper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tristate.gasper.model.User
import com.tristate.gasper.R

class UserAdapter(private val mContext: Context, private val mUsers: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var username: TextView = itemView.findViewById(R.id.username)
        var profileImage: ImageView = itemView.findViewById(R.id.profile_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: User = mUsers[position]
        holder.username.text = user.username
        if (user.imageURI.equals("default")) {
            holder.profileImage.setImageResource(R.mipmap.ic_launcher)
        } else {
            Glide.with(mContext).load(user.imageURI).into(holder.profileImage)
        }
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }
}