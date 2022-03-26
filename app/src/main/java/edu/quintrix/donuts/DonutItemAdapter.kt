package edu.quintrix.donuts

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.LayoutInflater
import android.view.ViewGroup
import edu.quintrix.donuts.R

class DonutItemAdapter : RecyclerView.Adapter<DonutItemAdapter.TaskItemViewHolder>() {

    var data = listOf<Donut>()
        // @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder =
        TaskItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class TaskItemViewHolder(val rootView: TextView) :
        RecyclerView.ViewHolder(rootView) {
        companion object {
            fun inflateFrom(parent: ViewGroup): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.donut_item, parent, false) as TextView
                return TaskItemViewHolder(view)
            }
        }

        fun bind(item: Donut) {
            rootView.text = item.taskName
        }
    }
}