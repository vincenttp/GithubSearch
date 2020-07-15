package id.vincenttp.tikettest.presentation.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.vincenttp.tikettest.R
import id.vincenttp.tikettest.domain.entity.UserEntity

/**
 * Created by vincenttp on 15/07/20.
 */
class UserAdapter : PagedListAdapter<UserEntity, UserAdapter.UserViewHolder>(DIFF_CALLBACK) {

    class UserViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(userEntity: UserEntity) {
            val tet = view.findViewById<TextView>(R.id.tvUsername)
            tet.text = userEntity.login
        }
    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<UserEntity>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(
                oldConcert: UserEntity,
                newConcert: UserEntity
            ) = oldConcert.id == newConcert.id

            override fun areContentsTheSame(
                oldConcert: UserEntity,
                newConcert: UserEntity
            ) = oldConcert == newConcert
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        getItem(position)?.run(holder::bind)
    }
}